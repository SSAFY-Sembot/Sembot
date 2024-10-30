import React, { useState } from "react";
import ButtonWithIcon from "../button/ButtonOnlyIcon";
import Dropdown from "../dropdown/Dropdown";

interface InputSearchProps {
	/** Input 필드에 표시될 메시지 */
	placeholder?: string;
	/** Input란의 너비 */
	width?: string;
	/** Input란의 글자 색 */
	textColor?: string;
	/** Input란의 배경 색 */
	backgroundColor?: string;
	/** Input란의 Border 색 */
	borderColor?: string;
	/** icon 경로 */
	iconPath?: string;
	/** icon click event 함수 */
	onIconClick?: (message: string) => void;
	/** 추가될 속성값 */
	className?: string;
}

const InputSearch: React.FC<InputSearchProps> = ({
	/** 기본 값 할당 */
	placeholder = "Search",
	width = "full",
	textColor = "#000000",
	backgroundColor = "#FFFFFF",
	borderColor = "#000000",
	iconPath = "/src/assets/icons/search.svg",
	onIconClick,
	className,
}) => {
	const [inputValue, setInputValue] = useState<string>("");

	const handleInputChange = (event: React.ChangeEvent<HTMLInputElement>) => {
		setInputValue(event.target.value);
	};

	const handleIconClick = () => {
		// 검색 버튼 클릭 시 처리할 로직
		console.log("검색 버튼 클릭:", inputValue);
	};

	return (
		<div
			className="flex items-center space-x-2 relative text-gray-600 w-full border border-gray-300 rounded-md"
			style={{ width }}
		>
			<Dropdown width="10rem" className="border-none" />
			<input
				type="text"
				value={inputValue}
				onChange={handleInputChange}
				placeholder={placeholder}
				className="rounded-md h-12 w-full px-5 pr-10 text-sm focus:outline-none focus:ring-0"
				style={{ color: textColor, backgroundColor, borderColor }}
			/>

			<div
				className={`absolute right-0 top-1/2 transform -translate-y-1/2 pr-3 ${className}`}
				onClick={handleIconClick}
			>
				{/** Button Component 활용*/}
				<ButtonWithIcon icon={iconPath} onClick={onIconClick} />
			</div>
		</div>
	);
};

export default InputSearch;
