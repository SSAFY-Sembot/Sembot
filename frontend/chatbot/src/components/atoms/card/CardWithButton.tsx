import React from "react";
import xCircleButton from "@/assets/icons/x-circle.svg";

export interface CardWithButtonProps {
	content: string; // 버튼에 표시될 텍스트
	handleClick?: () => void;
}

const CardWithButton: React.FC<CardWithButtonProps> = ({
	content,
	handleClick = () => {},
}) => {
	return (
		<div className="flex items-center p-4 border border-gray-300 rounded-lg shadow-md">
			<div className="text-lg flex-grow">
				{content} {/* 전달된 content prop을 표시 */}
			</div>
			<img
				src={xCircleButton}
				alt="Link icon"
				className="w-5 h-5 ml-2 cursor-pointer"
				onClick={handleClick}
			/>{" "}
			{/* 아이콘 */}
		</div>
	);
};

export default CardWithButton;
