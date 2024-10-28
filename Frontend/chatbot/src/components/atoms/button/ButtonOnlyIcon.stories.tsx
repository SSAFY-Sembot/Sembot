import React from "react";
import ButtonOnlyIcon, { ButtonProps } from "./ButtonOnlyIcon";

export default {
	title: "COMPONENTS/ATOMS/BUTTON/ButtonOnlyIcon",
	component: ButtonOnlyIcon,
	// 여기서 기본 args를 설정합니다.
	args: {
		icon: "/src/assets/icons/x-circle.svg",
	},
	// Storybook Controls를 통해서 수정 가능한 부분을 argTypes로 설정
	argTypes: {
		icon: { control: "text" },
	},
	tags: ["autodocs"],
};

// 각 스토리는 아래와 같은 형태로 정의됩니다.
export const Default = (args: ButtonProps) => <ButtonOnlyIcon {...args} />;
