import { Component } from "react";
import SignUpForm, { SignUpFormProps } from ".";
import { Meta, StoryObj } from "@storybook/react";
import { SignUpDTO } from "./SignUpDTO";


const meta: Meta<typeof SignUpForm> ={
    title: 'Pages/SignUpForm',
    component: SignUpForm,
};

export default meta;


type Story = StoryObj<SignUpFormProps>;

export const Default: Story = {
    args: {
        onSubmit: (formData: SignUpDTO) => {
            console.log('회원가입 데이터:', formData);
        },
    },
}