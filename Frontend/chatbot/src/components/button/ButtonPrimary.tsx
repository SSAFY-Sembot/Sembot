type ButtonProps = {
	btnName: string;
	bgColor: string;
	// TODO
	// onClick: () => void;
};

const ButtonPrimary = ({ btnName, bgColor }: ButtonProps) => {
	return (
		<div>
			<button
				className={`middle none center rounded-lg ${bgColor} py-3 px-6 font-sans text-xs font-bold uppercase text-white shadow-md shadow-pink-500/20 transition-all hover:shadow-lg hover:shadow-pink-500/40 focus:opacity-[0.85] focus:shadow-none active:opacity-[0.85] active:shadow-none disabled:pointer-events-none disabled:opacity-50 disabled:shadow-none`}
				data-ripple-light="true"
				// onClick={onClick}
			>
				{btnName}
			</button>
		</div>
	);
};

export default ButtonPrimary;
