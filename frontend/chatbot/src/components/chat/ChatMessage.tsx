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
    <div className={`flex ${message.isUser() ? 'justify-end' : 'justify-start'}`}>
      {!message.isUser() && (
        <div className="w-8 h-8 bg-purple-100 rounded-full flex items-center justify-center mr-2 ">
          <span>👤</span>
        </div>
      )}
      <div
        className={`max-w-2xl p-4 rounded-lg ${
          message.isUser() ? 'bg-blue-100 text-blue-900' : 'bg-gray-100'
        }`}
      >
        {message.content}
      </div>
    </div>
  );
};

export default ChatMessage;