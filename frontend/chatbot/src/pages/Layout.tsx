// Layout Component
import React from "react";
import Header from "@components/atoms/header/Header";
import Sidebar from "@components/atoms/sidebar/Sidebar";
import ButtonWithIcon from "@components/atoms/button/ButtonWithIcon";

interface LayoutProps {
  children?: React.ReactNode;
  title?: string;
  isRule?: boolean;
  sidebarComponents?: React.ComponentProps<typeof ButtonWithIcon>[];
  footerComponents?: React.ComponentProps<typeof ButtonWithIcon>[];
}

const Layout: React.FC<LayoutProps> = ({
  children,
  title,
  isRule = true,
  sidebarComponents = [
    {
      btnName: "규정목록",
      styleName: "flex bg-blue-500 text-white py-2 px-4 rounded mx-1",
      icon: "/src/assets/icons/plus.svg",
    },
    {
      btnName: "즐겨찾는 규정 1",
      styleName: "flex bg-blue-500 text-white py-2 px-4 rounded mx-1",
      icon: "/src/assets/icons/plus.svg",
    },
  ],
  footerComponents = [
    {
      btnName: "footer Click Me 1",
      styleName: "flex bg-blue-500 text-white py-2 px-4 rounded mx-1",
      icon: "/src/assets/icons/plus.svg",
    },
    {
      btnName: "footer Click Me 2",
      styleName: "flex bg-blue-500 text-white py-2 px-4 rounded mx-1",
      icon: "/src/assets/icons/plus.svg",
    },
  ],
}) => {
  return (
    <div className="flex">
      <div className="w-[14%] h-full fixed left-0 top-0">
        <Sidebar
          components={sidebarComponents}
          footerComponents={footerComponents}
          isRule={isRule}
        />
      </div>

      <div className="absolute left-[14%] h-full right-0 top-0">
        <Header title={title} />
        <main className="flex-1 overflow-auto p-4">{children}</main>
      </div>
    </div>
  );
};

export default Layout;
