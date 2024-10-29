import React, { useEffect, useState } from "react";
import ButtonPrimary from "../button/ButtonPrimary";
import ButtonOnlyIcon from "../button/ButtonOnlyIcon";

export interface PagingProps {
	curPage: number;
	totalPage: number;
	onPageChange: (page: number) => void;
}

const Paging: React.FC<PagingProps> = ({
	curPage,
	totalPage,
	onPageChange,
}) => {
	const [pages, setPages] = useState<number[]>([]);

	const calculatePages = (currentPage: number): number[] => {
		const startPage: number = Math.floor((currentPage - 1) / 5) * 5 + 1;
		const endPage: number = Math.min(
			Math.floor((currentPage - 1) / 5) * 5 + 5,
			totalPage
		);

		const newPages = [];
		for (let i = startPage; i <= endPage; i++) {
			newPages.push(i);
		}
		return newPages;
	};

	useEffect(() => {
		setPages(calculatePages(curPage));
	}, [curPage, totalPage]); // dependency 추가

	const goToRight = () => {
		const nextPage = pages[pages.length - 1] + 1;
		if (nextPage <= totalPage) {
			onPageChange(nextPage);
		}
	};

	const goToLeft = () => {
		const prevPage = pages[0] - 1;
		if (prevPage > 0) {
			onPageChange(prevPage);
		}
	};

	const handlePageClick = (page: number) => {
		onPageChange(page);
	};

	const numberButtons: JSX.Element[] = pages.map((page) => (
		<ButtonPrimary
			key={page}
			btnName={page.toString()}
			styleName={`mx-1 ${
				curPage === page ? "bg-blue-500 text-white" : "bg-white"
			}`}
			handleClick={() => handlePageClick(page)}
		/>
	));

	return (
		<div className="flex items-center">
			<ButtonOnlyIcon
				key="left"
				icon="/src/assets/icons/prev-page.svg"
				onClick={goToLeft}
				disabled={pages[0] <= 1}
			/>
			{numberButtons}
			<ButtonOnlyIcon
				key="right"
				icon="/src/assets/icons/next-page.svg"
				onClick={goToRight}
				disabled={pages[pages.length - 1] >= totalPage}
			/>
		</div>
	);
};

export default Paging;
