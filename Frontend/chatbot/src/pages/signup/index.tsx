import React, { useState } from 'react';
import { SignUpDTO } from './SignUpDTO';
import logo from '@/assets/images/head-register.png';
import topLeftLogo from '@/assets/images/head-logo-group.png'; // Import your top-left logo
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
    const [termsAccepted, setTermsAccepted] = useState(false);

    const handleSubmit = (e: React.FormEvent) => {
        e.preventDefault();
        const formData: SignUpDTO = { email, name, department, password, passwordVerify };
        onSubmit(formData);
    };

    const handleEmailCheck = () => {
        // Implement email duplication check logic here
        console.log('Checking for email duplication:', email);
    };

    return (
        <div className="flex items-center justify-center py-12 px-4 sm:px-6 lg:px-8">
        {/* Top-left logo */}
        <img
            src={topLeftLogo}
            alt="Top Left Logo"
            className="absolute top-4 left-4 w-16 h-auto"
        />
            <div className="max-w-md mx-auto p-4 bg-white shadow-md rounded relative z-10">
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
                        <div className="flex items-center">
                            <input
                                type="email"
                                placeholder="Email"
                                value={email}
                                onChange={(e) => setEmail(e.target.value)}
                                className="border p-2 flex-grow" 
                                required
                            />
                            <ButtonPrimary
                                btnName="중복 확인"
                                styleName="ml-2 bg-[#004F9F] text-white text-xs p-2 rounded hover:bg-blue-700" // Reduced font size
                                handleClick={handleEmailCheck}
                            />
                        </div>
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
                            <option value="">선택</option>
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
                    <div className="mb-4 flex items-center">
                        <input 
                            type="checkbox" 
                            id="terms" 
                            checked={termsAccepted} 
                            onChange={() => setTermsAccepted(!termsAccepted)} 
                            required
                        />
                        <label htmlFor="terms" className="ml-2 text-sm text-gray-600">이용 약관의 동의합니다.</label>
                    </div>
                    <button type="submit" className="bg-[#004F9F] text-white p-2 rounded hover:bg-blue-700">
                        회원가입
                    </button>
                </form>
            </div>
        </div>
    );
}

export default SignUpForm;
