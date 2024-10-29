// Layout.stories.tsx
import { Meta, Story } from "@storybook/react";
import SembotLayout, { SembotLayoutProps } from "./SembotLayout";

export default {
  title: "LAYOUT/SembotLayout",
  component: SembotLayout,
  argTypes: {
    title: { control: "text" },
    isRule: { control: "boolean" },
  },
  parameters: {
    layout: "fullscreen",
  },
} as Meta;

// Define a template for the Layout component
const Template: Story<SembotLayoutProps> = (args) => (
  <SembotLayout {...args}>
    <div className="p-6 bg-gray-100 h-full">Main content goes here</div>
  </SembotLayout>
);

// Default layout configuration
export const Default = Template.bind({});
Default.args = {
  title: "Default Layout Title",
  isRule: true,
  sidebarComponents: [
    {
      btnName: "규정목록",
      styleName: "flex bg-blue-500 text-white py-2 px-4 rounded mx-1",
      icon: "/src/assets/icons/plus.svg",
    },
    {
      btnName: "즐겨찾는 규정 1",
      styleName: "flex bg-blue-500 text-white py-2 px-4 rounded mx-1",
      icon: "/src/assets/icons/plus.svg",
    },
  ],
  footerComponents: [
    {
      btnName: "footer Click Me 1",
      styleName: "flex bg-blue-500 text-white py-2 px-4 rounded mx-1",
      icon: "/src/assets/icons/plus.svg",
    },
    {
      btnName: "footer Click Me 2",
      styleName: "flex bg-blue-500 text-white py-2 px-4 rounded mx-1",
      icon: "/src/assets/icons/plus.svg",
    },
  ],
};

// Layout without sidebar components
export const WithoutSidebarComponents = Template.bind({});
WithoutSidebarComponents.args = {
  title: "Layout Without Sidebar Components",
  isRule: true,
  sidebarComponents: [],
  footerComponents: [],
};
