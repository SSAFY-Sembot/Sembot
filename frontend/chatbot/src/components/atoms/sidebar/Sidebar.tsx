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
  components = [], // Default to empty array
  footerComponents = [], // Default to empty array
  isRule,
}) => {
	return (
		<div>
			<div className="w-full sidebar border-r bg-semesBlue">
				<div className="flex h-screen flex-col justify-between pt-2 pb-6">
					<div>
						{/* 공통 header */}
						<div className="w-full flex flex-row mb-2">
							<img src={SEMBOT_LOGO} alt="SEMBOT LOGO" />
							<div className="text-white text-xl mt-2 ml-1">SEMBOT</div>
						</div>

						{/* 추가되는 component */}
						<div className="w-full flex flex-col space-y-2">
							{components.map((buttonProps, index) => (
								<React.Fragment key={index}>
									<ButtonWithIcon key={index} {...buttonProps} />

									{index === 0 && isRule ? (
										<div className="text-white text-xl ml-4">규정 즐겨찾기</div>
									) : null}
								</React.Fragment>
							))}
						</div>
					</div>

          {/* Components */}
          <div className="w-full flex flex-col space-y-2">
            <hr className="mx-2 mb-3 border border-gray-100" />
            {/* {components.map((buttonProps, index) => (
              <React.Fragment key={index}>
                <ButtonWithIcon key={index} {...buttonProps} />
                {index === 0 && isRule ? <div className="text-white text-xl ml-4">규정 즐겨찾기</div> : null}
              </React.Fragment>
            ))} */}
            {footerComponents.map((buttonProps, index) => (
              <ButtonWithIcon key={index} {...buttonProps} />
            ))}
          </div>
        </div>

        {/* Footer */}
        <div>
          <hr className="mb-3 border border-gray-500" />
          <div className="w-full mb-3 flex flex-col space-y-2">
            {footerComponents.map((buttonProps, index) => (
              <ButtonWithIcon key={index} {...buttonProps} />
            ))}
          </div>
        </div>
      </div>
    </div>
  );
};

export default Sidebar;
