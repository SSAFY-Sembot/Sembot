import linkIcon from '@/assets/icons/link.svg';
import React from 'react' ;

interface CardWithLinkProps{
    content: string;
    resourceLink: string;
}

const CardWithLink: React.FC<CardWithLinkProps> = ({content, resourceLink}) =>{
    return(
        <div className="card">
            <p>{content}</p>
            <a href={resourceLink} target="_blank" rel="noopen">
                <img src={linkIcon} alt="Link icon" style={{ width: '20px', height: '20px'}} />
                <span>자세히 보기</span>
            </a>
        </div>
    )
}