import React from "react";

interface FeedbackCardProps {
  question: string;
  answer: string;
  hashtags: string[];
}

const FeedbackCardWithHashtag: React.FC<FeedbackCardProps> = ({
  question,
  answer,
  hashtags,
}) => {
  return (
    <div>
      <div className="relative flex w-96 flex-col rounded-xl bg-white bg-clip-border text-gray-700 shadow-md">
        <div className="p-6">
          <h5 className="mb-2 block font-sans text-l font-semibold leading-snug tracking-normal text-blue-gray-900 antialiased">
            Q: {question}
          </h5>
          <h5 className="mb-2 block font-sans text-l font-semibold leading-snug tracking-normal text-blue-gray-900 antialiased">
            A: {answer}
          </h5>
          <div className="mt-4 flex flex-wrap gap-2">
            {hashtags.map((tag, index) => (
              <span key={index} className="text-sm font-medium text-semesBlue">
                #{tag}
              </span>
            ))}
          </div>
        </div>
      </div>
    </div>
  );
};

export default FeedbackCardWithHashtag;
