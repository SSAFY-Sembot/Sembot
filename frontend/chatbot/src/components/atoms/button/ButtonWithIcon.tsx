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
	const combinedStyle = `space-x-2 ${styleName} ${activeStyle}`;
	const combinedFooterStyle = `space-x-2 ${styleName} ${footerStyle}`;

	return (
		<div
			className={footerStyle == "" ? combinedStyle : combinedFooterStyle}
			data-ripple-light="true"
			onClick={handleClick}
		>
			<img width="15rem" src={icon}></img>
			<div>{btnName}</div>
		</div>
	);
};

export default ButtonWithIcon;
