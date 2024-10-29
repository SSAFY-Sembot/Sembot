import React, { useState } from "react";
import SembotLayout from "../SembotLayout"; // SembotLayout 컴포넌트 경로
import Analystics from "./analystics";

const SembotPage: React.FC = () => {
	const [activeButton, setActiveButton] = useState<string>("통계");

	const handleClick = (btnName: string) => {
		setActiveButton(btnName);
	};

	const handleClickFooter = (btnName: string) => {
		// Footer 버튼 클릭 시 동작 정의
		console.log(`${btnName} 버튼 클릭`);
	};

	const SidebarButtons = [
		{
			styleName: "flex py-2 px-4 rounded mx-1",
			btnName: "통계",
			icon: "/src/assets/icons/trending-up.svg",
			handleClick: () => handleClick("통계"),
			isActive: activeButton === "통계",
		},
		{
			styleName: "flex py-2 px-4 rounded mx-1",
			btnName: "회원 관리",
			icon: "/src/assets/icons/user-manage.svg",
			handleClick: () => handleClick("회원 관리"),
			isActive: activeButton === "회원 관리",
		},
		{
			styleName: "flex py-2 px-4 rounded mx-1",
			btnName: "피드백 관리",
			icon: "/src/assets/icons/like.svg",
			handleClick: () => handleClick("피드백 관리"),
			isActive: activeButton === "피드백 관리",
		},
		{
			styleName: "flex py-2 px-4 rounded mx-1",
			btnName: "카테고리 관리",
			icon: "/src/assets/icons/list.svg",
			handleClick: () => handleClick("카테고리 관리"),
			isActive: activeButton === "카테고리 관리",
		},
	];

	const FooterButtons = [
		{
			styleName: "flex py-2 px-4 rounded mx-1",
			btnName: "규정 확인",
			icon: "/src/assets/icons/book-open-text.svg",
			handleClick: () => handleClickFooter("규정 확인"),
			isFooter: true,
		},
		{
			styleName: "flex py-2 px-4 rounded mx-1",
			btnName: "로그아웃",
			icon: "/src/assets/icons/logout.svg",
			handleClick: () => handleClickFooter("로그아웃"),
			isFooter: true,
		},
	];

	const getChildren = () => {
		switch (activeButton) {
			case "통계":
				return <Analystics />;
		}
	};

	return (
		<SembotLayout
			title={activeButton}
			isRule={false}
			sidebarComponents={SidebarButtons}
			footerComponents={FooterButtons}
			children={getChildren()}
		/>
	);
};

export default SembotPage;
