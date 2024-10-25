from huggingface_hub import snapshot_download
from transformers import AutoModelForCausalLM, AutoTokenizer, pipeline
from langchain_huggingface.llms import HuggingFacePipeline
import torch

def create_model(model_name, model_path):
    # 모델을 복사해 옵니다. 현재는 llama-3 8B의 한국어 파인튜닝 모델을 복사
    # 모델 스냅샷 다운로드
    snapshot_download(
        repo_id=model_name,
        local_dir=model_path,
        local_dir_use_symlinks=False  # 완전한 파일 복사본을 다운로드
    )

    print("모델 다운로드 완료")

def load_model(model_path):
    # 토크나이저와 모델 불러오기
    tokenizer = AutoTokenizer.from_pretrained(model_path, trust_remote_code=True)
    # torch_dtype와 device_map 파라미터 적용
    model = AutoModelForCausalLM.from_pretrained(
        model_path, 
        trust_remote_code=True, 
        torch_dtype=torch.bfloat16,  # bfloat16을 사용하여 메모리 절약
        device_map="auto"  # GPU 자동 분배
    )

    # 파이프라인 구성
    pipe = pipeline(
        "text-generation", 
        model=model, 
        tokenizer=tokenizer, 
        max_new_tokens=512,  # 생성할 토큰 수 설정
        temperature=0.6,  # 텍스트 생성에 사용되는 온도값
        top_p=0.9,  # top-p 샘플링
        return_full_text=False,  # 답변만 출력
        eos_token_id=[tokenizer.eos_token_id, tokenizer.convert_tokens_to_ids("<|eot_id|>")]  # 문장 종료 토큰 설정
    )
        
    # HuggingFacePipeline을 사용하여 LLM 인스턴스 생성
    llm = HuggingFacePipeline(pipeline=pipe)

    return llm