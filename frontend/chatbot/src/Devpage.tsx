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
				<li>
					<Link to="/paging">paging</Link>
				</li>
				<li>
					<Link to="/adminPage">admin page</Link>
				</li>
			</ul>
		</div>
	);
};

export default Devpage;
