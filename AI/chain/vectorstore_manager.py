from langchain_community.vectorstores import FAISS
from langchain.text_splitter import RecursiveCharacterTextSplitter
from langchain_community.document_loaders import PyPDFDirectoryLoader
from langchain.memory import ConversationBufferWindowMemory


def load_vectorstore(vectorstore_path, embeddings):
    """Load an existing vectorstore."""
    return FAISS.load_local(
        vectorstore_path, embeddings=embeddings, allow_dangerous_deserialization=True
    )


def create_vectorstore(pdf_path, vectorstore_path, embeddings):
    # 단계 1: 문서 로드
    loader = PyPDFDirectoryLoader(pdf_path)
    docs = loader.load()

    # 단계 2: 문서 분할
    recursive_text_splitter = RecursiveCharacterTextSplitter(
        # 정말 작은 청크 크기를 설정합니다.
        separators=["\n\n", "\n", " ", ""],
        chunk_size=512,
        chunk_overlap=64,
        length_function=len,
        is_separator_regex=False,
    )

    chunked_docs = recursive_text_splitter.split_documents(docs)

    # 단계 3,4: 임베딩 & 벡터 스토어 생성
    # FAISS 사용
    vectorstore = FAISS.from_documents(documents=chunked_docs, embedding=embeddings)

    vectorstore.save_local(vectorstore_path)

    return vectorstore


def create_conversaion_memory(memory_key, output_key):
    # 메모리 컴포넌트 생성
    memory = ConversationBufferWindowMemory(
        return_messages=True,
        memory_key=memory_key,
        output_key=output_key,
    )

    return memory