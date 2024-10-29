export interface ButtonProps {
	btnName: string;
	styleName: string;
	icon: string;
	// width: string
	// TODO
	// onClick: () => void;
}

const ButtonWithIcon: React.FC<ButtonProps> = ({
	btnName,
	styleName,
	icon,
}) => {
	console.log(icon);
	return (
		<div
			className={styleName}
			data-ripple-light="true"
			// onClick={onClick}
		>
			<img src={icon}></img>
			<div>{btnName}</div>
		</div>
	);
};

export default ButtonWithIcon;
