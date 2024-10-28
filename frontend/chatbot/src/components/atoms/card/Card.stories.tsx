import React from 'react';
import Card, { CardProps }  from './Card'; // CardProps를 import합니다.

// Storybook에서 컴포넌트를 정의
export default {
  title: 'COMPONENTS/ATOMS/CARD/Card', // 스토리북에서 보여줄 카테고리와 컴포넌트 이름
  component: Card,
};

// 기본 템플릿 설정
const Template = (args: CardProps) => <Card {...args} />; // args의 타입을 CardProps로 지정

// 기본 카드 스토리
export const Default = Template.bind({});
Default.args = {
  title: 'UI/UX Review Check', // 기본 제목
  content: "Because it's about motivating the doers. Because I'm here to follow my dreams and inspire others.", // 기본 내용
};
