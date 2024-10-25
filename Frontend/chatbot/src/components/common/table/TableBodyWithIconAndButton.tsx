import React from 'react';

interface TableBodyWithIconAndButtonProps {
  /** 컬럼에 입력되는 정보 */
	columns: string[];
  /** 넓이(ex - 16px , 5rem) */
	width?: string;
  /** 아이콘 */
  icon? : string;
  /** 버튼 라벨 */
  label : string;
  /** 버튼 click handler */
  onClick?: () => void;
}

const TableBodyWithIconAndButton: React.FC<TableBodyWithIconAndButtonProps> = ({ 
  columns,
  width = "5rem",
}) => {
  return (
    <tbody>
      <tr>
        {columns.map((column, index) => (
          <td key={index} className={`w-[${width}] text-[#718EBF]`}>
            {column}
          </td>
        ))}
        <td>
          <button>정보 변경</button>
        </td>
      </tr>
    </tbody>
  );
};

export default TableBodyWithIconAndButton;
