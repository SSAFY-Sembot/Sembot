import React from "react";
import { Meta, Story } from "@storybook/react";
import Index from "./index"; // Adjust the import path if necessary
import { SidebarProps } from "@components/atoms/sidebar/Sidebar";

// 기본 Sidebar 버튼과 푸터 버튼 목록
const SidebarButtons = [
	{
		styleName: "flex bg-blue-500 text-white py-2 px-4 rounded mx-1",
		btnName: "통계",
		icon: "/src/assets/icons/trending-up.svg",
	},
];

const FooterButtons = [
	{
		styleName: "flex bg-blue-500 text-white py-2 px-4 rounded mx-1",
		btnName: "설정",
		icon: "/src/assets/icons/settings.svg",
	},
	{
		styleName: "flex bg-blue-500 text-white py-2 px-4 rounded mx-1",
		btnName: "로그아웃",
		icon: "/src/assets/icons/logout.svg",
	},
];

// Storybook 기본 설정
export default {
	title: "PAGES/ADMIN",
	component: Index,
	parameters: {
		componentSubtitle: "메인 페이지용 Sidebar 컴포넌트",
	},
	argTypes: {
		isRule: { control: "boolean", description: "규정 즐겨찾기 표시 여부" },
	},
} as Meta;

// 기본 템플릿
const Template: Story<SidebarProps> = (args) => <Index {...args} />;

// Default 스토리
export const Default = Template.bind({});
Default.args = {
	components: SidebarButtons,
	footerComponents: FooterButtons,
	isRule: true,
};

// 규정 즐겨찾기 비활성화된 스토리
export const WithoutRuleBookmark = Template.bind({});
WithoutRuleBookmark.args = {
	components: SidebarButtons,
	footerComponents: FooterButtons,
	isRule: false,
};
