import React from "react";
import ButtonChatting, { ButtonProps } from "./ButtonChatting";

export default {
	title: "COMPONENTS/ATOMS/BUTTON/Card",
	component: ButtonChatting,
	// 기본 args를 설정합니다.
	args: {
		btnName: "Chatting with AI",
	},
	// Storybook Controls를 통해서 수정 가능한 부분을 argTypes로 설정
	argTypes: {
		btnName: { control: "text", description: "버튼 이름" },
		onClick: {
			action: "버튼 클릭됨",
			description: "버튼 클릭 시 호출되는 함수",
		},
	},
	tags: ["autodocs"],
};

// 기본 스토리
export const Default = (args: ButtonProps) => <ButtonChatting {...args} />;

// 버튼 텍스트가 긴 경우
export const LongText = (args: ButtonProps) => <ButtonChatting {...args} />;
LongText.args = {
	btnName: "This is a long title that should be truncated",
};

// 버튼 클릭 확인
export const ClickableButton = (args: ButtonProps) => (
	<ButtonChatting {...args} />
);
ClickableButton.args = {
	btnName: "Clickable Button",
	onClick: () => alert("Button clicked!"),
};
