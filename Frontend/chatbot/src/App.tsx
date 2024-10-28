import "./App.css";
import { Route, Routes } from "react-router-dom";
import ButtonPrimary from "./components/common/button/ButtonPrimary";
import ButtonWithIcon from "./components/common/button/ButtonWithIcon";
import plus from "./assets/icons/plus.svg";
import Devpage from "./Devpage";
import Paging from "@components/common/paging/Paging";
import { useState } from "react";

function App() {
	const [curPage, setCurPage] = useState(4);
	return (
		<>
			<Routes>
				{/* 아래와 같이 prop으로 배경색 동적처리 가능 */}
				<Route path="/" element={<Devpage />} />
				<Route
					path="/button"
					element={
						<ButtonPrimary
							btnName="Hello"
							styleName="bg-slate-500 rounded-lg py-3 px-6 font-sans text-xs font-bold uppercase text-white shadow-md hover:shadow-lg"
						/>
					}
				/>
				<Route
					path="/buttonicon"
					element={
						<ButtonWithIcon
							btnName="Hello"
							styleName="flex items-center justify-center middle none center rounded-lg bg-slate-300 py-3 px-6 font-sans text-xs font-bold uppercase text-white shadow-md shadow-pink-500/20 transition-all hover:shadow-lg hover:shadow-pink-500/40 focus:opacity-[0.85] focus:shadow-none active:opacity-[0.85] active:shadow-none disabled:pointer-events-none disabled:opacity-50 disabled:shadow-none"
							icon={plus}
						/>
					}
				/>
				<Route
					path="/paging"
					element={
						<Paging curPage={curPage} totalPage={8} onPageChange={setCurPage} />
					}
				/>
			</Routes>
		</>
	);
}

export default App;
