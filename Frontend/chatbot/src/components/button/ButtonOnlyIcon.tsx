export type ButtonProps = {
	icon: string;
	// width: string
	// TODO
	// onClick: () => void;
};

const ButtonWithIcon = ({ icon }: ButtonProps) => {
	return (
		<div
			data-ripple-light="true"
			// onClick={onClick}
		>
			<img src={icon}></img>
		</div>
	);
};

export default ButtonWithIcon;
