import React from 'react';
import Markdown from "react-markdown";
import rehypeHighlight from 'rehype-highlight';
import remarkGfm from 'remark-gfm';
import "highlight.js/styles/a11y-light.css";
import rehypeRaw from 'rehype-raw';

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
      <div className={`flex justify-${message.isUser() ? "end text-semesBlue" : "start text-gray-600"} items-start`}>
        {!message.isUser() && (
          <div className="mr-3 flex items-center justify-center w-[3rem]">
            <img src="src/assets/images/logo.png" alt="로고"/>
          </div>
        )}
        <div
          className={`max-w-2xl text-base ${
            message.isUser() ? 'bg-blue-100 text-blue-900 px-6 py-4 rounded-lg' : 'bg-gray-100 px-6 py-4 rounded-lg'
          }`}
        >
          <Markdown className="prose" remarkPlugins={[remarkGfm]} rehypePlugins={[rehypeHighlight, rehypeRaw]}>
            {message.content}
          </Markdown>
        </div>
        {/* {message.isUser() && (
          <div className="ml-3 flex items-center justify-center bg-blue-600 w-[3rem] h-[3rem] rounded-full">
            <img src="src/assets/icons/user_2.svg" alt="로고"/>
          </div>
        )} */}
      </div>
    </div>
  );
};

export default ChatMessage;