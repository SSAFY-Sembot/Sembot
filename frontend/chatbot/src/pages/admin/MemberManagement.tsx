import TableWithIconAndButton from "@components/atoms/table/TableWithIcon";

const header = ["", "사번", "이름", "부서", "회원레벨"];
const columns = ["ssafy_1", "김광현", "개발부", "3"];

// interface TableRowData {
// 	/** 테이블 data 배열 */
// 	columns: string[];
// 	/** 테이블 data icon 경로 */
// 	iconPath: string;
// }

const memberManagement = () => {
	const getTableRowData = () => {
		const TableRowDataList = [];
		TableRowDataList.push({
			id: 1,
			columns: columns,
			iconPath: "/src/assets/icons/user.svg",
		});
		return TableRowDataList;
	};

	return (
		<div className="w-[50%] left-[25%]">
			<TableWithIconAndButton columns={header} rows={getTableRowData()} />
		</div>
	);
};

export default memberManagement;
