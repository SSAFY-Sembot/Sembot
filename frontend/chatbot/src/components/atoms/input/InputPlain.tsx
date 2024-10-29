import React, { useState } from "react";

export interface InputProps {
  /** Input란에 띄워질 메세지 */
  placeholder?: string;
  /** Input란의 너비 */
  width?: string;
  /** Input란 글자 색 */
  textColor?: string;
  /** Input란 배경 색 */
  backgroundColor?: string;
  /** Input란 border 색 */
  borderColor?: string;
  /** 추가될 속성값 */
  className?: string;
}

const Input: React.FC<InputProps> = ({
  /** 기본 값 할당 */
  placeholder = "",
  width = "auto",
  textColor = "#000000",
  backgroundColor = "#FFFFFF",
  borderColor = "",
  className,
}) => {
  const [inputValue, setInputValue] = useState<string>("");

  const handleInputChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    setInputValue(event.target.value);
  };

  return (
    <div className="relative text-gray-600 w-full max-w-lg" style={{ width }}>
      <input
        type="text"
        value={inputValue}
        onChange={handleInputChange}
        placeholder={placeholder}
        className={`rounded-md h-12 w-full px-5 pr-10 text-sm border border-gray-300 focus:outline-none focus:ring-0 ${className}`}
        style={{ color: textColor, backgroundColor, borderColor }}
      />
    </div>
  );
};

export default Input;
