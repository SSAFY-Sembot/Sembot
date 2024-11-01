import linkIcon from "@/assets/icons/link.svg";
import React from "react";

export interface CardWithLinkProps {
  content: string;
  resourceLink: string;
}

const CardWithLink: React.FC<CardWithLinkProps> = ({
  content,
  resourceLink,
}) => {
  return (
    <div className="relative p-4 border border-gray-200 bg-gray-50 h-28 rounded-3xl shadow-sm">
      <p className="text-sm mb-2 line-clamp-2">{content}</p>
      <a
        href={resourceLink}
        target="_blank"
        rel="noopener noreferrer"
        className="flex items-center text-blue-500 hover:underline absolute bottom-3"
      >
        <img src={linkIcon} alt="Link icon" className="w-4 h-4 mr-2" />
        <span className="text-sm">자세히 보기</span>
      </a>
    </div>
  );
};

export default CardWithLink;
