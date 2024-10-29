// Layout.tsx
import React from 'react';
import {Meta, StoryObj} from '@storybook/react';
import index, { LayoutProps } from '.';
import Layout from '.';


const meta: Meta<typeof Layout> = {
    title: 'PAGES/HOME/BEFORELOGIN',
    component: index
   
}

export default meta;

type Story = StoryObj<LayoutProps>;

export const Default: Story = {
    args: {
        logoSrc: 'C:\Users\SSAFY\Desktop\thirdProject\S11P31S102\Frontend\chatbot\src\assets\images\logo.png'
    }
}

