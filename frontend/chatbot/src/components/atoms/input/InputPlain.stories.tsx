import type { Meta, StoryObj } from "@storybook/react";

import Input from "./InputPlain";

const meta = {
  title: "COMPONENTS/ATOMS/INPUT/Input",
  component: Input,
  parameters: {
    layout: "centered",
  },
  tags: ["autodocs"],
} satisfies Meta<typeof Input>;

export default meta;
type Story = StoryObj<typeof meta>;

export const InputPlain1: Story = {
  args: {
    placeholder: "입력하는 곳",
  },
};

export const InputPlain2: Story = {
  args: {
    placeholder: "Email",
    width: "100px",
    textColor: "#000f4f",
  },
};

export const InputPlain3: Story = {
  args: {
    placeholder: "Title",
    width: "400px",
    textColor: "#000f4f",
    backgroundColor: "#eeeeee",
  },
};
