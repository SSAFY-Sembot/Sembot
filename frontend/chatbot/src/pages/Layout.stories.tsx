import type { Meta, StoryObj } from "@storybook/react";

import Layout from "./Layout";

const meta = {
  title: "PAGES/Layout",
  component: Layout,
  parameters: {
    layout: "fullscreen",
  },
  tags: ["autodocs"],
} satisfies Meta<typeof Layout>;

export default meta;

type Story = StoryObj<typeof meta>;

export const Layout1: Story = {};
