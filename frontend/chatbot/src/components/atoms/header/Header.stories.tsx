import type { Meta } from "@storybook/react";

import Header from "./Header";

const meta: Meta<typeof Header> = {
  title: "COMPONENTS/ATOMS/HEADER/Header",
  component: Header,
  tags: ["autodocs"],
};
export default meta;

export const Header1 = {
  args: {
    title: "규정 목록",
    userName: "이싸피",
    userNumber: "87654321",
  },
};