//
//  queue_using_linked_list.c
//  c-tutorial
//
//  Created by 황성준 on 2021/06/08.
//

#include <stdio.h>
#include <stdlib.h>

typedef struct _NODE {
    int Data;
    struct _NODE *Next;
} NODE;

NODE *Front, *Rear;
NODE *ptrNode;

void InitializeQueue(void);
void Put(int);
int Get(void);
void DisplayQueue_linked_list(void);

void InitializeQueue(void) {
    Front = (NODE *)malloc(sizeof(NODE));
    Rear = (NODE *)malloc(sizeof(NODE));
    Front->Next = Rear;
    Rear->Next = Front;
}

void Put(int num) {
    ptrNode =  (NODE *)malloc(sizeof(NODE));
    ptrNode->Data = num;
    
    if(Front->Next == Rear) {
        Front->Next = ptrNode;
        ptrNode->Next = Rear;
        Rear->Next = ptrNode;
    } else {
        Rear->Next->Next = ptrNode;
        ptrNode->Next = Rear;
        Rear->Next = ptrNode;
    }
}

int Get(void) {
    int ret;
    NODE *deleteNode;
    printf("\n");
    
    if (Front->Next == Rear) {
        printf("Queue Empty\n");
    } else {
        deleteNode = Front->Next;
        Front->Next = deleteNode->Next;
        ret = deleteNode->Data;
        printf("get() : %d", ret);
        
        free(deleteNode);
    }
    
    return ret;
}

void DisplayQueue_linked_list(void) {
    NODE *ptrTemp;
    
    if(Front->Next != Rear) {
        for(ptrTemp = Front->Next; ptrTemp->Next != Rear; ptrTemp = ptrTemp->Next) {
            printf("%d -> ", ptrTemp->Data);
        }
        
        printf("%d\n",ptrTemp->Data);
    } else if (Front->Next == Rear) {
        printf("Queue Empty\n");
    }
}

void start_queue_linked_list() {
    int ret;
    InitializeQueue();
    printf("Put() 함수를 호출해보자!\n");
    
    Put(1);
    Put(3);
    Put(10);
    Put(20);
    Put(12);
    
    printf("다섯 번의 Put() 함수 호출 후 결과\n");
    DisplayQueue_linked_list();
    
    ret = Get();
    ret = Get();
    ret = Get();
    
    printf("세 번의 Get() 함수 호출 후 결과\n");
    DisplayQueue_linked_list();
    
    printf("두 번의 Get() 함수 호출 후 결과\n");
    
    ret = Get();
    ret = Get();
    
    DisplayQueue_linked_list();
}
