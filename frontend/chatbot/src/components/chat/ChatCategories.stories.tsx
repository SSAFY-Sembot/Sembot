import type { Meta } from '@storybook/react';
import ChatCategories from './ChatCategories';

const meta: Meta<typeof ChatCategories> = {
  title: 'COMPONENTS/CHAT/ChatCategories',
  component: ChatCategories,
  parameters: {
    layout: 'centered',
  },
  tags: ['autodocs'],
};
export default meta;

export const Default = {
  args: {
    categories: [
      "포탈 시스템 문의", "경비 처리", "보안 관련 프로세스",
      "국내외 출장 관련", "인사 규정", "회사 복지 규정"
    ],
    onCategoryClick: ()=>console.log("카테고리 클릭")
  },
};