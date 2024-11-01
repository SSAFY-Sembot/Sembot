import os

from langchain.memory import ConversationBufferWindowMemory
from langchain.text_splitter import RecursiveCharacterTextSplitter
from langchain_community.document_loaders import PDFPlumberLoader, PyPDFDirectoryLoader
from langchain_community.vectorstores import FAISS


# PDF 파일명들을 로드하는 함수
def load_pdf_files(pdf_path):
    """주어진 디렉토리에서 모든 PDF 파일들을 로드합니다."""
    pdf_files = []
    for root, dirs, files in os.walk(pdf_path):
        for file in files:
            if file.endswith(".pdf"):
                pdf_files.append(os.path.join(root, file))
    return pdf_files


# PDF를 JSON으로 변환하는 함수
def pdf_splitter(pdf_path):
    pdf_files = load_pdf_files(pdf_path)
    all_documents = []

    for pdf_file in pdf_files:
        loader = PDFPlumberLoader(pdf_file)
        documents = loader.load()  # PDF 문서를 로드합니다

        # 텍스트를 작은 청크로 분할
        text_splitter = RecursiveCharacterTextSplitter(
            chunk_size=512,  # 각 청크의 최대 문자 수
            chunk_overlap=64,  # 청크 간 중복되는 문자 수
        )
        chunked_documents = text_splitter.split_documents(documents)
        all_documents.extend(chunked_documents)

    return all_documents


def load_vectorstore(vectorstore_path, embeddings):
    """Load an existing vectorstore."""
    return FAISS.load_local(
        vectorstore_path, embeddings=embeddings, allow_dangerous_deserialization=True
    )


def create_vectorstore(pdf_path, vectorstore_path, embeddings):

    chunked_docs = pdf_splitter(pdf_path)

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
