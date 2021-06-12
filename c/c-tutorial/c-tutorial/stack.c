//
//  stack.c
//  c-tutorial
//
//  Created by 황성준 on 2021/06/09.
//

#include "node.h"
#define MAX 100

NODE *Stack[MAX];
int Top;

void InitializeStack(void);
void Push(NODE *);
NODE *Pop(void);
int IsStackEmpty(void);

// 스택 초기화 함수
void InitializeStack(void) {
    Top = 0;
}

void Push(NODE *ptrNode) {
    Stack[Top++] = ptrNode;
    Top = Top % MAX;
}

NODE *Pop(void) {
    NODE *ptrNode;
    
    if(!IsStackEmpty()) {
        ptrNode = Stack[--Top];
        
        return ptrNode;
    } else {
        printf("Stack is Empty\n");
    }
    
    return NULL;
}

int IsStackEmpty(void) {
    if(Top == 0) {
        return TRUE;
    } else {
        return FALSE;
    }
}
