//
//  binary_tree.c
//  c-tutorial
//
//  Created by 황성준 on 2021/06/09.
//

#include "node.h"

// 회부 함수 정의
extern void InitializeStack(void);
extern void Push(NODE *);
extern NODE *Pop(void);
extern int IsStackEmpty(void);

// 내부 함수 정의
void InitializeTree(void);
void MakeTree(void);
void Traverse(NODE *);
void Visit(NODE *);

// 전역 번수 정의
NODE *Parent, *LeftChild, *RightChild;
NODE *HeadNode, *EndNode;

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
    
    Parent = Parent->Left; // A -> B
    
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
    Parent = HeadNode->Right->Right; // Head -> Root -> C
    
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

void Traverse(NODE *ptrNode) {
    Push(ptrNode);
    
    while (!IsStackEmpty()) {
        ptrNode = Pop();
        Visit(ptrNode);
        
        if(ptrNode->Right != EndNode) {
            Push(ptrNode->Right);
        }
        if(ptrNode->Left != EndNode) {
            Push(ptrNode->Left);
        }
    }
}

void Visit(NODE *ptrNode) {
    printf("%2c ", ptrNode->Data);
}


void start_binary_tree(void) {
    InitializeStack();
    InitializeTree();
    MakeTree();
    Traverse(HeadNode->Left);
}
