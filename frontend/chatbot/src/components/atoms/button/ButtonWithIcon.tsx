import React from "react";

export interface ButtonProps {
	btnName: string;
	styleName: string;
	icon: string;
	handleClick?: () => void;
	isActive?: boolean;
	isFooter?: boolean;
}

const ButtonWithIcon: React.FC<ButtonProps> = ({
	btnName,
	styleName,
	icon,
	handleClick,
	isActive,
	isFooter,
}) => {
	const activeStyle = isActive
		? "bg-white text-semesBlue"
		: "bg-gray-400 text-semesBlue";

	const footerStyle = isFooter ? "bg-semesBlue text-white" : "";
	const combinedStyle = `${styleName} ${activeStyle}`;
	const combinedFooterStyle = `${styleName} ${footerStyle}`;

	return (
		<div
			className={footerStyle == "" ? combinedStyle : combinedFooterStyle}
			data-ripple-light="true"
			onClick={handleClick}
		>
			<img src={icon} alt="icon" />
			{btnName}
		</div>
	);
};

export default ButtonWithIcon;
