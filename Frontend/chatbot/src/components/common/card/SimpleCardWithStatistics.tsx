import React from "react";

interface SimpleCardWithStatisticsProps {
  svgIcon: string;
  title: string;
  count: string;
}

const SimpleCardWithStatistics: React.FC<SimpleCardWithStatisticsProps> = ({
  svgIcon,
  title,
  count,
}) => {
  return (
    <div>
      <div className="relative mt-6 flex w-72 flex-row items-center rounded-xl bg-white bg-clip-border text-gray-700 shadow-md p-6">
        <img src={svgIcon} alt="svgIcon" className="h-12 w-12 mr-4" />
        <div className="ml-4">
          <div className="font-sans text-base leading-snug tracking-normal text-gray-400 antialiased">
            {title}
          </div>
          <div className="font-sans text-xl font-bold leading-relaxed text-inherit antialiased">
            {count}
          </div>
        </div>
      </div>
    </div>
  );
};

export default SimpleCardWithStatistics;
