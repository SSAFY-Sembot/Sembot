## Example code

### set up file

- chatGPT API를 사용하거나 langsmith에 프로젝트 로그를 남기기 위해서 아래와 같이 .env file을 구성해야 합니다.

- .env 파일을 chain 폴더 안에 위치합니다.

- .env 파일은 아래와 같이 구성합니다.
```
OPENAI_API_KEY=YOUR_OPENAI_API_KEY
LANGCHAIN_TRACING_V2=true
LANGCHAIN_ENDPOINT=https://api.smith.langchain.com
LANGCHAIN_API_KEY=YOUR_LANGCHAIN_API_KEY
LANGCHAIN_PROJECT=YOUR_PROJECT_NAME
```