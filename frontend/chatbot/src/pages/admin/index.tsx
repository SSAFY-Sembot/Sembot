import React, { useState } from "react";
import Sidebar from "@components/atoms/sidebar/Sidebar";
import ButtonWithIcon from "@components/atoms/button/ButtonWithIcon";
import styles from "./index.module.css";

type ButtonWithIconProps = React.ComponentProps<typeof ButtonWithIcon>;

const index: React.FC = () => {
	const [activeButton, setActiveButton] = useState<string>("통계");

	const handleClick = (btnName: string) => {
		setActiveButton(btnName);
	};
	const SidebarButtons: ButtonWithIconProps[] = [
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

	return (
		<div className={styles.container}>
			<div className={styles.sidebarContainer}>
				<Sidebar
					components={SidebarButtons}
					footerComponents={[]}
					isRule={false}
				/>
			</div>
		</div>
	);
};

export default index;
