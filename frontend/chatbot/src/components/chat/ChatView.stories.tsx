import type { Meta } from '@storybook/react';
import ChatView from './ChatView';

const meta: Meta<typeof ChatView> = {
  title: 'COMPONENTS/CHAT/ChatView',
  component: ChatView,
  parameters: {
    layout: 'fullscreen',
  },
  tags: ['autodocs'],
};
export default meta;

export const Default = {
};