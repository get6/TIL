//
//  node.h
//  c-tutorial
//
//  Created by 황성준 on 2021/06/09.
//

#ifndef __NODE_H
#define __NODE_H

#include <stdio.h>
#include <stdlib.h>

#define TRUE 1
#define FALSE 0

typedef struct _NODE {
    char Data;
    struct _NODE *Left;
    struct _NODE *Right;
} NODE;
//NODE *HeadNode, *EndNode;

#endif /* node_h */
