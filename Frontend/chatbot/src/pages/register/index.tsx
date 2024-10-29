import React, { useState } from 'react';
import { SignUpDTO } from './SignUpDTO';
import logo from '@/assets/images/head-register.png';
import headerLogo from '@/assets/images/head-logo-group.png'; // headerLogo import
import ButtonPrimary from '@components/atoms/button/ButtonPrimary';

export interface SignUpFormProps {
    onSubmit: (formData: SignUpDTO) => void;
}

const SignUpForm: React.FC<SignUpFormProps> = ({ onSubmit }) => {
    const [email, setEmail] = useState('');
    const [name, setName] = useState('');
    const [department, setDepartment] = useState('');
    const [password, setPassword] = useState('');
    const [passwordVerify, setPasswordVerify] = useState('');

    const handleSubmit = (e: React.FormEvent) => {
        e.preventDefault();
        const formData: SignUpDTO = { email, name, department, password, passwordVerify };
        onSubmit(formData);
    };

    return (
        <div className="max-w-md mx-auto p-4 bg-white shadow-md rounded relative"> {/* relative 추가 */}
            
            <div className="text-center mb-6">
                <img 
                    src={logo} 
                    alt="Logo" 
                    className="mx-auto mb-2 w-full max-h-32 h-auto object-contain" 
                />
            </div>
        
            <form onSubmit={handleSubmit} className="flex flex-col space-y-4">
                <div className="mb-4">
                    <label htmlFor="email" className="block text-sm font-medium text-gray-700">이메일</label>
                    <input
                        type="email"
                        placeholder="Email"
                        value={email}
                        onChange={(e) => setEmail(e.target.value)}
                        className="border p-2 w-full" 
                        required
                    />
                    <ButtonPrimary
                        btnName="중복 확인"
                        styleName='flex bg-blue-500 text-white py-2 px-4'
                    />
                </div>
                <div className="mb-4">
                    <label htmlFor="name" className="block text-sm font-medium text-gray-700">이름</label>
                    <input
                        type="text"
                        placeholder="Name"
                        value={name}
                        onChange={(e) => setName(e.target.value)}
                        className="border p-2 w-full" 
                        required
                    />
                </div>
                <div className="mb-4">
                    <label htmlFor="department" className="block text-sm font-medium text-gray-700">부서</label>
                    <select
                        id="department"
                        value={department}
                        onChange={(e) => setDepartment(e.target.value)}
                        required
                        className="mt-1 p-2 border border-gray-300 rounded w-full"
                    >
                        <option value="">Select</option>
                        <option value="인사">HR</option>
                        <option value="IT">Engineering</option>
                        <option value="마켓팅">Marketing</option>
                        <option value="영업">Sales</option>
                    </select>
                </div>
                <div className="mb-4">
                    <label htmlFor="password" className="block text-sm font-medium text-gray-700">비밀번호</label>
                    <input
                        type="password"
                        placeholder="Password"
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                        className="border p-2 w-full" 
                        required
                    />
                </div>
                <div className="mb-4">
                    <label htmlFor="passwordVerify" className="block text-sm font-medium text-gray-700">비밀번호 확인</label>
                    <input
                        type="password"
                        placeholder="Password"
                        value={passwordVerify}
                        onChange={(e) => setPasswordVerify(e.target.value)}
                        className="border p-2 w-full" 
                        required
                    />
                </div>
                <button type="submit" className="bg-blue-600 text-white p-2 rounded hover:bg-blue-700">
                    회원가입
                </button>
            </form>
        </div>
    );
}

export default SignUpForm;