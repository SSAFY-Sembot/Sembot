import React from 'react';

export type MessageType = "question" | "answer";

export interface Message {
  type: MessageType;
  content: string;
  isUser() : boolean;
}

export class BaseMessage implements Message {
  constructor(public type: MessageType, public content: string) {}

  isUser(): boolean {
    return this.type === "question"; // 기본 구현
  }
}

interface ChatMessageProps {
  message: Message;
}

const ChatMessage: React.FC<ChatMessageProps> = ({ message }) => {
  return (
    <div>
      <div className={`flex justify-start items-center text-semesBlue`}>
        {message.isUser() ? (
          <div className="mr-3 flex items-center justify-center bg-blue-600 w-[3rem] h-[3rem] rounded-xl">
            <img src="src/assets/icons/user_2.svg" alt="로고"/>
          </div>) : (
          <div className="mr-3 flex items-center justify-center w-[3rem]">
            <img src="src/assets/images/logo.png" alt="로고"/>
          </div>
        )}
        <div
          className={`max-w-2xl p-4 rounded-lg text-sm ${
            message.isUser() ? 'bg-blue-100 text-blue-900' : 'bg-gray-100'
          }`}
        >
          {message.content}
        </div>
      </div>
    </div>
  );
};

export default ChatMessage;