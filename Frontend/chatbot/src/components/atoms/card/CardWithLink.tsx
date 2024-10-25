import linkIcon from '@/assets/icons/link.svg';
import React from 'react';

export interface CardWithLinkProps {
    content: string;
    resourceLink: string;
}

const CardWithLink: React.FC<CardWithLinkProps> = ({ content, resourceLink }) => {
    return (
        <div className="p-4 border border-gray-300 rounded-lg shadow-md">
            <p className="text-lg mb-2">{content}</p>
            <a 
                href={resourceLink} 
                target="_blank" 
                rel="noopener noreferrer" 
                className="flex items-center text-blue-500 hover:underline"
            >
                <img src={linkIcon} alt="Link icon" className="w-5 h-5 mr-2" />
                <span>자세히 보기</span>
            </a>
        </div>
    );
}

export default CardWithLink;
