import type { Meta, StoryObj } from "@storybook/react";

import InputWithIcon from "./InputWithIcon";

// More on how to set up stories at: https://storybook.js.org/docs/writing-stories#default-export
const meta = {
  title: "COMPONENTS/ATOMS/INPUT/InputWithIcon",
  component: InputWithIcon,
  parameters: {
    // Optional parameter to center the component in the Canvas. More info: https://storybook.js.org/docs/configure/story-layout
    layout: "centered",
  },
  // This component will have an automatically generated Autodocs entry: https://storybook.js.org/docs/writing-docs/autodocs
  tags: ["autodocs"],
} satisfies Meta<typeof InputWithIcon>;

export default meta;
type Story = StoryObj<typeof meta>;

export const Chat: Story = {
  args: {
    placeholder: "입력하는 곳",
    iconPath: "/src/assets/icons/send.svg",
    onIconClick: (message : string)=>console.log(message),
    className: ""
  },
};
