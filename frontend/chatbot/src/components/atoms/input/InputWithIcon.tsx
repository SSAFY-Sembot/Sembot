import React, { useState } from "react";
import ButtonWithIcon from "../button/ButtonOnlyIcon";

interface InputWithIconProps {
  /** Input란에 띄워질 메세지 */
  placeholder?: string;
  bgColor?: string;
  borderColor?: string;
  textColor?: string;
  /** icon 경로 */
  iconPath: string;
  /** icon click event 함수 */
  onIconClick: (message:string)=>void;
  className?: string;
}

const InputWithIcon: React.FC<InputWithIconProps> = ({ 
  placeholder = "",
  bgColor = "#EAF1FB",
  borderColor = "#004F9F",
  textColor = "#737373",
  iconPath,
  onIconClick,
  className
}) => {
  const [inputValue, setInputValue] = useState("");

  const handleInputChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    setInputValue(event.target.value);
  };

  const onClick = () => {
    onIconClick(inputValue);
    setInputValue("");
  }

  const handleKeyDown = (event: React.KeyboardEvent<HTMLInputElement>) => {
    if (event.key === "Enter") {
      onClick();
    }
  };

  return (
    <div className="relative text-gray-600 w-full max-w-3xl">
      <input
        type="text"
        value={inputValue}
        onChange={handleInputChange}
        onKeyDown={handleKeyDown}
        placeholder={placeholder}
        style={{backgroundColor:bgColor,borderColor,color:textColor}}
        className={`rounded-md h-12 w-full max-w-3xl px-5 pr-10 text-sm border border-gray-300 focus:outline-none focus:ring-2 focus:ring-blue-500 ${className}`}
      />
      <div className="absolute right-0 top-1/2 transform -translate-y-1/2 pr-3">
        <ButtonWithIcon icon={iconPath} onClick={onClick}/>
      </div>
    </div>
  );
};

export default InputWithIcon;
