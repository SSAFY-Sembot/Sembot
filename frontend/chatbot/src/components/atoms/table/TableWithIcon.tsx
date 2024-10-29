import React from 'react';
import TableHeader from './TableHeader';
import TableRowWithIcon from './TableRowWithIcon';

interface TableRowData {
  /** 테이블 data 배열 */
  columns: string[];
}

interface TableRowWithIconProps {
  /** 테이블 title row */
  columns: string[];
  /** 테이블 data row 배열 */
  rows: TableRowData[];
  /** 테이블 셀 width */
  width?: string;
  /** 테이블 row 아이콘 */
  iconPath? : string;
  /** 테이블 row 아이콘 click handler */
  onIconClick?: () => void;
}

const TableWithIconAndButton: React.FC<TableRowWithIconProps> = ({ 
  columns,
  rows,
  width = "auto",
  iconPath = "정보 변경",
  onIconClick,
}) => {
  return (
    <table className="min-w-full border-collapse">
        <TableHeader columns={columns} width={width} textColor='#818CF8'/>
        <tbody>
          {rows.map((row, index)=>(
            <TableRowWithIcon 
              key={index} 
              columns={row.columns}
              width={width}
              iconPath={iconPath}
              onIconClick={onIconClick}
            />
          ))}
        </tbody>
    </table>
  );
};

export default TableWithIconAndButton;
