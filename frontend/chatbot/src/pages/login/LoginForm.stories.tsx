import { Meta, StoryObj } from "@storybook/react";
import LoginForm, { LoginFormProps } from ".";
import { LoginDTO } from "./LoginDTO";


const meta: Meta<typeof LoginForm> ={
    title: 'Pages/LOGIN/LOGINFORM',
    component: LoginForm,
};

export default meta;


type Story = StoryObj<LoginFormProps>;

export const Default: Story = {
    args: {
        onSubmit: (formData: LoginDTO) => {
            console.log('로그인 데이터:', formData);
        },
    },
}