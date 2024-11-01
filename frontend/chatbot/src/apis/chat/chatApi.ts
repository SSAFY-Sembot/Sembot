import { defaultAIAxios } from "@apis/common";
import { Doc, DocMetadata, QnA } from "@components/chat/ChatView";
import { AI_URL } from "@configs/config";

//===== AI API =====//
type SearchDocResponse = {
  docs : DocResponse[]
}

type DocResponse = {
  metadata : DocMetadata;
  page_content : string;
}

const convertToDoc = (res : DocResponse) : Doc => {
  return {
    metadata : res.metadata,
    content : res.page_content
  }
}

const convertToDocArray = (responses: DocResponse[]): Doc[] => {
  return responses.map(convertToDoc);
};

// 문서 검색
export const searchDocsAPI = async (question : string): Promise<Doc[]> => {
  return defaultAIAxios
    .post<SearchDocResponse>('search', { question })
    .then((res) => {
      return convertToDocArray(res.data.docs);
    })
    .catch((error) => {
      console.error("Error in searchDocsAPI:", error);
      return [];
    });
};

type Memory = {
  question : string;
  doc : Doc | null;
  answer : string | null;
}

// type GenerateResponse = {
//   answer : string;
// }

const convertToMemory = (qna : QnA) : Memory => {
  return {
    question: qna.question.content,
    doc: qna.docs && qna.docs.length > 0 ? qna.docs[0] : null,
    answer: qna.answer.content || null
  }
}

const convertToMemoryArray = (qnas : QnA[]) : Memory[] => {
  return qnas.map(convertToMemory);
}

export const generateAPI = async (qnas: QnA[], question: string): Promise<Response> => {
  return await fetch(`${AI_URL}/generate`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify({ memory: convertToMemoryArray(qnas), question })
  });
};

//===== Backend API =====//