package codeup;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static Scanner getScanner() {
        return new Scanner(System.in);
    }

    public static void test() {
        Scanner s = getScanner();
        int[][] mazes = new int[10][10];
        // String[] to int[]
        for (int i = 0; i < 10; i++) {
            mazes[i] = Arrays.stream(s.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        s.close();
        boolean find = false;
        int start = 0;
        for (int i = 0; i < mazes.length; i++) {
            int[] maze = mazes[i];
            for (int j = start; j < maze.length; j++) {
                int path = maze[j];
                if (path == 1) {
                    continue;
                }
                if (path == 0) {
                    maze[j] = 9;
                    if (j != maze.length - 1 && maze[j + 1] == 1) {
                        start = j;
                        break;
                    }
                }
                if (path == 2) {
                    maze[j] = 9;
                    find = true;
                    break;
                }
            }
            if (find) {
                break;
            }
        }
        for (int i = 0; i < mazes.length; i++) {
            int[] maze = mazes[i];
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < maze.length; j++) {
                sb.append(maze[j]);
                if (j != maze.length - 1) {
                    sb.append(" ");
                }
            }
            System.out.println(sb);
        }
    }

    public static void main(String[] args) {
        test();
    }
}