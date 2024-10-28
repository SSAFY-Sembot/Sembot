import React from 'react';
import logo from '@/assets/images/logo-main.png'; // 로고 경로

export interface LayoutProps {
    logoSrc: string; // 로고 이미지 경로
}

const Layout: React.FC = () => {
    return (
        <div className="flex items-center justify-center h-screen bg-gray-100">
            <div className="w-full max-w-[438px] text-center"> {/* 텍스트와 이미지 컨테이너 */}
                <img 
                    src={logo}
                    alt="로고"
                    className="w-full h-auto mb-4" // 이미지 아래 여백 추가
                />
                {/* 텍스트 영역 */}
                <h1 className="text-xl font-semibold mb-2">안녕하세요 SEMBOT입니다.</h1> {/* 첫 번째 줄 텍스트 */}
                <p className="text-gray-600">챗봇 서비스 이용을 원하시면 로그인 해주세요!</p> {/* 두 번째 줄 텍스트 */}
            </div>
        </div>
    );
};

export default Layout;
