import React from "react";
import CardWithButton from "@components/atoms/card/CardWithButton";
import ButtonWithIcon from "@components/atoms/button/ButtonWithIcon";
import { useState } from "react";

const initialContents = ["뉴진스♪", "아이브♨", "에스파♥", "프로미스나인★"];

const CategoryManagement = () => {
	const [contents, setContents] = useState(initialContents);

	const handleClick = (index: number) => {
		setContents((prevContents) => prevContents.filter((_, i) => i !== index));
	};

	return (
		<div className="flex flex-col items-center space-y-4">
			{" "}
			{/* flex-col로 세로 정렬, items-center로 중앙 정렬 */}
			{contents.map((content, index) => (
				<div className="w-[40%]" key={index}>
					<CardWithButton
						content={content}
						handleClick={() => {
							handleClick(index);
						}}
					/>
				</div>
			))}
			<ButtonWithIcon
				btnName="카테고리 추가"
				styleName="w-[40%] py-2 rounded-lg bg-gray-200"
				icon="/src/assets/icons/plus.svg"
				isFooter={true}
				handleClick={() => console.log("카테고리 추가 버튼 클릭")}
			/>
		</div>
	);
};

export default CategoryManagement;
