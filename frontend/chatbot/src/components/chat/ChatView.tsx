import React from "react";
import InputWithIcon from "@components/atoms/input/InputWithIcon";
import { Message } from "@components/chat/ChatMessage";
import ChatMessage from "@components/chat/ChatMessage";
import ChatCategories from "./ChatCategories";
import ChatDocs from "./ChatDocs";
import ButtonOnlyIcon from "@components/atoms/button/ButtonOnlyIcon";

export interface DocMetadata {
  source : string;
  page : number;
}

export interface Doc {
  metadata : DocMetadata;
  content : string;
}

export interface QnA {
  /** 채팅 id */
  chatId : number
  /** 질문 */
  question : Message
  /** 답변 */
  answer : Message
  /** 출처 자료 목록 */
  docs : Doc[]
  /** 긍적적 답변인지 */
  isPositive? : boolean
  /** 답변 다 받았는지 */
  isAnswered? : boolean
}

export interface ChatViewProps {
  /** QnA 쌍 배열 */
  qnas: QnA[];
  /** 메시지 보냈을 때 실행되는 함수 */
  onSendMessage: (message: string) => void;
  /** 피드백 했을 때 실행되는 함수 */
  onFeedback: (qna : QnA, isPositive : boolean) => void;
  /** 로딩 상태 */
  isLoading: boolean;
}

const ChatView: React.FC<ChatViewProps> = ({ qnas, onSendMessage, onFeedback, isLoading }) => {
  const categories = [
    "포탈 시스템 문의", "경비 처리", "보안 관련 프로세스",
    "국내외 출장 관련", "인사 규정", "회사 복지 규정",
  ];

  const onClickCategory = (category: string) => {
    console.log(category);
  };

  const renderFeedbackButton = (qna : QnA) => {
    if(qna.isPositive === true){
      return <ButtonOnlyIcon icon="src/assets/icons/like-fill.svg" styleName="hover:scale-110 transition-transform duration-200 ease-in-out" width="18"/>
    }else if(qna.isPositive === false){
      return <ButtonOnlyIcon icon="src/assets/icons/dislike-fill.svg" styleName="hover:scale-110 transition-transform duration-200 ease-in-out" width="18"/>
    }else{
      return <>
        <ButtonOnlyIcon icon="src/assets/icons/like.svg" styleName="hover:scale-110 transition-transform duration-200 ease-in-out" width="18" onClick={()=>onFeedback(qna,true)}/>
        <ButtonOnlyIcon icon="src/assets/icons/dislike.svg" styleName="hover:scale-110 transition-transform duration-200 ease-in-out" width="18" onClick={()=>onFeedback(qna,false)}/>
      </>
    }
  }

  return (
    <div className="mb-4 w-full h-full flex justify-center items-center text-gray-600">
      {qnas.length === 0 ? (
        <div className="w-full max-w-3xl h-full flex flex-col justify-center items-center">
          <div className="flex justify-center items-center">
            <img src="/src/assets/icons/logo.svg" alt="SEMES" width="300rem" />
          </div>
          <InputWithIcon
            isLoading={isLoading}
            iconPath={"/src/assets/icons/send.svg"}
            onIconClick={onSendMessage}
          />
          <div className="mt-6">
            <ChatCategories categories={categories} onCategoryClick={onClickCategory} />
          </div>
        </div>
      ) : (
        <div className="relative w-full h-full flex flex-col justify-center items-center">
          <div className="w-full h-[90svh] overflow-auto flex justify-center">
            <div className="w-full max-w-3xl h-full space-y-4">
              {qnas.map((qna: QnA, index) => (
                <div key={index}>
                  <ChatMessage message={qna.question} />
                  <div className="ml-16 my-6">
                    <ChatDocs docs={qna.docs} />
                  </div>
                  <ChatMessage message={qna.answer} />
                  {qna.isAnswered &&
                    <>
                      <div className="ml-16 flex justify-start items-center my-4 space-x-2">
                        {renderFeedbackButton(qna)}
                      </div>
                      <hr className="my-6"/>
                    </>
                  }
                </div>
              ))}
            </div>
          </div>
          <div className="w-full max-w-3xl">
            <InputWithIcon
              isLoading={isLoading}
              iconPath={"/src/assets/icons/send.svg"}
              onIconClick={onSendMessage}
            />
          </div>
        </div>
      )}
    </div>
  );
};

export default ChatView;
