// userSlice.ts
import { createSlice, createAsyncThunk, PayloadAction } from "@reduxjs/toolkit";
import { LoginDTO } from "@pages/login/LoginDTO";
import { login as loginAPI } from "@apis/chat/userApi";
import axios from "axios";
import { UpdateUserDTO } from "@pages/admin/UpdateUserDto";
import { updateUser as updateUserAPI } from "@apis/chat/adminApi";
import { useDispatch } from "react-redux";
import { fetchMembersByPage } from "./memberSlice";
import { useAppDispatch } from "@app/hooks";
import { defaultAxios } from "@apis/common";

interface UserState {
	role: string | null;
	loading: boolean;
	error: string | null;
}

const initialState: UserState = {
	role: null,
	loading: false,
	error: null,
};

export const updateUser = createAsyncThunk(
	"user/updateUser",
	async (updateUser: UpdateUserDTO, { rejectWithValue }) => {
		try {
			const response = await updateUserAPI(updateUser);
			return response.data; // 성공 시 반환값
		} catch (error) {
			if (axios.isAxiosError(error) && error.response) {
				return rejectWithValue(error.response.data);
			}
			return rejectWithValue({ message: "Unexpected error occurred" });
		}
	}
);

// 비동기 thunk 함수로 로그인 처리
export const loginUser = createAsyncThunk(
	"user/loginUser",
	async (loginData: LoginDTO, { rejectWithValue }) => {
		try {
			// login API 호출
			const response = await loginAPI(loginData);

			const { token, role } = response.data;

			// 인증 토큰 설정
			localStorage.setItem("Authorization", token);
			localStorage.setItem("Role", role);

			// role과 token 반환
			return { role };
		} catch (error) {
			if (axios.isAxiosError(error) && error.response) {
				return rejectWithValue(error.response.data);
			}
			return rejectWithValue({ message: "Unexpected error occurred" });
		}
	}
);

// 로그아웃 요청
export const logoutUser = createAsyncThunk(
	"user/logoutUser",
	async (_, { rejectWithValue }) => {
		try {
			console.log("로그아웃 요청 시작");
			await defaultAxios.post(
				"/api/users/logout",
				{},
				{
					headers: {
						Authorization: localStorage.getItem("Authorization"),
					},
				}
			);
			console.log("로그아웃 요청 완료");
			localStorage.removeItem("Authorization");
			localStorage.removeItem("Role");
		} catch (error) {
			if (axios.isAxiosError(error) && error.response) {
				return rejectWithValue(error.response.data);
			}
			return rejectWithValue({ message: "Unexpected error occurred" });
		}
	}
);

const userSlice = createSlice({
	name: "user",
	initialState,
	reducers: {},
	extraReducers: (builder) => {
		builder
			.addCase(loginUser.pending, (state) => {
				state.loading = true;
				state.error = null;
			})
			.addCase(
				loginUser.fulfilled,
				(
					state,
					action: PayloadAction<{
						role: string;
					}>
				) => {
					console.log("Fulfilled Action Payload:", action.payload);
					state.loading = false;
					state.role = action.payload.role;
				}
			)
			.addCase(loginUser.rejected, (state, action: PayloadAction<any>) => {
				state.loading = false;
				state.error = action.payload?.message || "로그인 실패";
			})
			.addCase(updateUser.pending, (state) => {
				state.loading = true;
				state.error = null;
			})
			.addCase(updateUser.fulfilled, (state) => {
				state.loading = false;
			})
			.addCase(updateUser.rejected, (state, action: PayloadAction<any>) => {
				state.loading = false;
				state.error = action.payload?.message || "업데이트 실패";
			})
			.addCase(logoutUser.pending, (state) => {
				state.loading = true;
				state.error = null;
			})
			.addCase(logoutUser.fulfilled, (state) => {
				state.loading = false;
				state.role = null; // 로그아웃 시 role 초기화
			})
			.addCase(logoutUser.rejected, (state, action: PayloadAction<any>) => {
				state.loading = false;
				state.error = action.payload?.message || "로그아웃 실패";
			});
	},
});

export default userSlice.reducer;
