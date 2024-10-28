import React from "react";
import ButtonWithIcon, { ButtonProps } from "./ButtonWithIcon";

export default {
	title: "COMPONENTS/ATOMS/BUTTON/ButtonWithIcon",
	component: ButtonWithIcon,
	// 여기서 기본 args를 설정합니다.
	args: {
		btnName: "Click Me",
		styleName: "flex bg-blue-500 text-white py-2 px-4 rounded",
		icon: "/src/assets/icons/plus.svg",
	},
	// Storybook Controls를 통해서 수정 가능한 부분을 argTypes로 설정
	argTypes: {
		btnName: { control: "text" },
		styleName: { control: "text" },
		icon: { control: "text" },
	},
	tags: ["autodocs"],
};

// 각 스토리는 아래와 같은 형태로 정의됩니다.
export const Default = (args: ButtonProps) => <ButtonWithIcon {...args} />;

export const RedButton = (args: ButtonProps) => <ButtonWithIcon {...args} />;
RedButton.args = {
	btnName: "Danger",
	styleName: "flex bg-red-500 text-white py-2 px-4 rounded",
};

export const LargeButton = (args: ButtonProps) => <ButtonWithIcon {...args} />;
LargeButton.args = {
	btnName: "Click Me",
	styleName: "flex bg-green-300 text-white py-4 px-8 rounded-lg text-xl",
};
