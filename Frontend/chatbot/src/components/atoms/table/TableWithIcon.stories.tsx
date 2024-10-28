import type { Meta } from '@storybook/react';

import TableWithIcon from './TableWithIcon';

const meta: Meta<typeof TableWithIcon> = {
  title: 'COMPONENTS/ATOMS/TABLE/TableWithIcon',
  component: TableWithIcon,
  parameters: {
    layout: 'centered',
  },
  tags: ['autodocs'],
};
export default meta;

export const User = {
  args: {
    columns: ["","작성자","제목","등록일"],
    rows: [
      {
        columns:["작성자1","정말 긴 제목 입니다 제목제목제목제목제목제목제목제목제목제목제목제목제목제목","등록일1"],
      },
      {
        columns:["작성자2","제목2","등록일2"],
      },
      {
        columns:["작성자3","제목3","등록일3"],
      }
    ],
    iconPath: "/src/assets/icons/favorite.svg",
    iconOnClick: ()=>console.log("즐겨찾기 생성")
  },
  parameters: {
    backgrounds: {
      default: 'black-bg', // 커스텀 배경 이름 설정
      values: [
        { name: 'black-bg', value: '#ffffff' }, // 원하는 배경색 지정
      ],
    },
  },
};