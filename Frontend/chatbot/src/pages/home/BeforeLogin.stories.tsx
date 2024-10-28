// Layout.tsx
import React from 'react';
import {Meta, StoryObj} from '@storybook/react';
import BeforeLogin, { LayoutProps } from './BeforeLogin';
import Layout from './BeforeLogin';


const meta: Meta<typeof Layout> = {
    title: 'COMPONENTS/PAGES/HOME/BEFORELOGIN',
    component: BeforeLogin,
    tags: ['autodocs'],  // 자동 문서화를 위해 사용
    argTypes: {
      content: { control: 'text' },
      resourceLink: { control: 'text' },
    },
}

export default meta;

type Story = StoryObj<LayoutProps>;

export const Default: Story = {
    args: {
        logoSrc: 'C:\Users\SSAFY\Desktop\thirdProject\S11P31S102\Frontend\chatbot\src\assets\images\logo.png'
    }
}

