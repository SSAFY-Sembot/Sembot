export type ButtonProps = {
	btnName: string;
	styleName?: string;
	// TODO
	handleClick?: () => void;
	isDisabled?: boolean;
};

const ButtonPrimary = ({
	btnName,
	styleName = "bg-white-100",
	handleClick,
	isDisabled = false,
}: ButtonProps) => {
	return (
		<div>
			<button
				className={styleName}
				data-ripple-light="true"
				onClick={handleClick}
				disabled={isDisabled}
			>
				{btnName}
			</button>
		</div>
	);
};

export default ButtonPrimary;
