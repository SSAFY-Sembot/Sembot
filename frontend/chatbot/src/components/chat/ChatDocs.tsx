import React from 'react';
import CardWithLink from '@components/atoms/card/CardWithLink';
import { Doc } from './ChatView';

interface ChatDocsProps {
  docs: Doc[];
}

const ChatDocs: React.FC<ChatDocsProps> = ({ 
  docs,
}) => {
  return (
    <div className='container space-y-2'>
      <div className='text-lg font-bold'>
        출처
      </div>
      <div className='grid sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-3 gap-2'>
        {docs.map((doc, index)=>(
          <CardWithLink key={index} content={doc.content} resourceLink={doc.metadata.source} />
        ))}
      </div>
    </div>
  );
};

export default ChatDocs;