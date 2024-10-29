// FeedbackCardWithHashtag.stories.tsx
import React from "react";
import { Meta, Story } from "@storybook/react";
import FeedbackCardWithHashtag from "./FeedbackCardWithHashtag";

export default {
  title: "COMPONENTS/ATOMS/CARD/FeedbackCardWithHashtag",
  component: FeedbackCardWithHashtag,
} as Meta;

const Template: Story = () => (
  <FeedbackCardWithHashtag
    question="간단한 질문 내용"
    answer="질의에 대한 답변"
    hashtags={["부정확", "내용불충분"]}
  />
);

export const Default = Template.bind({});
Default.args = {};
