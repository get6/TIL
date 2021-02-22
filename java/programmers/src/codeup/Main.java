package codeup;

import java.util.Scanner;

public class Main {

    public static Scanner getScanner() {
        return new Scanner(System.in);
    }

    public static void test20() {
        Scanner s = getScanner();
        int max = s.nextInt();
        int sum = 0;

        for (int i = 0; i < max; i++) {
            sum += i;
            if (max <= sum) {
                System.out.println(i);
                break;
            }
        }

    }

    public static void main(String[] args) {
        test20();
    }
}
