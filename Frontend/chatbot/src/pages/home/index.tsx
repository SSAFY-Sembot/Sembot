import React from 'react';
import logo from '@/assets/images/logo-main.png';
import Sidebar from '@components/atoms/sidebar/Sidebar';
import { ButtonProps } from '@components/atoms/button/ButtonWithIcon'; // Adjust imports if needed
import styles from "./index.module.css";

export interface LayoutProps {
  logoSrc: string;
  components: ButtonProps[];
  footerComponents: ButtonProps[];
  isRule: boolean;
}

const Layout: React.FC<LayoutProps> = ({ components, footerComponents, isRule }) => {
  const handleLoginClick = () => {
    // Navigate to the login page
    // Implement navigation logic here (e.g., using useNavigate from react-router)
  };

  return (
    <div className="flex h-screen">
      {/* Sidebar */}
      <div className={styles.sidebarContainer}>
        <Sidebar 
          components={components} 
          footerComponents={footerComponents} 
          isRule={isRule} 
        />
      </div>

      {/* Main Content */}
      <div className="flex-1 flex items-center justify-center">
        <div className="w-full max-w-[438px] text-center">
          <img 
            src={logo}
            alt="로고"
            className="w-full h-auto mb-4"
          />
          <h1 className="text-xl font-semibold mb-2">안녕하세요 SEMBOT입니다.</h1>
          <p className="text-gray-600">
            챗봇 서비스 이용을 원하시면 <span 
              onClick={handleLoginClick} 
              className="text-[#004F9F] cursor-pointer underline"
            >
              로그인
            </span> 해주세요!
          </p>
        </div>
      </div>
    </div>
  );
};

export default Layout;
