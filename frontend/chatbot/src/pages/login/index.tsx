import { useState } from "react";
import { LoginDTO } from "./LoginDTO";
import logo from '@/assets/images/logo-login.png';
import topLeftLogo from '@/assets/images/head-logo-group.png';
import ButtonPrimary from "@components/atoms/button/ButtonPrimary";

export interface LoginFormProps {
    onSubmit: (formData: LoginDTO) => void;
}

const LoginForm: React.FC<LoginFormProps> = ({ onSubmit }) => {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [rememberMe, setRememberMe] = useState(false);

    const handleSubmit = (e: React.FormEvent) => {
        e.preventDefault();
        const formData: LoginDTO = { email, password };
        onSubmit(formData);
    };

    return (
        <div className="flex items-center justify-center py-12 px-4 sm:px-6 lg:px-8">
            {/* Top-left logo */}
            <img
                src={topLeftLogo}
                alt="Top Left Logo"
                className="absolute top-4 left-4 w-16 h-auto"
            />

            <div className="max-w-md w-full p-4 bg-white shadow-md rounded">
                <div className="text-center mb-6">
                    <img
                        src={logo}
                        alt="Logo"
                        className="mx-auto mb-2 w-full max-h-32 h-auto object-contain"
                    />
                </div>

                <form onSubmit={handleSubmit} className="flex flex-col space-y-4">
                    <div className="mb-4">
                        <label htmlFor="email" className="block text-sm font-medium text-gray-700">이메일</label>
                        <input
                            type="email"
                            placeholder="Email"
                            value={email}
                            onChange={(e) => setEmail(e.target.value)}
                            className="border p-2 w-full"
                            required
                        />
                    </div>

                    <div className="mb-4">
                        <label htmlFor="password" className="block text-sm font-medium text-gray-700">비밀번호</label>
                        <input
                            type="password"
                            placeholder="Password"
                            value={password}
                            onChange={(e) => setPassword(e.target.value)}
                            className="border p-2 w-full"
                            required
                        />
                    </div>

                    {/* Remember Me checkbox */}
                    <div className="flex items-center mb-4">
                        <input
                            type="checkbox"
                            checked={rememberMe}
                            onChange={(e) => setRememberMe(e.target.checked)}
                            className="mr-2"
                        />
                        <label className="text-sm text-gray-700">로그인 정보 기억하기</label>
                    </div>
               {/* Login and Sign Up buttons */}
                    <div className="flex w-full">
                        {/* Left button - 로그인 */}
                        <div className="flex-1">
                            <ButtonPrimary 
                                btnName="로그인" 
                                handleClick={() => onSubmit({ email, password })} 
                                styleName="bg-[#004F9F] text-white py-2 px-4 rounded w-full" // Updated color
                                isDisabled={!email || !password}
                            />
                        </div>
                        {/* Right button - 회원가입하기 */}
                        <div className="flex-1">
                            <ButtonPrimary 
                                btnName="회원가입하기" 
                                handleClick={() => console.log("회원가입 페이지로 이동")}
                                styleName="bg-white text-[#004F9F] py-2 px-4 rounded w-full border" // Updated color
                                isDisabled={false}
                            />
                        </div>
                    </div>




                </form>
            </div>
        </div>
    );
};

export default LoginForm;
