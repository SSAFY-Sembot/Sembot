import React, {useState} from 'react';
import { SignUpDTO } from './SignUpDTO';

interface SignUpFormProps{
    onSubmit: (formData: SignUpDTO) => void;
}

const SignUpForm: React.FC<SignUpFormProps> = ({onSubmit}) =>{
    const [email, setEmail] = useState('');
    const [nickname, setNickname] = useState('');
    const [department, setdepartment] = useState('');
    const [password, setPassword] = useState('');
    const [passwordVerify, setPasswordVerify] = useState('');

    const handleSubmit = (e: React.FormEvent) => {
        e.preventDefault();
        const formData: SignUpDTO = {email,nickname,department,password,passwordVerify};
        onSubmit(formData);
    };

    return (
        <form onSubmit={handleSubmit} className="flex flex-col space-y-4">
            <input
                type="email"
                placeholder="이메일"
                value={email}
                onChange={(e) => setEmail(e.target.value)}
                className="border p-2"
                required
            />
            
            </form>
    )
}

export default SignUpForm;