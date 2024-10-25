export type ButtonProps = {
	btnName: string;
	styleName: string;
	// TODO
	// onClick: () => void;
};

const ButtonPrimary = ({ btnName, styleName }: ButtonProps) => {
	console.log(styleName);
	return (
		<div>
			<button
				className={styleName}
				data-ripple-light="true"
				// onClick={onClick}
			>
				{btnName}
			</button>
		</div>
	);
};

export default ButtonPrimary;
