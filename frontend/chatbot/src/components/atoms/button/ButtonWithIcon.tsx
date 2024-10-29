import React from "react";

export interface ButtonProps {
	btnName: string;
	styleName: string;
	icon: string;
	handleClick: () => void;
	isActive: boolean;
}

const ButtonWithIcon: React.FC<ButtonProps> = ({
	btnName,
	styleName,
	icon,
	handleClick,
	isActive,
}) => {
	const activeStyle = isActive
		? "bg-white text-semesBlue"
		: "bg-gray-400 text-semesBlue";
	const combinedStyle = `${styleName} ${activeStyle}`;

	return (
		<div
			className={combinedStyle}
			data-ripple-light="true"
			onClick={handleClick}
		>
			<img src={icon} alt="icon" />
			{btnName}
		</div>
	);
};

export default ButtonWithIcon;
