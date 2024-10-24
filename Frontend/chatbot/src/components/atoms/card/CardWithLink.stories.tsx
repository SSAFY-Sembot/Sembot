// src/CardWithLink.stories.tsx
import React from 'react';
import CardWithLink, { CardWithLinkProps } from '@components/atoms/card/CardWithLink';
import { StoryFn, Meta } from '@storybook/react';

export default {
    title: 'Example/CardWithLink',
    component: CardWithLink,
} as Meta;

const Template: StoryFn<CardWithLinkProps> = (args) => <CardWithLink {...args} />;

export const Default = Template.bind({});
Default.args = {
    content: '이것은 카드의 내용입니다.',
    resourceLink: 'https://www.example.com',
};
