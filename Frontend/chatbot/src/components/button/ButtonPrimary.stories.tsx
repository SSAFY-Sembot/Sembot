import React from "react";
import ButtonPrimary, { ButtonProps } from "./ButtonPrimary";

export default {
	title: "Chatbot/ButtonPrimary",
	component: ButtonPrimary,
	// 여기서 기본 args를 설정합니다.
	args: {
		btnName: "Click Me",
		styleName: "bg-blue-500 text-white py-2 px-4 rounded",
	},
	// Storybook Controls를 통해서 수정 가능한 부분을 argTypes로 설정
	argTypes: {
		btnName: { control: "text" },
		styleName: { control: "text" },
	},
	tags: ["autodocs"],
};

// 각 스토리는 아래와 같은 형태로 정의됩니다.
export const Default = (args: ButtonProps) => <ButtonPrimary {...args} />;

export const RedButton = (args: ButtonProps) => <ButtonPrimary {...args} />;
RedButton.args = {
	btnName: "Danger",
	styleName: "bg-red-500 text-white py-2 px-4 rounded",
};

export const LargeButton = (args: ButtonProps) => <ButtonPrimary {...args} />;
LargeButton.args = {
	btnName: "Click Me",
	styleName: "bg-green-300 text-white py-4 px-8 rounded-lg text-xl",
};
