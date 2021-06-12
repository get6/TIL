#include <stdio.h>

//void start_queue_linked_list(void);
//void start_binary_tree(void);
//void start_binary_tree_lieutenant_tour(void);

int main() {
    int place = 0, index = 0, img_height = 0, img_width = 0;
    char *fileName = "./image.png";
    
    FILE *fp = fopen(fileName, "rb+");
    if(fp == NULL) {
        printf("IS NULL");
        return 0;
    }
    rewind(fp);
    int size[8];
    char data;
    while (place <= 24) {
        place++;
        data = fgetc(fp);
        if (place > 16) {
            size[index++] = (int) data;
        }
    }
    
    for (int i = 0; i < 4; i++) {
        if(size[i] < 0) {
            size[i] = (size[i] * 2147483647) & 255;
        }
    }
    img_width = 256 * size[2] + size[3];
    img_height = 256 * size[6] + size[7];
    
    printf("Width : %d\nHeight : %d", img_width, img_height);
}
