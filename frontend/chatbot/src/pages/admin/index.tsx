import React, { useState } from "react";
import Sidebar from "@components/atoms/sidebar/Sidebar";
import Header from "@components/atoms/header/Header";
import ButtonWithIcon from "@components/atoms/button/ButtonWithIcon";
import styles from "./index.module.css";
import SimpleCardWithStatistics from "@components/atoms/card/SimpleCardWithStatistics";

type ButtonWithIconProps = React.ComponentProps<typeof ButtonWithIcon>;

const index: React.FC = () => {
	const [activeButton, setActiveButton] = useState<string>("통계");

	const handleClick = (btnName: string) => {
		setActiveButton(btnName);
	};

	const handleClickFooter = (btnName: string) => {};
	const SidebarButtons: ButtonWithIconProps[] = [
		{
			styleName: "flex py-2 px-4 rounded mx-1",
			btnName: "통계",
			icon: "/src/assets/icons/trending-up.svg",
			handleClick: () => handleClick("통계"),
			isActive: activeButton === "통계",
			isFooter: false,
		},
		{
			styleName: "flex py-2 px-4 rounded mx-1",
			btnName: "회원 관리",
			icon: "/src/assets/icons/user-manage.svg",
			handleClick: () => handleClick("회원 관리"),
			isActive: activeButton === "회원 관리",
			isFooter: false,
		},
		{
			styleName: "flex py-2 px-4 rounded mx-1",
			btnName: "피드백 관리",
			icon: "/src/assets/icons/like.svg",
			handleClick: () => handleClick("피드백 관리"),
			isActive: activeButton === "피드백 관리",
			isFooter: false,
		},
		{
			styleName: "flex py-2 px-4 rounded mx-1",
			btnName: "카테고리 관리",
			icon: "/src/assets/icons/list.svg",
			handleClick: () => handleClick("카테고리 관리"),
			isActive: activeButton === "카테고리 관리",
			isFooter: false,
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

	return (
		<div className={styles.container}>
			{/*사이드바*/}
			<div className={styles.sidebarContainer}>
				<Sidebar
					components={SidebarButtons}
					footerComponents={FooterButtons}
					isRule={false}
				/>
			</div>
			{/* 우측 컨텐츠 */}
			<div className={styles.rightContainer}>
				<div>
					<Header title={activeButton} />
				</div>
				<div>
					<div className="flex flex-row mt-50 justify-between space-x-50">
						<div className="mx-20">
							<SimpleCardWithStatistics
								svgIcon="/src/assets/icons/rules.svg"
								title="총 규정 수"
								// API 호출 후 넣어주기
								count={"150"}
							/>
						</div>
						<div className="mx-20">
							<SimpleCardWithStatistics
								svgIcon="/src/assets/icons/chats.svg"
								title="총 채팅 수"
								// API 호출 후 넣어주기
								count={"45,000"}
							/>
						</div>
						<div className="mx-20">
							<SimpleCardWithStatistics
								svgIcon="/src/assets/icons/return.svg"
								title="응답률"
								// API 호출 후 넣어주기
								count={"10.2%"}
							/>
						</div>
					</div>
				</div>
			</div>
		</div>
	);
};

export default index;
