export type ButtonProps = {
	btnName: string;
	styleName: string;
	icon: string;
	// width: string
	// TODO
	// onClick: () => void;
};

const ButtonWithIcon = ({ btnName, styleName, icon }: ButtonProps) => {
	console.log(icon);
	return (
		<div
			className={styleName}
			data-ripple-light="true"
			// onClick={onClick}
		>
			<img src={icon}></img>
			{btnName}
		</div>
	);
};

export default ButtonWithIcon;
