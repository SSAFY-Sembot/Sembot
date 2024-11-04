import type { Meta, StoryObj } from '@storybook/react';
// import { expect, userEvent, within } from '@storybook/test';
import Chat from './';

const meta: Meta<typeof Chat> = {
  title: 'PAGES/CHAT/Chat',
  component: Chat,
  parameters: {
    layout: 'fullscreen',
  },
  // tags: ['autodocs'],
};

export default meta;
type Story = StoryObj<typeof meta>;

export const Default: Story = {};

// More on interaction testing: https://storybook.js.org/docs/writing-tests/interaction-testing
// export const LoggedIn: Story = {
//   play: async ({ canvasElement }) => {
//     const canvas = within(canvasElement);
//     const loginButton = canvas.getByRole('button', { name: /Log in/i });
//     await expect(loginButton).toBeInTheDocument();
//     await userEvent.click(loginButton);
//     await expect(loginButton).not.toBeInTheDocument();

//     const logoutButton = canvas.getByRole('button', { name: /Log out/i });
//     await expect(logoutButton).toBeInTheDocument();
//   },
// };