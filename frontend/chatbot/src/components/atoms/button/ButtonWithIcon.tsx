export interface ButtonProps {
	btnName: string;
	styleName: string;
	icon: string;
	// width: string
	// TODO
	onClick?: () => void;
}

const ButtonWithIcon: React.FC<ButtonProps> = ({
	btnName,
	styleName,
	icon,
	onClick
}) => {
	console.log(icon);
	return (
		<div
			className={`space-x-2 ${styleName}`}
			data-ripple-light="true"
			onClick={onClick}
		>
			<img width="15rem" src={icon}></img>
			<div>{btnName}</div>
		</div>
	);
};

export default ButtonWithIcon;
