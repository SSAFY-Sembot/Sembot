import React, { useState, useEffect } from "react";
import Dropdown from "@components/atoms/dropdown/Dropdown";
import FeedbackCardWithHashtag from "@components/atoms/card/FeedbackCardWithHashtag";
import Paging from "@components/atoms/paging/Paging";

const items = ["긍정", "부정"];

const FeedbackManagement = () => {
	const [curPage, setCurPage] = useState(1);
	const [cardsPerPage, setCardsPerPage] = useState(6); // 초기값은 6으로 설정

	// 뷰포트 높이에 따라 cardsPerPage를 계산하는 함수
	const calculateCardsPerPage = () => {
		const viewportHeight = window.innerHeight;
		// 예시: 뷰포트 높이 800px 이하에서는 4개, 1200px 이하에서는 6개, 그 이상에서는 8개
		console.log(cardsPerPage);

		if (viewportHeight < 800) return 6;
		else if (viewportHeight < 1200) return 9;
		else return 12;
	};

	useEffect(() => {
		// 페이지 로드 시와 화면 크기 변경 시 cardsPerPage 업데이트
		const updateCardsPerPage = () => setCardsPerPage(calculateCardsPerPage());
		updateCardsPerPage();

		window.addEventListener("resize", updateCardsPerPage);
		return () => window.removeEventListener("resize", updateCardsPerPage);
	}, []);

	// 카드 목록 생성
	const getHashTags = () => {
		const Hashtags = [];
		for (let i = 0; i < 34; i++) {
			// 예시 데이터로 30개의 카드 생성
			Hashtags.push(
				<div className="w-[25%] m-5">
					<FeedbackCardWithHashtag
						question="Hi"
						answer="Bye"
						hashtags={["hello", "baby"]}
						className="relative flex w-full m-5 flex-col rounded-xl bg-white bg-clip-border text-gray-700 shadow-md"
					/>
				</div>
			);
		}
		if (Hashtags.length % 3 != 0) {
			for (let i = 0; i < Hashtags.length % 3; i++) {
				Hashtags.push(
					<div className="w-[25%] m-5">
						<div className="relative flex w-full m-5 flex-col rounded-xl bg-white bg-clip-border text-gray-700 shadow-md"></div>
					</div>
				);
			}
		}
		return Hashtags;
	};

	// 현재 페이지에 맞는 카드들을 필터링
	const currentCards = getHashTags().slice(
		cardsPerPage * (curPage - 1),
		cardsPerPage * curPage
	);

	return (
		<div>
			<div className="flex justify-end">
				<Dropdown items={items} width="7rem" className={"right-[10%]"} />
			</div>
			<div className="flex flex-row flex-wrap justify-center">
				{currentCards}
			</div>
			<div className="flex justify-center">
				<div className="absolute bottom-5 mt-4 mb-[8%]">
					<Paging
						curPage={curPage}
						onPageChange={setCurPage}
						totalPage={Math.ceil(getHashTags().length / cardsPerPage)} // 전체 페이지 수 계산
					/>
				</div>
			</div>
		</div>
	);
};

export default FeedbackManagement;
