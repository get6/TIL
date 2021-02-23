package codeup;

import java.util.Scanner;

public class Undef {

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

    public static void test21() {
        Scanner s = getScanner();
        String[] arr = s.nextLine().split(" ");
        double[] num = new double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            num[i] = Double.parseDouble(arr[i]);
        }
        double res = num[0] * num[1] * num[2] / 8.0;
        res = res / 1024 / 1024;
        res = Math.round(res * 100.0) / 100.0;
        System.out.printf("%.2f MB", res);
    }


}
