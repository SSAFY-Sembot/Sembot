import type { Meta, StoryObj } from "@storybook/react";

import Dropdown from "./Dropdown";

// More on how to set up stories at: https://storybook.js.org/docs/writing-stories#default-export
const meta = {
  title: "CHATBOT/Dropdown",
  component: Dropdown,
  parameters: {
    // Optional parameter to center the component in the Canvas. More info: https://storybook.js.org/docs/configure/story-layout
    layout: "centered",
  },
  // This component will have an automatically generated Autodocs entry: https://storybook.js.org/docs/writing-docs/autodocs
  tags: ["autodocs"],
} satisfies Meta<typeof Dropdown>;

export default meta;
type Story = StoryObj<typeof meta>;

export const Dropdown1: Story = {
  args: {
    items: ["전체", "제목", "작성자"],
    width: "8rem",
  },
};

export const Dropdown2: Story = {
  args: {
    items: ["전체", "제목", "작성자"],
    width: "10rem",
  },
};

export const Dropdown3: Story = {
  args: {
    items: ["전체", "카테고리1", "카테고리2"],
    width: "10rem",
  },
};