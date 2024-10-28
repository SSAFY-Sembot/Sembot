import React, { useState } from "react";
import Paging, { PagingProps } from "./Paging";

export default {
	title: "Chatbot/Paging",
	component: Paging,
	// Storybook Controls를 통해서 수정 가능한 부분을 argTypes로 설정
	argTypes: {
		curPage: { control: "number", description: "현재 페이지 번호" },
		totalPage: { control: "number", description: "전체 페이지 수" },
		onPageChange: { description: "페이지 변경 시 호출되는 콜백 함수" },
	},
	tags: ["autodocs"],
};

// 기본 스토리
export const Default = (args: PagingProps) => {
	const [curPage, setCurPage] = useState(args.curPage || 1);
	const totalPage = 8;

	return (
		<Paging
			{...args}
			curPage={curPage}
			totalPage={totalPage}
			onPageChange={(page: number) => {
				setCurPage(page);
				console.log(`페이지 ${page}로 이동`);
			}}
		/>
	);
};

// 중간 페이지 스토리
export const MiddlePages = (args: PagingProps) => {
	const [curPage, setCurPage] = useState(args.curPage || 7);
	const totalPage = 14;

	return (
		<Paging
			{...args}
			curPage={curPage}
			totalPage={totalPage}
			onPageChange={(page: number) => {
				setCurPage(page);
				console.log(`페이지 ${page}로 이동`);
			}}
		/>
	);
};

// 페이지가 적은 경우 스토리
export const FewPages = (args: PagingProps) => {
	const [curPage, setCurPage] = useState(args.curPage || 37);
	const totalPage = 56;

	return (
		<Paging
			{...args}
			curPage={curPage}
			totalPage={totalPage}
			onPageChange={(page: number) => {
				setCurPage(page);
				console.log(`페이지 ${page}로 이동`);
			}}
		/>
	);
};

// 페이지가 많은 경우 스토리
export const ManyPages = (args: PagingProps) => {
	const [curPage, setCurPage] = useState(args.curPage || 50);

	return (
		<Paging
			{...args}
			curPage={curPage}
			onPageChange={(page: number) => {
				setCurPage(page);
				console.log(`페이지 ${page}로 이동`);
			}}
		/>
	);
};

// 마지막 페이지 그룹 스토리
export const LastPageGroup = (args: PagingProps) => {
	const [curPage, setCurPage] = useState(args.curPage || 98);

	return (
		<Paging
			{...args}
			curPage={curPage}
			onPageChange={(page: number) => {
				setCurPage(page);
				console.log(`페이지 ${page}로 이동`);
			}}
		/>
	);
};
