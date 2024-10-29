import { Meta, Story } from "@storybook/react";
import Sidebar from "./Sidebar"; // Adjust path if necessary

// main page가 채팅방
const componentsList = [
	{
		btnName: "새채팅",
		styleName: "flex bg-blue-500 text-white py-2 px-4 rounded mx-1",
		icon: "/src/assets/icons/plus.svg",
	},
	{
		btnName: "채팅방1",
		styleName: "flex bg-blue-500 text-white py-2 px-4 rounded mx-1",
		icon: "/src/assets/icons/plus.svg",
	},
	{
		btnName: "채팅방2",
		styleName: "flex bg-blue-500 text-white py-2 px-4 rounded mx-1",
		icon: "/src/assets/icons/plus.svg",
	},
	// 추가 컴포넌트 데이터들
];

// main page가 규정 목록일 때
// const componentsList = [
//   {
//     btnName: "규정목록",
//     styleName: "flex bg-blue-500 text-white py-2 px-4 rounded mx-1",
//     icon: "/src/assets/icons/plus.svg",
//   },
//   {
//     btnName: "즐겨찾는 규정 1",
//     styleName: "flex bg-blue-500 text-white py-2 px-4 rounded mx-1",
//     icon: "/src/assets/icons/plus.svg",
//   },
//   {
//     btnName: "즐겨찾는 규정 2",
//     styleName: "flex bg-blue-500 text-white py-2 px-4 rounded mx-1",
//     icon: "/src/assets/icons/plus.svg",
//   },
//   // 추가 컴포넌트 데이터들
// ];

const footerComponentsList = [
	{
		btnName: "footer Click Me 1",
		styleName: "flex bg-blue-500 text-white py-2 px-4 rounded mx-1",
		icon: "/src/assets/icons/plus.svg",
	},
	{
		btnName: "footer Click Me 2",
		styleName: "flex bg-blue-500 text-white py-2 px-4 rounded mx-1",
		icon: "/src/assets/icons/plus.svg",
	},
	// 추가 컴포넌트 데이터들
];

// Meta information for Storybook
export default {
	title: "COMPONENTS/ATOMS/SIDEBAR/Siderbar",
	component: Siderbar,
} as Meta;

// Template for the story
const Template: Story = () => (
	<Siderbar
		components={componentsList}
		footerComponents={footerComponentsList}
		isRule={false}
	/>
);

// Default story
export const Default = Template.bind({});
Default.args = {};
