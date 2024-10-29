import React from "react";
import ChattingIcon from "@/assets/icons/chatting-icon.svg";
import Delete from "@/assets/icons/delete.svg";
import Pen from "@/assets/icons/pen.svg";

export interface ButtonProps {
	btnName: string;
	handleClickChatroom?: () => void;
	handleClickPen?: () => void;
	handleClickDelete?: () => void;
	isActive: boolean;
}

const ButtonChatting: React.FC<ButtonProps> = ({
	btnName,
	handleClickChatroom,
	handleClickPen,
	handleClickDelete,
	isActive = false,
}) => {
	// 타이틀 길이 제한 함수
	const truncateTitle = (text: string) => {
		return text.length > 15 ? `${text.substring(0, 15)}...` : text;
	};

	return (
		<div
			onClick={handleClickChatroom}
			className={`flex items-center gap-2 w-[90%] p-2 rounded-md transition-colors duration-200 ${
				isActive ? "bg-white text-black" : "bg-gray-300 text-gray-500"
			} hover:bg-gray-200`}
		>
			<img src={ChattingIcon} className="w-5 h-5 flex-shrink-0"></img>
			<span className="text-sm font-medium truncate">
				{truncateTitle(btnName)}
			</span>
			<img
				src={Pen}
				onClick={handleClickPen}
				className="w-5 h-5 flex-shrink-0"
			></img>
			<img
				src={Delete}
				onClick={handleClickDelete}
				className="w-5 h-5 flex-shrink-0"
			></img>
		</div>
	);
};

export default ButtonChatting;
