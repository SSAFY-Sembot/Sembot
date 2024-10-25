import "./App.css";
import { Route, Routes } from "react-router-dom";
import ButtonPrimary from "./components/button/ButtonPrimary";
import ButtonWithIcon from "./components/button/ButtonWithIcon";
import plus from "./assets/icons/plus.svg";
import Devpage from "./Devpage";

function App() {
	return (
		<>
			<Routes>
				{/* 아래와 같이 prop으로 배경색 동적처리 가능 */}
				<Route path="/" element={<Devpage />} />
				<Route
					path="/button"
					element={<ButtonPrimary btnName="Hello" bgColor="bg-slate-300" />}
				/>
				<Route
					path="/buttonicon"
					element={
						<ButtonWithIcon
							btnName="Hello"
							bgColor="bg-slate-300"
							icon={plus}
						/>
					}
				/>
			</Routes>
		</>
	);
}

export default App;
