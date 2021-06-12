//
//  binary_tree_back_traversal.c
//  c-tutorial
//
//  Created by 황성준 on 2021/06/11.
//

#include "node.h"

// 외부 함수 저의
extern void IntializeStack(void);
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
    
}
