import type { Meta, StoryObj } from "@storybook/react";

import InputSearch from "./InputSearch";

const meta = {
  title: "COMPONENTS/ATOMS/INPUT/InputSearch",
  component: InputSearch,
  parameters: {
    layout: "centered",
  },
  tags: ["autodocs"],
} satisfies Meta<typeof InputSearch>;

export default meta;
type Story = StoryObj<typeof meta>;

export const InputSearch1: Story = {
  args: {
    placeholder: "입력하는 곳",
    iconPath: "/src/assets/icons/search.svg",
  },
};
