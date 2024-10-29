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
  /** 추가될 속성값 */
  className?: string;
}

/**
 * 검색 기능이 있는 드롭다운 컴포넌트
 * 특징 :
 * - 검색 필터링 기능
 * - 외부 클릭 시 자동 닫힘
 * - 선택된 항목이 버튼에 표시됨
 */
const Dropdown: React.FC<DropdownProps> = ({
  /** 기본 값 할당 */
  items = [],
  buttonLabel = "전체",
  width = "10rem",
  searchPlaceholder = "검색",
  onSelect,
  className = "",
}) => {
  const [isOpen, setIsOpen] = useState<boolean>(false);
  const [searchTerm, setSearchTerm] = useState<string>("");
  const [selectedItem, setSelectedItem] = useState<string>(buttonLabel);

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
      className={`relative group items-center inline-block dropdown-container border border-gray-300 rounded-md ${className}`}
      style={{ width }}
    >
      <button
        onClick={() => setIsOpen(!isOpen)}
        className="inline-flex justify-center w-full px-5 py-4 text-sm font-medium text-gray-700 bg-white focus:outline-none focus:ring-0 "
      >
        <span className="mr-2 truncate">{selectedItem}</span>
        <svg
          xmlns="http://www.w3.org/2000/svg"
          className={`w-5 h-5 ml-2 mr-1 transition-transform duration-200 ${
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

      {isOpen && (
        <div className="absolute right-0 w-full mt-2 rounded-md shadow-lg bg-white ring-0 ring-black ring-opacity-5 p-1 space-y-1 z-50">
          <input
            className="block w-full px-4 py-2 text-gray-800 border rounded-md border-gray-300 focus:outline-none focus:ring-0 hover:bg-transparent"
            type="text"
            placeholder={searchPlaceholder}
            value={searchTerm}
            onChange={(e) => setSearchTerm(e.target.value)}
            onClick={(e) => e.stopPropagation()}
          />

          <div className="max-h-60 overflow-auto">
            {filteredItems.length > 0 ? (
              filteredItems.map((item, index) => (
                <div
                  key={index}
                  className={`block px-4 py-2 text-gray-700 cursor-pointer rounded-md ${
                    selectedItem === item ? "bg-gray-100" : ""
                  }`}
                  onClick={() => handleSelect(item)}
                >
                  {item}
                </div>
              ))
            ) : (
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
