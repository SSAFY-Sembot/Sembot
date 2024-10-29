import InputSearch from "@components/atoms/input/InputSearch";
import Paging from "@components/atoms/paging/Paging";
import TableWithIconAndButton from "@components/atoms/table/TableWithIcon";
import React, { useState } from "react";

const tableHeader = ["", "작성자", "제목", "등록일"];
const tableRows = [
  {
    id: 1,
    columns: [
      "작성자1",
      "정말 긴 제목 입니다 제목제목제목제목제목제목제목제목제목제목제목제목제목제목",
      "등록일1",
    ],
  },
  {
    id: 2,
    columns: ["작성자2", "제목2", "등록일2"],
  },
  {
    id: 3,
    columns: ["작성자3", "제목3", "등록일3"],
  },
];

const totalPage = 100;
const favoritePath = "/src/assets/icons/favorite.svg";
const favoritedPath = "/src/assets/icons/Favorited.svg";

const BoardListContent: React.FC = () => {
  const [curPage, setCurPage] = useState(1);
  // 각 행의 아이콘 경로를 저장하는 상태
  const [iconPaths, setIconPaths] = useState<{ [key: number]: string }>(
    tableRows.reduce((acc, row) => ({ ...acc, [row.id]: favoritePath }), {})
  );

  // 아이콘 클릭 시 해당 행의 아이콘 경로만 토글하는 함수
  const clickEvent = (rowId: number) => {
    setIconPaths((prevIconPaths) => ({
      ...prevIconPaths,
      [rowId]:
        prevIconPaths[rowId] === favoritePath ? favoritedPath : favoritePath,
    }));
  };

  return (
    <>
      {/* 검색 입력란 */}
      <div className="mb-4 flex justify-center mx-5">
        <InputSearch />
      </div>

      {/* 게시글 영역 */}
      <div className="mb-4">
        <TableWithIconAndButton
          columns={tableHeader}
          rows={tableRows}
          iconPaths={iconPaths}
          onIconClick={clickEvent}
        />
        {/* 게시글 내용이 여기에 표시될 수 있습니다 */}
      </div>

      {/* 페이지 번호 영역 */}
      <div className="flex justify-center">
        <div className="absolute bottom-5 mt-4">
          <Paging
            curPage={curPage}
            totalPage={totalPage}
            onPageChange={(page: number) => {
              setCurPage(page);
            }}
          />
        </div>
      </div>
    </>
  );
};

export default BoardListContent;
