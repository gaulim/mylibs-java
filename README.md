# mylibs-java

[![](https://jitpack.io/v/kr.gaulim/mylibs-java.svg?label=Release)](https://jitpack.io/#kr.gaulim/mylibs-java)

유용한 Java 라이브러리

[https://jitpack.io/#kr.gaulim/mylibs-java](https://jitpack.io/#kr.gaulim/mylibs-java)

## 라이브러리 내역 및 기능

* 파일 -> FileUtil [새것]
> - 파일 및 디렉토리가 있는지 검사  
> - 파일 및 디렉토리 생성  
> - 파일 읽기  
> - 파일 및 디렉토리 복사  
> - 파일 및 디렉토리 지움  

* 숫자 -> NumberUtil [새것]
> - 숫자 배열에서 최대값/최소값 추출  
> - 지정한 자료 크기로부터 최적화된 버퍼 크기 구함  
> - 수치형 문자열에 1000자리 구분기호 삽입  

* 임의값 -> RandomGenerator [새것]
> - 임의 알파벳 소문자 또는 대문자 문자열 생성  
> - 임의 수치형 문자열 (10진수 및 16진수) 생성  
> - 임의 숫자 (정수 및 실수) 1개 생성  
> - 임의 정수 n개를 배열로 생성  
> - 사용자 정의 키 문자열 생성  

* 범위 -> RangeChecker [새것]
> 지정한 범위 관련 값으로 유효한 범위인지 판단  
> - 기준 색인번호와 개수로 유효한 범위인지 판단  
> - 기준 색인번호와 시작/끝 색인번호로 유효한 범위인지 판단  

* 문자 -> Nvl [새것]
> 문자열 객체 값이 null 이거나 "null" 인 경우 빈 문자열로 치환  

* 문자 -> StringChecker [새것]
> 정규식 및 특정 알고리즘을 이용한 문자열 값 유효성 검사기  
> - 색상코드 유효성 검사  
> - 전자우편 주소 유효성 검사  
> - 16진수 유효성 검사  
> - IP주소(ver.4) 유효성 검사  
> - 포트번호 유효성 검사  
> - URL 유효성 검사  
> - 태그 유효성 검사  
> - UUID 유효성 검사  
> - 지번주소(대한민국) 유효성 검사  
> - 도로명주소(대한민국) 유효성 검사  
> - 금액 유효성 검사  
> - 휴대폰번호(대한민국) 유효성 검사  
> - 전화번호(대한민국) 유효성 검사  
> - 주민등록번호(대한민국) 유효성 검사  
> - 카드번호 유효성 검사 (룬 공식 - LUHN Formula == 모듈러스 10 == mod 10)  

* 문자 -> StringReplacer [새것]
> 정규식 및 특정 알고리즘을 이용한 문자열 치환기  
> - 태그 제거  
> - 링크 문자열을 링크 태그 형식으로 바꿈  
> - 단어 비식별화  
> - 이름 비식별화  
> - 전화번호 비식별화  
> - 카드번호 비식별화  
> - 전자우편 주소 비식별화  
> - 대한민국 전화번호 형식으로 치환  
> - 금칙어 처리  

* 문자 -> 정규식 -> REGEXP [새것]
> 정규식(공통)  
> - 색상 코드  
> - 전자우편  
> - 16진수  
> - IPv4  
> - 포트번호  
> - 태그(공통)  
> - 태그(SRC속성)  
> - URL  
> - UUID  

* 문자 -> 정규식 -> REGEXP_KOR [새것]
> 정규식(대한민국)  
> - 지번 주소  
> - 도로명 주소  
> - 통화  
> - 휴대폰번호  
> - 전화번호  
> - 주민등록번호  

