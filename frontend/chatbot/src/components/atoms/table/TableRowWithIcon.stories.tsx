import type { Meta } from '@storybook/react';

import TableRowWithIcon from './TableRowWithIcon';

const meta: Meta<typeof TableRowWithIcon> = {
  title: 'COMPONENTS/ATOMS/TABLE/TableRowWithIcon',
  component: TableRowWithIcon,
  parameters: {
    layout: 'centered',
  },
  tags: ['autodocs'],
};
export default meta;

export const Board = {
  args: {
    columns: ["","작성자","제목","등록일"],
    iconPath: "/src/assets/icons/favorite.svg",
    onIconClick: ()=>console.log("즐겨찾기 토글")
  },
};