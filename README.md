# TIL

알고리즘, 자료구조, 운영체제, 프로그래밍 언어 등을 배우기 위한 저장소에요.

사용 언어는 Typescript가 주로 사용되요. 그로 인해 런타임 환경은 Node.js에요.

자료구조를 직접 만들어본 걸 눈으로 확인하고 싶다면 VS Code의 Debug Visualizer 확장자를 설치하세요.

## 개발 환경 구성

42서울에서 공부할 때는 C, C++ 파일을 특정 폴더에 만들고 Makefile 파일에 컴파일해서 실행 파일을 만들었는데요.

이런 환경을 Node.js에서도 구성되면 자료구조 공부할 때 편하겠다는 생각이 들었어요.

코딩테스트도 결국 어떤 환경에서 제가 만든 파일들을 컴파일하고 함수를 호출해서 테스트해볼거라 예상이 들어서 비슷하게 만들 수 있을 것 같았어요.

Typescript를 쓰기 위해서 먼저 프로젝트 초기화가 필요해요. `pnpm init`으로 초기화 할게요.

이제 package.json에 패키지를 추가해요

- `pnpm add typescript`
- `pnpm add -D ts-node @types/node`

환경을 구성할 땐 필요한 것들이 필요하다고 생각했어요.

- typescript
- prettier
- eslint
- swc
