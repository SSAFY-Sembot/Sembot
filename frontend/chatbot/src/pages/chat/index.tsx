import React, { useEffect, useState } from "react";
import ChatView, { QnA } from "@components/chat/ChatView";
import ButtonWithIcon from "@components/atoms/button/ButtonWithIcon";
import { BaseMessage } from "@components/chat/ChatMessage";
import SembotLayout from "@pages/SembotLayout";

export type ButtonWithIconProps = React.ComponentProps<typeof ButtonWithIcon>;

const sampleDocs = [
  {
    metadata: {
      source: "3_07_취업규칙(240214).pdf",
      page: 4
    },
    content: "입사다음연도1월1일에는"
  },
  {
    metadata: {
      source: "3_04_감사규칙(230605).pdf",
      page: 20
    },  
    content: "[별지제8호]<개정2013.5.8>\n질문서\n제목:\n질문사항 답변사항\n홍길동귀하 홍길동귀하 홍길동귀하 홍길동귀하 홍길동귀하 홍길동귀하 홍길동귀하 홍길동귀하 "
  },
  {
    metadata: {
      source: "3_04_감사규칙(230605).pdf",
      page: 20
    },
    content: "[별지제8호]<개정2013.5.8>\n질문서\n제목:\n질문사항 답변사항\n홍길동귀하 홍길동귀하 홍길동귀하 홍길동귀하 홍길동귀하 홍길동귀하 홍길동귀하 홍길동귀하 홍길동귀하 "
  }
]

const Chat: React.FC = () => {
  const [curChatroomId, setCurChatroomId] = useState<number>(-1);
  const [qnas, setQnAs] = useState<QnA[]>([]);
  const [isLoading, setIsLoading] = useState<boolean>(false); // 로딩 상태 추가

  const initChatroom = () => {
    setCurChatroomId(-1);
    setQnAs([]);
  };

  const newChatProp: ButtonWithIconProps = {
    btnName: "새채팅",
    styleName: "flex bg-transparent border border-white text-white py-2 px-4 rounded mx-1 hover:bg-blue-900 transition-colors duration-200 ease-in-out",
    icon: "/src/assets/icons/plus.svg",
    handleClick: initChatroom,
  };

  const [chatroomComponents, setChatroomComponents] = useState<ButtonWithIconProps[]>([newChatProp]);

  useEffect(() => {
    // 채팅방 목록 조회
    // setChatroomComponents()
  }, [curChatroomId]);

  const footStyle = "flex bg-transparent text-white py-2 px-4 rounded mx-1";

  const footerComponents: ButtonWithIconProps[] = [
    {
      btnName: "규정 확인하기",
      styleName: footStyle,
      icon: "/src/assets/icons/book-open-text.svg",
    },
    {
      btnName: "로그아웃",
      styleName: footStyle,
      icon: "/src/assets/icons/logout.svg",
    },
    // 추가 컴포넌트 데이터들
  ];

  const createChatRoom = (message: string) => {
    const result = {
      data: {
        chatroomId: 1,
        title: "채팅방 제목",
      },
    };

    setCurChatroomId(result.data.chatroomId);

    const chatroomBtnProp = {
      btnName: result.data.title,
      styleName: "flex bg-white text-semesBlue py-2 px-4 rounded mx-1",
      icon: "src/assets/icons/delete.svg",
    };

    setChatroomComponents([...chatroomComponents, chatroomBtnProp]);
  };

  const sendMessage = (message: string) => {
    if (isLoading) return; // 로딩 중이면 메시지 전송 차단

    if (curChatroomId === -1) {
      createChatRoom(message);
    }

    setIsLoading(true); // 로딩 시작

    // 초기 메시지 저장
    setQnAs((qnas)=>[
      ...qnas, 
      {
        chatId : -1,
        question : new BaseMessage("question",message), 
        answer : new BaseMessage("answer",""),
        docs : []
      }
    ]);

    // TODO : 출처 검색
    const docs = sampleDocs;

    setQnAs((qnas)=>{
      const updatedQnAs = [...qnas];
      updatedQnAs[qnas.length-1].docs = docs;
      return updatedQnAs;
    });

    // TODO : 답변 생성하기
    const answer = ["답변", " ", "입", "니", "다", ".", " ", "더", " ", "자", "세", "한", " ", "정", "보", "를", " ", "원", "하", "시", "나", "요", "?"];

    answer.forEach((chunk, index) => {
      setTimeout(() => {
        setQnAs((qnas) => {
          const updatedQnAs = [...qnas];
          const lastQnA = updatedQnAs[qnas.length-1];
          lastQnA.answer.content += chunk;

          if (index === answer.length - 1) {
            setIsLoading(false); // 로딩 종료
            lastQnA.isAnswered = true;
          }
          return updatedQnAs;
        });
      }, index * 100); // Delay each chunk by 100 ms
    });

    // 채팅 저장하기
    const chatId = 1;

    // 채팅 id 등록
    setQnAs((qnas)=>{
      const updatedQnAs = [...qnas];
      updatedQnAs[qnas.length-1].chatId = chatId;
      return updatedQnAs;
    });
  };

  const handleFeedback = (qna : QnA, isPositive: boolean) => {
    setQnAs(()=>{
      const updatedQnAs = [...qnas];
      const updatedQnA = updatedQnAs.find(
        curQnA => curQnA.chatId === qna.chatId
      );
      if(updatedQnA !== undefined){
        updatedQnA.isPositive = isPositive;
      }
      return updatedQnAs;
    })
  };

  return (
    <SembotLayout
      hideHeader={true}
      isRule={false}
      sidebarComponents={chatroomComponents}
      footerComponents={footerComponents}
    >
      <div className="p-4 w-full h-full">
        <ChatView qnas={qnas} onSendMessage={sendMessage} isLoading={isLoading} onFeedback={handleFeedback} />
      </div>
    </SembotLayout>
  );
};

export default Chat;
