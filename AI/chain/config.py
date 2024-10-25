import os

# Paths
PDF_PATH = r"../kisa_pdf/"
VECTORSTORE_PATH = r"./vector_store_path"
MODEL_PATH = r"llama3.1"

# Embeddings Configuration
EMBEDDINGS_MODEL_NAME = "jhgan/ko-sroberta-nli"
# EMBEDDINGS_MODEL_KWARGS = {"device": "cuda"}
EMBEDDINGS_MODEL_KWARGS = {"device": "cpu"}
EMBEDDINGS_ENCODE_KWARGS = {"normalize_embeddings": True}

# BASE_DIR = os.getenv('BASE_DIR')
# LOCAL_MODEL_PATH = os.path.join(BASE_DIR, "local_model")
LOCAL_MODEL_PATH =r"./local_model"
MODEL_NAME = "MLP-KTLim/llama-3-Korean-Bllossom-8B"