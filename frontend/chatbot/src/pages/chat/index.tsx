import React, { useEffect, useState } from "react";
import ChatView from "@components/chat/ChatView";
import Sidebar from "@components/atoms/sidebar/Sidebar";
import ButtonWithIcon from "@components/atoms/button/ButtonWithIcon";
import { BaseMessage } from "@components/chat/ChatMessage";

export type ButtonWithIconProps = React.ComponentProps<typeof ButtonWithIcon>;

const Chat: React.FC = () => {
  const [curChatroomId, setCurChatroomId] = useState<number>(-1);
  const [messages, setMessages] = useState<BaseMessage[]>([]);

  useEffect(()=>{
    // 채팅방 목록 조회
    // setChatroomComponents()
  },[curChatroomId])

  const initChatroom = () => {
    setCurChatroomId(-1);
    setMessages([]);
  }
  
  const newChatProp : ButtonWithIconProps = {
    btnName: "새채팅",
    styleName: "flex bg-transparent border border-white text-white py-2 px-4 rounded mx-1",
    icon: "/src/assets/icons/plus.svg",
    onClick: initChatroom
  }

  const [chatroomComponents, setChatroomComponents] = useState<ButtonWithIconProps[]>([newChatProp]);

  const footStyle = "flex bg-transparent text-white py-2 px-4 rounded mx-1";

  const footerComponents : ButtonWithIconProps[] = [
    {
      btnName: "규정 확인하기",
      styleName: footStyle,
      icon: "/src/assets/icons/book-open-text.svg",
    },
    {
      btnName: "로그아웃",
      styleName: footStyle,
      icon: "/src/assets/icons/logout.svg",
    }
    // 추가 컴포넌트 데이터들
  ];


  const createChatRoom = (message : string) => {
    // TODO : 채팅방 생성 요청하기
    const result = {
      data : {
        chatroomId : 1,
        title: "채팅방 제목"
      }
    }

    // 채팅방 id 등록
    setCurChatroomId(result.data.chatroomId);

    // 채팅방 목록에 추가
    const chatroomBtnProp = {
      btnName: result.data.title,
      styleName: "flex bg-blue-500 text-white py-2 px-4 rounded mx-1",
      icon: "/src/assets/icons/plus.svg",
    }

    setChatroomComponents([
      ... chatroomComponents,
      chatroomBtnProp
    ])
  }

  const sendMessage = (message : string) => {
    if(curChatroomId === -1){
      createChatRoom(message);
    }

    // TODO : fastapi에 채팅 요청
    const answer = "fastapi에 채팅 요청해서 받은 답변";

    setMessages((prevMessages) => [
      ...prevMessages,
      new BaseMessage("question", message),
      new BaseMessage("answer", answer)
    ]);
  }

  return (
    <div className="relative text-gray-600 w-screen flex">
      {/** 사이드바 */}
      <div className="w-[14%] h-full fixed left-0 top-0">
        <Sidebar components={chatroomComponents} footerComponents={footerComponents} isRule={false}/>
      </div>
      {/** 채팅 화면 */}
      <ChatView messages={messages} onSendMessage={sendMessage}/>
    </div>
  );
};

export default Chat;