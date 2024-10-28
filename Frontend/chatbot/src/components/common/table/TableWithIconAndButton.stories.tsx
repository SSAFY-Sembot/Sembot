import type { Meta } from '@storybook/react';

import TableWithIconAndButton from './TableWithIconAndButton';

const meta: Meta<typeof TableWithIconAndButton> = {
  title: 'COMPONENTS/TABLE/TableWithIconAndButton',
  component: TableWithIconAndButton,
  parameters: {
    layout: 'centered',
  },
  tags: ['autodocs'],
};
export default meta;

export const User = {
  args: {
    columns: ["","사번","이름","부서","회원레벨"],
    rows: [
      {
        columns:["사번1","이름1","부서1","1"],
        iconPath: "/src/assets/icons/user-profile-ex.svg"
      },
      {
        columns:["사번2","이름2","부서2dasdasdasdsada","2"],
        iconPath: "/src/assets/icons/user-profile-ex.svg"
      },
      {
        columns:["사번3","이름3","부서3","3"],
        iconPath: "/src/assets/icons/user-profile-ex.svg"
      }
    ],
    buttonOnClick: ()=>console.log("정보 변경 모달 생성")
  },
  parameters: {
    backgrounds: {
      default: 'black-bg', // 커스텀 배경 이름 설정
      values: [
        { name: 'black-bg', value: '#888888' }, // 원하는 배경색 지정
      ],
    },
  },
};