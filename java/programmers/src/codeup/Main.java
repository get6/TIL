package codeup;

import java.util.Scanner;

public class Main {

    public static Scanner getScanner() {
        return new Scanner(System.in);
    }

    public static void test20() {
        Scanner s = getScanner();
        String[] arr = s.nextLine().split(" ");
        long[] num = new long[arr.length];
        for (int i = 0; i < num.length; i++) {
            num[i] = Integer.parseInt(arr[i]);
        }
        int max = 1;
        long sum = 1;
        for (long i = num[0]; ; i = num[1]) {
            if (num[2] < max) {
                break;
            }
            sum *= i;
            max++;
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        test20();
    }
}
