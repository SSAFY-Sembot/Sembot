import React from 'react';
import { Meta, StoryObj } from '@storybook/react';
import CardWithLink, { CardWithLinkProps } from './CardWithLink';

const meta: Meta<typeof CardWithLink> = {
  title: 'Components/CardWithLink',
  component: CardWithLink,
  tags: ['autodocs'],  // 자동 문서화를 위해 사용
  argTypes: {
    content: { control: 'text' },
    resourceLink: { control: 'text' },
  },
};

export default meta;

type Story = StoryObj<CardWithLinkProps>;

export const Default: Story = {
  args: {
    content: '테스트 콘텐츠',
    resourceLink: 'https://example.com',
  },
};
