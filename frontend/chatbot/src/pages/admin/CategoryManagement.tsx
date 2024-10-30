import React from "react";
import CardWithButton from "@components/atoms/card/CardWithButton";
import ButtonWithIcon from "@components/atoms/button/ButtonWithIcon";

const contents = ["뉴진스♪", "아이브♨", "에스파♥", "프로미스나인★"];

const CategoryManagement = () => {
	return (
		<div className="flex flex-col items-center space-y-4">
			{" "}
			{/* flex-col로 세로 정렬, items-center로 중앙 정렬 */}
			{contents.map((content) => (
				<div className="w-[40%]" key={content}>
					<CardWithButton content={content} />
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
