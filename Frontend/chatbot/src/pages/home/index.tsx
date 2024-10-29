import React from 'react';
import logo from '@/assets/images/logo-main.png';
import Sidebar from '@components/atoms/sidebar/Sidebar';
import { ButtonProps } from '@components/atoms/button/ButtonWithIcon'; // Adjust imports if needed

export interface LayoutProps {
  logoSrc: string;
  components: ButtonProps[];
  footerComponents: ButtonProps[];
  isRule: boolean;
}

const Layout: React.FC<LayoutProps> = ({ components, footerComponents, isRule }) => {
  return (
    <div className="flex h-screen">
      {/* Sidebar */}
      <Sidebar 
        components={components} 
        footerComponents={footerComponents} 
        isRule={isRule} 
      />

      {/* Main Content */}
      <div className="flex-1 flex items-center justify-center bg-gray-100">
        <div className="w-full max-w-[438px] text-center">
          <img 
            src={logo}
            alt="로고"
            className="w-full h-auto mb-4"
          />
          <h1 className="text-xl font-semibold mb-2">안녕하세요 SEMBOT입니다.</h1>
          <p className="text-gray-600">챗봇 서비스 이용을 원하시면 로그인 해주세요!</p>
        </div>
      </div>
    </div>
  );
};

export default Layout;
