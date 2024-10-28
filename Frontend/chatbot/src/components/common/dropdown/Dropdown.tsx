import React, { useState } from "react";

interface DropdownProps {
  /** 드롭다운에 표시될 아이템 리스트 */
  items?: string[];
  /** 드롭다운 버튼에 표시될 텍스트 */
  buttonLabel?: string;
  /** 드롭다운의 너비 ex) 16rem, 200px */
  width?: string;
  /** 검색 입력창의 플레이스 홀더 텍스트 */
  searchPlaceholder?: string;
  /** 아이템 선택 시 실행될 콜백 함수 */
  onSelect?: (item: string) => void;
}

/**
 * 검색 기능이 있는 드롭다운 컴포넌트
 * 특징 :
 * - 검색 필터링 기능
 * - 외부 클릭 시 자동 닫힘
 * - 선택된 항목이 버튼에 표시됨
 */
const Dropdown: React.FC<DropdownProps> = ({
  // 아이템이 제공되지 않았을 때의 기본값
  items = [],
  buttonLabel = "전체",
  width = "10rem",
  searchPlaceholder = "검색",
  onSelect,
}) => {
  // 드롭다운의 열림 / 닫힘 상태를 관리
  const [isOpen, setIsOpen] = useState(false);
  // 검색어 관리
  const [searchTerm, setSearchTerm] = useState("");
  // 현재 선택된 항목 관리
  const [selectedItem, setSelectedItem] = useState(buttonLabel);

  // 검색어에 따라 아이템 필터링 로직
  // 대소문자 구분 없이 검색어를 포함하는 아이템만 필터링
  const filteredItems = items.filter((item) =>
    item.toLowerCase().includes(searchTerm.toLowerCase())
  );

  // 아이템 선택 시 처리하는 함수
  const handleSelect = (item: string) => {
    setSelectedItem(item);
    if (onSelect) {
      onSelect(item);
    }
    setIsOpen(false);
    // 검색어 초기화
    setSearchTerm("");
  };

  // 드롭다운 외부 클릭을 감지하는 함수
  const handleClickOutside = (e: MouseEvent) => {
    if (isOpen && !(e.target as Element).closest(".dropdown-container")) {
      setIsOpen(false);
      // 드롭다운이 닫힐 때 검색어 초기화
      setSearchTerm("");
    }
  };

  React.useEffect(() => {
    // 드롭다운이 열려있을 때만 이벤트 리스너 동작
    document.addEventListener("click", handleClickOutside);
    return () => {
      document.removeEventListener("click", handleClickOutside);
    };
  }, [isOpen]); // isOpen 상태가 변경될 때만 실행

  return (
    <div
      className="relative group inline-block dropdown-container"
      style={{ width }}
    >
      {/** 드롭다운 열고 닫는 버튼 */}
      <button
        onClick={() => setIsOpen(!isOpen)}
        className="inline-flex justify-center w-full px-4 py-2 text-sm font-medium text-gray-700 bg-white border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-offset-gray-100 focus:ring-blue-500"
      >
        <span className="mr-2 truncate">{selectedItem}</span>

        {/** 드롭다운 화살표 아이콘 (열림 / 닫힘 상태에 따라 180도 회전) */}
        <svg
          xmlns="http://www.w3.org/2000/svg"
          className={`w-5 h-5 ml-2 -mr-1 transition-transform duration-200 ${
            isOpen ? "transform rotate-180" : ""
          }`}
          viewBox="0 0 20 20"
          fill="currentColor"
          aria-hidden="true"
        >
          <path
            fillRule="evenodd"
            d="M6.293 9.293a1 1 0 011.414 0L10 11.586l2.293-2.293a1 1 0 111.414 1.414l-3 3a1 1 0 01-1.414 0l-3-3a1 1 0 010-1.414z"
            clipRule="evenodd"
          />
        </svg>
      </button>

      {/** 드롭다운 메뉴 (열렸을 때만 표시) */}
      {isOpen && (
        <div className="absolute right-0 w-full mt-2 rounded-md shadow-lg bg-white ring-1 ring-black ring-opacity-5 p-1 space-y-1 z-50">
          {/** 검색 입력창 */}
          <input
            className="block w-full px-4 py-2 text-gray-800 border rounded-md border-gray-300 focus:outline-none"
            type="text"
            placeholder={searchPlaceholder}
            value={searchTerm}
            onChange={(e) => setSearchTerm(e.target.value)}
            onClick={(e) => e.stopPropagation()} // 입력창 클릭 시 드롭다운이 닫히지 않도록 함
          />

          {/** 필터링된 아이템 목록을 표시하는 영역 */}
          <div className="max-h-60 overflow-auto">
            {filteredItems.length > 0 ? (
              // 필터링된 아이템이 있는 경우
              filteredItems.map((item, index) => (
                <div
                  key={index}
                  className={`block px-4 py-2 text-gray-700 hover:bg-gray-100 active:bg-blue-100 cursor-pointer rounded-md ${
                    selectedItem === item ? "bg-gray-100" : ""
                  }`}
                  onClick={() => handleSelect(item)}
                >
                  {item}
                </div>
              ))
            ) : (
              // 필터링된 아이템이 없는 경우
              <div className="px-4 py-2 text-gray-500 text-center">
                검색 결과가 없습니다
              </div>
            )}
          </div>
        </div>
      )}
    </div>
  );
};

export default Dropdown;