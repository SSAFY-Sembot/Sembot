import type { Meta } from '@storybook/react';
import ChatDocs from './ChatDocs';

const meta: Meta<typeof ChatDocs> = {
  title: 'COMPONENTS/CHAT/ChatDocs',
  component: ChatDocs,
  parameters: {
    layout: 'centered',
  },
  tags: ['autodocs'],
};
export default meta;

export const Default = {
  args: {
    docs: [
      {
        metadata: {
          source: "3_07_취업규칙(240214).pdf",
          page: 4
        },
        content: "입사다음연도1월1일에는다음각호의연차유급휴가를준다.<신설2021.12.28.>\n 1. 15일의연차유급휴가 휴가휴가휴가휴가휴가휴가휴가휴가휴가휴가휴가 휴가휴가휴가휴가휴가휴가휴가휴가휴가휴가휴가"
      },
      {
        metadata: {
          source: "3_04_감사규칙(230605).pdf",
          page: 20
        },
        content: "[별지제8호]<개정2013.5.8>\n질문서\n제목:\n질문사항 답변사항\n홍길동귀하 홍길동귀하 ..."
      }
    ]
  },
};