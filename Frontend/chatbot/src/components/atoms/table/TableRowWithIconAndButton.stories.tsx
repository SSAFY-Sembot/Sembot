import type { Meta } from '@storybook/react';

import TableRowWithIconAndButton from './TableRowWithIconAndButton';

const meta: Meta<typeof TableRowWithIconAndButton> = {
  title: 'COMPONENTS/ATOMS/TABLE/TableRowWithIconAndButton',
  component: TableRowWithIconAndButton,
  parameters: {
    layout: 'centered',
  },
  tags: ['autodocs'],
};
export default meta;

export const User = {
  args: {
    columns: ["사번","이름","부서","회원레벨"],
    iconPath: "/src/assets/icons/user-profile-ex.svg",
    buttonLabel: "정보 변경",
    onButtonClick: ()=>console.log("정보 변경 모달 생성")
  },
};