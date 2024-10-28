import type { Meta } from "@storybook/react";

import TableHeader from "./TableHeader";

const meta: Meta<typeof TableHeader> = {
  title: 'COMPONENTS/TABLE/TableHeader',
  component: TableHeader,
  parameters: {
    layout: 'centered',
  },
  tags: ['autodocs'],
};
export default meta;

export const User = {
  args: {
    columns: ["사번","이름","부서","회원레벨"]
  },
};

export const Board = {
  args: {
    columns: ["작성자","제목","등록일"],
    width: "6rem"
  },
};
