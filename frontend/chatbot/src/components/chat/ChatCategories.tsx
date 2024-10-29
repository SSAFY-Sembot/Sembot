import React, { useState } from 'react';

interface ChatCategoriesProps {
  categories: string[];
  onCategoryClick: (category : string)=>void
}

const ChatCategories: React.FC<ChatCategoriesProps> = ({ 
  categories,
  onCategoryClick
}) => {
  const [showAll, setShowAll] = useState(false); // 카테고리 더보기 상태
  const INIT_CATEGORY_SIZE = 5;

  const handleToggleShowAll = () => {
    setShowAll(prev => !prev);
  };

  // 카테고리 목록을 보여주는 로직
  const displayedCategories = showAll ? categories : categories.slice(0, 5);

  return (
    <div className='flex justify-center items-center'>
      <div className={`grid grid-cols-5 gap-2`}>
        {displayedCategories.map((category, index) => (
          <button
            key={index}
            className="h-full rounded-lg border border-semesBlue text-semesBlue bg-white focus:border-semesBlue text-xs"
            onClick={() => onCategoryClick(category)}
          >
            {category}
          </button>
        ))}
      </div>
      {/* 5개 이상의 카테고리가 있을 경우 더보기 버튼 표시 */}
      {(categories.length > INIT_CATEGORY_SIZE && !showAll) && (
        <img src="/src/assets/icons/dots-horizontal.svg" onClick={handleToggleShowAll} className='ml-4'/>
      )}
    </div>
  );
};

export default ChatCategories;