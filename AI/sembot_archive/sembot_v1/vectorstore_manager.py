import os

from langchain_community.vectorstores import FAISS
from langchain_community.vectorstores.utils import DistanceStrategy
from utils import get_embeddings, file_splitter


def create_vectorstore_by_FAISS(file_dir_path: str, vectorstore_path: str, embeddings):
    """
    FAISS 벡터 데이터베이스를 생성합니다.

    Args:
        file_dir_path (str): 규정 파일이 있는 디렉토리 경로
        vectorstore_path (str): 생성한 벡터 스토어를 로컬에 저장할 경로
        embeddings (_type_): 벡터로 변환할 때 사용할 임베딩 모델 객체ㅌ

    Returns:
        VectorStore: 벡터 스토어
    """
    chunked_docs = file_splitter(file_dir_path)

    vectorstore = FAISS.from_documents(
        documents=chunked_docs,
        embedding=embeddings,
        distance_strategy=DistanceStrategy.COSINE,
    )

    vectorstore.save_local(vectorstore_path)

    return vectorstore


def load_vectorstore_by_FAISS(vectorstore_path: str, embeddings: str):
    """
    Load an existing vectorstore

    Args:
        vectorstore_path (str): 로컬 벡터스토어 경로
        embeddings (_type_): 벡터로 변환할 때 사용할 임베딩 모델 객체

    Returns:
        VectorStore: 벡터 스토어
    """
    return FAISS.load_local(
        vectorstore_path, embeddings=embeddings, allow_dangerous_deserialization=True
    )


def get_vectorestore_by_FAISS(vectorestore_path: str, file_dir_path: str):
    """
    FAISS 벡터 스토어 생성 또는 불러올 때 사용할 유틸함수
    벡터 스토어 로컬 경로에 벡터 스토어가 있으면 불러오고 없으면 생성 후 리턴한다.

    Args:
        vectorstore_path (str): 로컬 벡터스토어 경로
        pdf_dir_path (str): pdf 파일 디렉토리 경로

    Returns:
        VectorStore: 벡터 스토어
    """

    embeddings = get_embeddings()

    # Load or create vectorstore
    if os.path.exists(vectorestore_path):
        print("Loading existing vectorstore...")
        loaded_vectorstore = load_vectorstore_by_FAISS(vectorestore_path, embeddings)
    else:
        print("Vectorstore not found. Creating a new one...")
        loaded_vectorstore = create_vectorstore_by_FAISS(
            file_dir_path, vectorestore_path, embeddings
        )

    return loaded_vectorstore


if __name__ == "__main__":
    vector_store = load_vectorstore_by_FAISS("../vector_store_test", get_embeddings())

    # print(vector_store.similarity_search("코로나 환자 관리  에 대하여 알려줘"))
    print(vector_store.similarity_search(""))