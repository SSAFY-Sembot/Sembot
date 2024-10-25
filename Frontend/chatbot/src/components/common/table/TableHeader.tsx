import React from 'react';

interface TableHeaderProps {
  /** 컬럼에 입력되는 정보 */
	columns: string[];
  /** 넓이(ex - 16px , 5rem) */
	width?: string;
}

const TableHeader: React.FC<TableHeaderProps> = ({ 
  columns,
  width = "6rem"
}) => {
  return (
    <thead>
      <tr>
        {columns.map((column, index) => (
          <th key={index} className={`w-[${width}]`}>
            {column}
          </th>
        ))}
      </tr>
    </thead>
  );
};

export default TableHeader;
