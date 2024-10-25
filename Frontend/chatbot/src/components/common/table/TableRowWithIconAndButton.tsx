import React from 'react';

interface TableRowWithIconAndButtonProps {
  /** 컬럼에 입력되는 정보 */
	columns: string[];
  /** 넓이(ex - 16px , 5rem) */
	width?: string;
  /** 텍스트 색상 */
  textColor?: string;
  /** 아이콘 경로 */
  iconPath? : string;
  /** 버튼 라벨 */
  buttonLabel : string;
  /** 버튼 click handler */
  buttonOnClick?: () => void;
}

const TableRowWithIconAndButton: React.FC<TableRowWithIconAndButtonProps> = ({ 
  columns,
  width = "auto",
  textColor = "#718EBF",
  iconPath,
  buttonLabel,
  buttonOnClick
}) => {
  return (
    <tr className='text-left bg-white'>
      <td className='rounded-l-3xl pl-2 max-w-[6rem]'>
        <img src={iconPath} alt="Sample Icon"/>
      </td>
      {columns.map((column, index) => (
        <td key={index} style={{width, color: textColor}} className='px-4 py-2 max-w-[15rem]'>
          {column}
        </td>
      ))}
      <td style={{width}} className='px-2 py-2 rounded-r-3xl max-w-[10rem]'>
        <button className='border-indigo-300' onClick={buttonOnClick}>{buttonLabel}</button>
      </td>
    </tr>
  );
};

export default TableRowWithIconAndButton;
