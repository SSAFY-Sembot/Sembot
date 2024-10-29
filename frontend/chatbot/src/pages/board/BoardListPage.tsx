import React from "react";
import SembotLayout from "../SembotLayout";
import BoardListContent from "./BoardListContent";

const BoardListPage: React.FC = () => {
  return (
    <>
      <SembotLayout title={"규정목록"}>
        <BoardListContent />
      </SembotLayout>
    </>
  );
};

export default BoardListPage;
