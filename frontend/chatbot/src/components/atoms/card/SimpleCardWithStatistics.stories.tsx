// SimpleCardWithStatistics.stories.tsx
import React from "react";
import { Meta, Story } from "@storybook/react";
import SimpleCardWithStatistics from "./SimpleCardWithStatistics";
import lightBulb from "/src/assets/icons/light-bulb.svg";

export default {
	title: "COMPONENTS/ATOMS/CARD/SimpleCardWithStatistics",
	component: SimpleCardWithStatistics,
} as Meta;

const Template: Story = () => (
	<SimpleCardWithStatistics
		svgIcon={lightBulb}
		title="총 규정 수"
		count={"120"}
	/>
);

export const Default = Template.bind({});
Default.args = {};
