// newIndexPage.stories.tsx
import React from "react";
import { Meta, Story } from "@storybook/react";
import BoardListPage from "./index";

export default {
  title: "Pages/BOARD/BOARDLISTPAGE",
  component: BoardListPage,
  parameters: {
    layout: "fullscreen",
  },
} as Meta;

const Template: Story = () => <BoardListPage />;

export const Default = Template.bind({});
Default.args = {};
