import type { Meta, StoryObj } from "@storybook/react";

import RegulationPage from "./[id]";

const meta = {
  title: "PAGES/BOARD/RegulationPage",
  component: RegulationPage,
  parameters: {
    layout: "fullscreen",
  },
  tags: ["autodocs"],
} satisfies Meta<typeof RegulationPage>;

export default meta;

type Story = StoryObj<typeof meta>;

export const RegulationPage1: Story = {};
