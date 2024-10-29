import React from "react";
import SEMBOT_LOGO from "@/assets/images/logo.png";
import ButtonWithIcon from "@components/atoms/button/ButtonWithIcon";

type ButtonWithIconProps = React.ComponentProps<typeof ButtonWithIcon>;

interface SidebaProps {
  components: ButtonWithIconProps[]; // 메인 컴포넌트 리스트
  footerComponents: ButtonWithIconProps[]; // 하단에 위치할 컴포넌트 리스트
  isRule: boolean; // 현재 메인페이지가 규정인지, 채팅인지 확인하는 변수
}

const Sidebar: React.FC<SidebaProps> = ({
  components,
  footerComponents,
  isRule,
}) => {
  return (
    <div>
      <div className="w-full sidebar border-r w-56 bg-semesBlue">
        <div className="flex h-screen flex-col justify-between pt-2 pb-6">
          <div>
            {/* 공통 header */}
            <div className="w-full p-2.5 flex flex-row">
              <img src={SEMBOT_LOGO} alt="SEMBOT LOGO" />
              <div className="text-white text-3xl mt-2 ml-2">SEMBOT</div>
            </div>

            {/* 추가되는 component */}
            <div className="w-full flex flex-col space-y-2">
              {components.map((buttonProps, index) => (
                <React.Fragment key={index}>
                  <ButtonWithIcon key={index} {...buttonProps} />

                  {index === 0 && isRule ? <div className="text-white text-xl ml-4">규정 즐겨찾기</div> : null}
                </React.Fragment>
              ))}
            </div>
          </div>

          {/* footer */}
          <div>
            {/* 구분선 */}
            <hr className="mb-3 border border-gray-500" />
            <div className="w-full mb-3 flex flex-col space-y-2">
              {footerComponents.map((buttonProps, index) => (
                <ButtonWithIcon key={index} {...buttonProps} />
              ))}
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Sidebar;
