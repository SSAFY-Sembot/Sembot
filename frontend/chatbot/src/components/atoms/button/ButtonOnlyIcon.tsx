export type ButtonProps = {
	icon: string;
	styleName?: string;
	// width: string
	// TODO
	onClick?: () => void;
};

const ButtonWithIcon = ({ icon, styleName, onClick }: ButtonProps) => {
	return (
		<div data-ripple-light="true" className={styleName} onClick={onClick}>
			<img src={icon}></img>
		</div>
	);
};

export default ButtonWithIcon;
