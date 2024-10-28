import { Meta, StoryObj } from "@storybook/react";
import CardWithButton, { CardWithButtonProps } from "./CardWithButton";

const meta: Meta<typeof CardWithButton> = {
title: 'Components/CardWithButton',
component: CardWithButton,
tags: ['autodocs'],
argTypes: {
content: {control: 'text'}
},
};

export default meta;

type Story = StoryObj<CardWithButtonProps>;

export const Default: Story = {
args: {
content: '카테고리'
}
};