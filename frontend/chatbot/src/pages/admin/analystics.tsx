import SimpleCardWithStatistics from "@components/atoms/card/SimpleCardWithStatistics";
import { Tooltip } from "@material-tailwind/react";
import {
	Bar,
	BarChart,
	CartesianGrid,
	Legend,
	Line,
	LineChart,
	ResponsiveContainer,
	XAxis,
	YAxis,
} from "recharts";

const Analystics = () => {
	const categoryData = [
		{ name: "유류비", 규정수: 30 },
		{ name: "휴가", 규정수: 45 },
		{ name: "부서이동", 규정수: 75 },
		{ name: "퇴직금", 규정수: 50 },
		{ name: "공가", 규정수: 95 },
		{ name: "퇴사", 규정수: 60 },
	];

	const dailyChatData = [
		{ date: "24.10.16", 채팅수: 100 },
		{ date: "24.10.17", 채팅수: 150 },
		{ date: "24.10.18", 채팅수: 200 },
		{ date: "24.10.19", 채팅수: 300 },
		{ date: "24.10.20", 채팅수: 250 },
		{ date: "24.10.21", 채팅수: 350 },
	];

	return (
		<div>
			<div className="flex flex-row mb-6 justify-between mx-20">
				<SimpleCardWithStatistics
					svgIcon="/src/assets/icons/rules.svg"
					title="총 규정 수"
					count={"150"}
				/>
				<SimpleCardWithStatistics
					svgIcon="/src/assets/icons/chats.svg"
					title="총 채팅 수"
					count={"45,000"}
				/>
				<SimpleCardWithStatistics
					svgIcon="/src/assets/icons/return.svg"
					title="응답률"
					count={"10.2%"}
				/>
			</div>

			{/* Chart 영역 */}
			<div className="flex flex-row justify-between mx-20">
				{/* 카테고리별 규정 수 막대그래프 */}
				<div style={{ width: "45%", height: 300 }}>
					<h3 className="text-center mb-4">카테고리별 규정 수</h3>
					<ResponsiveContainer width="100%" height="100%">
						<BarChart data={categoryData}>
							<CartesianGrid strokeDasharray="3 3" />
							<XAxis dataKey="name" />
							<YAxis />
							<Tooltip />
							<Legend />
							<Bar dataKey="규정수" fill="#FFA726" />
						</BarChart>
					</ResponsiveContainer>
				</div>

				{/* 일별 채팅 수 라인 차트 */}
				<div style={{ width: "45%", height: 300 }}>
					<h3 className="text-center mb-4">일별 채팅 수</h3>
					<ResponsiveContainer width="100%" height="100%">
						<LineChart data={dailyChatData}>
							<CartesianGrid strokeDasharray="3 3" />
							<XAxis dataKey="date" />
							<YAxis />
							<Tooltip />
							<Legend />
							<Line
								type="monotone"
								dataKey="채팅수"
								stroke="#29B6F6"
								strokeWidth={2}
							/>
						</LineChart>
					</ResponsiveContainer>
				</div>
			</div>
		</div>
	);
};

export default Analystics;
