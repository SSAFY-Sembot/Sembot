from langchain_core.prompts import PromptTemplate

# Map prompt for summarizing individual chunks
MAP_PROMPT_TEXT = """
다음 텍스트는 규정의 일부이다.

{text}

각 규정의 주요 내용, 개정 이력을 다음과 같은 형식으로 정리해. 중요한 내용의 정확성을 위해 필요한 경우 원문에서 발췌해도 좋다.
개정 이력과 신규 개정은 하나도 빠뜨리지 말고 모두 포함하고, 신규 개정은 개정 이력 뒤에 '(신규)' 라고 표시해.

정리 형식:

##### 1. 주요 내용
- [주제 1]
- [주제 2]
...
- [주제 n]
"""

# Combine prompt for summarizing the overall document from individual summaries
COMBINE_PROMPT_TEXT = """
다음은 규정 각 부분의 정리본이다.

{text}

중복되는 내용을 하나로 통합하여 작성해. 개정 이력과 신규 개정은 하나도 빠뜨리지 말고 모두 포함해
규정명, 주요 내용, 개정 이력은 각각 내용을 통합해서 하나로 묶어. 날짜가 중복되면 하나로 통합하여 작성해.
개정 이력은 날짜로 정렬해, 신규 개정은 개정 이력 뒤에 '(신규)' 라고 표시해.

최종 요약 형식:

#### [통합 규정명]

##### 1. 주요 내용
- [주제 1]
- [주제 2]
...
- [주제 n]

"""