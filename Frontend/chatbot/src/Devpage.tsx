import { Link } from "react-router-dom";

const Devpage = () => {
	return (
		<div>
			<ul>
				<li>
					<Link to="/button">btn-primary</Link>
				</li>
				<li>
					<Link to="/buttonicon">btn-w-icon</Link>
				</li>
			</ul>
		</div>
	);
};

export default Devpage;
