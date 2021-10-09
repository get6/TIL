//
//  binary_tree_back_traversal.c
//  c-tutorial
//
//  Created by 황성준 on 2021/06/11.
//

#include "node.h"

// 외부 함수 저의
extern void InitializeStack(void);
extern void Push(NODE *);
extern NODE *Pop(void);
extern int IsStackEmpty(void);

// 내부 함수 정의
void InitializeTree(void);
void MakeTree(void);
void Recursive_Traverse(NODE *);
void Stack_Traverse(NODE *);
void Visit(NODE *);

// 전역 변수 정의
NODE *Parent, *LeftChild, *RightChild, *HeadNode, *EndNode;

// 트리의 초기화
void InitializeTree(void) {
    HeadNode = (NODE *)malloc(sizeof(NODE));
    EndNode = (NODE *)malloc(sizeof(NODE));
    
    HeadNode->Left = EndNode;
    HeadNode->Right = EndNode;
    
    EndNode->Left = EndNode;
    EndNode->Right = EndNode;
}

// 트리의 초기 구성
void MakeTree(void) {
    Parent = (NODE *)malloc(sizeof(NODE));
    Parent->Data = 'A';
    
    LeftChild = (NODE *)malloc(sizeof(NODE));
    LeftChild->Data = 'B';
    
    RightChild = (NODE *)malloc(sizeof(NODE));
    RightChild->Data = 'C';
    
    Parent->Left = LeftChild;
    Parent->Right = RightChild;
    
    HeadNode->Left = Parent;
    HeadNode->Right = Parent;
    
    Parent = Parent->Left;
    
    LeftChild = (NODE *)malloc(sizeof(NODE));
    LeftChild->Data = 'D';
    LeftChild->Left = EndNode;
    LeftChild->Right = EndNode;
    
    RightChild = (NODE *)malloc(sizeof(NODE));
    RightChild->Data = 'E';
    RightChild->Left = EndNode;
    RightChild->Right = EndNode;
    
    Parent->Left = LeftChild;
    Parent->Right = RightChild;
    Parent = HeadNode->Right->Right;
    
    LeftChild = (NODE *)malloc(sizeof(NODE));
    LeftChild->Data = 'F';
    LeftChild->Left = EndNode;
    LeftChild->Right = EndNode;
    
    RightChild = (NODE *)malloc(sizeof(NODE));
    RightChild->Data = 'G';
    RightChild->Left = EndNode;
    RightChild->Right = EndNode;
    
    Parent->Left = LeftChild;
    Parent->Right = RightChild;
}

// 재귀 호출을 사용한 트리의 순회 알고리즘
void Recursive_Traverse(NODE *ptrNode) {
    if(ptrNode != EndNode) {
        Recursive_Traverse(ptrNode->Left);
        Recursive_Traverse(ptrNode->Right);
        Visit(ptrNode);
    }
}

// 스택을 사용한 트리의 순회 알고리즘
void Stack_Traverse(NODE *ptrNode) {
    int Finish = 0;
    NODE *ptrVisited = EndNode;
    NODE *ptrPushed = EndNode;
    
    do {
        while (ptrNode != EndNode && ptrNode != ptrVisited) {
            if(ptrNode != ptrPushed) {
                Push(ptrNode);
            }
            
            if(ptrNode->Right != EndNode) {
                Push(ptrNode->Right);
            }
            
            if(ptrNode->Left != EndNode) {
                Push(ptrNode->Left);
            }
            
            ptrPushed = ptrNode->Left;
            ptrNode = ptrNode->Left;
        }
        
        if(!IsStackEmpty()) {
            ptrNode = Pop();
            
            if (ptrNode->Left != EndNode && ptrNode->Right == EndNode && ptrNode->Left != ptrVisited) {
                Push(ptrNode);
                ptrNode = ptrNode->Left;
            }
            
            if (ptrNode->Right == EndNode || ptrNode->Right == ptrVisited) {
                Visit(ptrNode);
                ptrVisited = ptrNode;
            }
        } else {
            Finish = 1;
        }
    } while(!Finish);
}

void Visit(NODE *ptrNode) {
    printf("%2c -> ", ptrNode->Data);
}

void start_binary_tree_back_traversal(void) {
    InitializeStack(); // 스택의 초기화
    InitializeTree(); // 트리의 초기화
    MakeTree(); // 트리의 구성
    printf("재귀 호출을 사용한 후위 순회 : ");
    
    Recursive_Traverse(HeadNode->Left); // 재귀 호출로 트리의 순환
    printf("\n스택을 사용한 후위 순회 : ");
    
    Stack_Traverse(HeadNode->Left);
}
