import React from "react";
import InputWithIcon from "@components/atoms/input/InputWithIcon";
import { BaseMessage, Message } from "@components/chat/ChatMessage";
// import { useParams } from 'react-router-dom';
import ChatMessage from "@components/chat/ChatMessage";
import ChatCategories from "./ChatCategories";

export interface ChatViewProps {
  messages: BaseMessage[];
  onSendMessage : (message : string)=>void
}

const ChatView: React.FC<ChatViewProps> = ({
  messages,
  onSendMessage
}) => {
  const categories = [
    "포탈 시스템 문의", "경비 처리", "보안 관련 프로세스",
    "국내외 출장 관련", "인사 규정", "회사 복지 규정"
  ];

  const onClickCategory = (category : string) => {
    console.log(category);
  }

  return (
    <div className="w-screen h-screen flex justify-center items-center text-gray-600">
      {/** 채팅 화면 */}
      <div className="mb-4 w-full max-w-4xl h-full p-6">
        {messages.length === 0 ? (
          // 채팅 없는 경우
          <div className="w-full h-full flex flex-col justify-center items-center">
            {/** 로고 */}
            <div className="flex justify-center items-center">
              <img src="/src/assets/icons/logo.svg" alt="SEMES"/>
            </div>
            {/** 채팅 입력 컴포넌트 */}
            <InputWithIcon iconPath="/src/assets/icons/send.svg" onIconClick={onSendMessage}/>
            {/** 채팅 입력 카테고리 */}
            <div className="mt-6">
              <ChatCategories categories={categories} onCategoryClick={onClickCategory}/>
            </div>
          </div>
        ) : (
          // 채팅 있는 경우
          <div className="relative w-full h-full flex flex-col items-center">
            <div className="w-full h-[80svh] space-y-4 overflow-auto">
              {messages.map((msg : Message) => (
                <ChatMessage message={msg} />
              ))}
            </div>
            {/** 채팅 입력 컴포넌트 */}
            <div className="absolute bottom-10 w-full">
              <InputWithIcon iconPath="/src/assets/icons/send.svg" onIconClick={onSendMessage}/>
            </div>
          </div>
        )}
      </div>
      
    </div>
  );
};

export default ChatView;