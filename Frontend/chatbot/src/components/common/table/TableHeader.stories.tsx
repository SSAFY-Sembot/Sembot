import type { Meta, StoryObj } from '@storybook/react';

import TableHeader from './TableHeader';


// More on how to set up stories at: https://storybook.js.org/docs/writing-stories#default-export
const meta = {
  title: 'CHATBOT/TableHeader',
  component: TableHeader,
  parameters: {
    // Optional parameter to center the component in the Canvas. More info: https://storybook.js.org/docs/configure/story-layout
    layout: 'centered',
  },
  // This component will have an automatically generated Autodocs entry: https://storybook.js.org/docs/writing-docs/autodocs
  tags: ['autodocs']
} satisfies Meta<typeof TableHeader>;

export default meta;
type Story = StoryObj<typeof meta>;

export const User: Story = {
  args: {
    columns: ["사번","이름","부서","회원레벨"]
  },
};

export const Board: Story = {
  args: {
    columns: ["작성자","제목","등록일"],
    width: "6rem"
  },
};
