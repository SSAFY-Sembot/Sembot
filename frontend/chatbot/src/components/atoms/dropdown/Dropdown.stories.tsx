import type { Meta, StoryObj } from "@storybook/react";

import Dropdown from "./Dropdown";

const meta = {
  title: "COMPONENTS/ATOMS/DROPDOWN/Dropdown",
  component: Dropdown,
  parameters: {
    layout: "centered",
  },
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
