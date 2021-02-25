package codeup;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Legacy {

    public static Scanner getScanner() {
        return new Scanner(System.in);
    }

    public static void test() {
        Scanner s = new Scanner(System.in);
        int length = 0;
        String str = s.nextLine();
        s.close();

        String[] arr = str.split(" ");

        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; 0 <= i; i--) {
            sb.append(arr[i]).append(" ");
        }
        String res = sb.toString();
        if (res.lastIndexOf(" ") == res.length() - 1) {
            res = sb.substring(0, sb.length() - 1);
        }
        System.out.println(res);
    }

    public static void test2() {
        Scanner s = new Scanner(System.in);
        System.out.printf("%.2f", s.nextFloat());
    }


    public static void test3() {
        Scanner s = new Scanner(System.in);
        int str = s.nextInt();
        System.out.printf("%d %d %d", str, str, str);
    }

    public static void test4() {
        Scanner s = getScanner();
        String str = s.nextLine();
        DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
        Date date = null;
        try {
            date = dateFormat.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println(dateFormat.format(date));
    }

    public static void test5() {
        Scanner s = getScanner();
        String str = s.nextLine();
        String[] arr = str.split("\\.");
        int[] arr1 = new int[arr.length];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = Integer.parseInt(arr[i]);
        }

        System.out.printf("%d.%02d.%02d%n", arr1[0], arr1[1], arr1[2]);
    }

    public static void test6() {
        Scanner s = getScanner();
        String str = s.nextLine();
        String[] arr = str.split("-");
        System.out.println(arr[0] + arr[1]);
    }

    public static void test7() {
        Scanner s = getScanner();
        String str = s.nextLine();
        for (int i = 0; i < str.length(); i++) {
            System.out.printf("'%s'\n", str.charAt(i));
        }
    }

    public static void test8() {
        Scanner s = getScanner();
        String str = s.nextLine();
        int num = Integer.parseInt(str);
        for (int i = 0; i < str.length(); i++) {
            int zero = (str.length() - i);
            System.out.println(String.format("[%-" + zero + "s]", str.charAt(i)).replace(' ', '0'));
        }

    }

    public static void test9() {
        Scanner s = getScanner();
        String str = s.nextLine();
        String[] arr = str.split(":");
        int[] num = new int[arr.length];
        for (int i = 0; i < num.length; i++) {
            num[i] = Integer.parseInt(arr[i]);
        }
        LocalTime lt = LocalTime.of(num[0], num[1], num[2]);
        System.out.println(lt.getMinute());
    }

    public static void test10() {
        Scanner s = getScanner();
        int num = s.nextInt();
        System.out.println((char) num);
    }

    public static void test11() {
        Scanner s = getScanner();
        String str = s.nextLine();
        String[] arr = str.split(" ");
        long[] num = new long[arr.length];
        for (int i = 0; i < num.length; i++) {
            num[i] = Long.parseLong(arr[i]);
        }
        long res = num[0] + num[1];
        System.out.println(res);
    }

    public static void test12() {
        Scanner s = getScanner();
        String str = s.next();
        char cha = (char) (str.charAt(0) + 1);
        System.out.println(cha++);
    }

    public static void test13() {
        Scanner s = getScanner();
        String[] arr = s.nextLine().split(" ");
        int[] num = new int[arr.length];
        for (int i = 0; i < num.length; i++) {
            num[i] = Integer.parseInt(arr[i]);
        }
        int res = num[0] % num[1];
        System.out.println(res);
    }

    public static void test14() {
        Scanner s = getScanner();
        String[] arr = s.nextLine().split(" ");
        int[] num = new int[arr.length];
        for (int i = 0; i < num.length; i++) {
            num[i] = Integer.parseInt(arr[i]);
        }
        System.out.println(num[0] + num[1]);
        System.out.println(num[0] - num[1]);
        System.out.println(num[0] * num[1]);
        System.out.println(num[0] / num[1]);
        System.out.println(num[0] % num[1]);
        double db = (double) num[0] / num[1];

        System.out.printf("%.2f", Math.round(db * 100) / 100.0);
    }

    public static void test15() {
        Scanner s = getScanner();
        String[] arr = s.nextLine().split(" ");
        int[] num = new int[arr.length];
        for (int i = 0; i < num.length; i++) {
            num[i] = Integer.parseInt(arr[i]);
        }

        int sum = 0;
        for (int i = 0; i < num.length; i++) {
            sum += num[i];
        }
        System.out.println(sum);
        System.out.printf("%.1f", Math.round((double) sum / num.length * 10) / 10.0);
    }

    public static void test16() {
        Scanner s = getScanner();
        int num = s.nextInt();
        System.out.println(~num);
    }

    public static void test17() {
        Scanner s = getScanner();
        String[] arr = s.nextLine().split(" ");
        int[] num = new int[arr.length];
        for (int i = 0; i < num.length; i++) {
            num[i] = Integer.parseInt(arr[i]);
            if (num[i] % 2 == 0) {
                System.out.println("even");
            } else {
                System.out.println("odd");
            }
        }
    }

    public static void test18() {
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

    public static void test19() {
        Scanner s = getScanner();
        String[] arr = s.nextLine().split(" ");

        for (int i = 1; i <= Integer.parseInt(arr[0]); i++) {
            for (int j = 1; j <= Integer.parseInt(arr[1]); j++) {
                System.out.println(i + " " + j);
            }
        }
    }

    public static void test20() {
        Scanner s = getScanner();
        String str = s.nextLine();
        // 문자열을 16진수로 변경한다.
        int hex = Integer.parseInt(str, 16);
        for (int i = 1; i < 16; i++) {
            // 16진수를 16진수 문자열로 변환한다.
            System.out.printf("%s*%s=%S\n", str, String.format("%X", i), Integer.toHexString(hex * i));
        }
    }

    public static void test21() {
        Scanner s = getScanner();
        int num = s.nextInt();
        for (int i = 1; i <= num; i++) {
            String str = i % 3 == 0 ? "X" : i + "";
            System.out.printf("%S ", str);
        }
    }

    // 시간초과 에러남
    public static void test22() {
        Scanner s = getScanner();
        String[] arr = s.nextLine().split(" ");
        int[] num = new int[arr.length];
        for (int i = 0; i < num.length; i++) {
            num[i] = Integer.parseInt(arr[i]);
        }

        int resIdx = 0;
        int cnt = num[0] * num[1] * num[2];
        String[] res = new String[cnt];
        for (int i = 0; i < num[0]; i++) {
            for (int j = 0; j < num[1]; j++) {
                for (int k = 0; k < num[2]; k++) {
                    res[resIdx++] = String.format("%d %d %d\n", i, j, k);
                }
            }
        }
        for (String re : res) {
            System.out.print(re);
        }
        System.out.println(cnt);
    }

    public static void test23() {
        Scanner s = getScanner();
        String[] arr = s.nextLine().split(" ");
        // num[0]: 1초 동안 마이크로 소리강약을 체크하는 수
        // num[1]: 한 번 체크한 결과를 저장하는 비트
        // num[2]: 좌우 등 소리를 저장할 트랙 개수인 채널
        // num[3]: 녹음한 시간 s
        double[] num = new double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            num[i] = Double.parseDouble(arr[i]);
        }
        // 계산
        double res = (num[0] * num[1] * num[2] * num[3]) / 8.0;
        // MB로 변환
        res = res / 1024 / 1024;
        // 소수점 처리
        res = Math.round(res * 10) / 10.0;
        System.out.printf("%.1f MB", res);
    }

    public static void test24() {
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


    public static void test25() {
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

    public static void test26() {
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

    public static void test27() {
        Scanner s = getScanner();
        String[] arr = s.nextLine().split(" ");
        int[] num = new int[arr.length];
        for (int i = 0; i < num.length; i++) {
            num[i] = Integer.parseInt(arr[i]);
        }

        long res = num[0];
        // n번째를 찾기위해 i는 1부터 시작
        for (int i = 1; i < num[3]; i++) {
            // 이전 값을 계산 전인 res에 존재하고 계산한 결과를 res에 다시 담아야 한다.
            res = res * num[1] + num[2];
        }
        System.out.println(res);
    }

    public static void test28() {
        Scanner s = getScanner();
        String[] arr = s.nextLine().split(" ");
        int[] num = new int[arr.length];
        for (int i = 0; i < num.length; i++) {
            num[i] = Integer.parseInt(arr[i]);
        }
        int res = 1;
        while (true) {

            if (res % num[0] == 0 && res % num[1] == 0 && res % num[2] == 0) {
                break;
            }
            res++;
        }
        System.out.println(res);
    }

    public static void test29() {
        Scanner s = getScanner();
        // List<Integer> list = IntStream.rangeClosed(1, 23).boxed().collect(Collectors.toList());
        List<Integer> list = Stream.generate(() -> 0).limit(23).collect(Collectors.toList());
        int max = Integer.parseInt(s.nextLine());
        String[] arr = s.nextLine().split(" ");
        s.close();
        int[] num = new int[arr.length];
        for (int i = 0; i < num.length; i++) {
            num[i] = Integer.parseInt(arr[i]);
        }
        for (int i = 0; i < max; i++) {
            int callVal = num[i] - 1;
            int listVal = list.get(callVal);
            list.set(callVal, ++listVal);
        }
        for (int val : list) {
            System.out.print(val + " ");
        }
    }

    public static void test30() {
        Scanner s = getScanner();
        int max = Integer.parseInt(s.nextLine());
        String[] arr = s.nextLine().split(" ");
        s.close();
        int[] num = new int[arr.length];
        for (int i = 0; i < num.length; i++) {
            num[i] = Integer.parseInt(arr[i]);
        }
        List<Integer> list = Arrays.stream(num).boxed().collect(Collectors.toList());
        Collections.reverse(list);
        for (int val : list) {
            System.out.print(val + " ");
        }
    }

    public static void test31() {
        Scanner s = getScanner();
        int max = Integer.parseInt(s.nextLine());
        String[] arr = s.nextLine().split(" ");
        s.close();
        int[] num = new int[arr.length];
        for (int i = 0; i < num.length; i++) {
            num[i] = Integer.parseInt(arr[i]);
        }
        List<Integer> list = Arrays.stream(num).boxed().collect(Collectors.toList());
        Collections.reverse(list);
        int min = list.stream().min(Comparator.naturalOrder()).orElse(0);
        System.out.println(min);
    }

    public static void test32() {
        Scanner s = getScanner();
        int max = Integer.parseInt(s.nextLine());
        int cnt = 0;
        int[][] pan = new int[19][19];
        while (s.hasNextLine()) {
            String[] arr = s.nextLine().split(" ");
            int[] num = new int[arr.length];
            for (int i = 0; i < num.length; i++) {
                num[i] = Integer.parseInt(arr[i]);
            }
            pan[num[0] - 1][num[1] - 1] = 1;
            cnt++;
            if (max <= cnt) {
                break;
            }
        }
        s.close();

        for (int i = 0; i < 19; i++) {
            StringBuilder str = new StringBuilder();
            for (int j = 0; j < 19; j++) {
                int dol = pan[i][j];
                str.append(dol == 1 ? 1 : 0).append(" ");
            }
            System.out.println(str);
        }
    }

    public static void test33() {
        Scanner s = getScanner();
        int max = 0;
        int[][] pan = new int[19][19];

        while (s.hasNextLine()) {
            String[] arr = s.nextLine().split(" ");
            int[] arrNum = new int[arr.length];
            for (int i = 0; i < arrNum.length; i++) {
                arrNum[i] = Integer.parseInt(arr[i]);
            }
            // 한 배열을 그대로 복사하는 경우 사용
            System.arraycopy(arrNum, 0, pan[max], 0, pan.length);
//            for (int i = 0; i < pan.length; i++) {
//                pan[max][i] = arrNum[i];
//            }
            max++;
            if (19 <= max) {
                break;
            }
        }
        max = 0;
        int cnt = Integer.parseInt(s.nextLine());
        while (s.hasNextLine()) {
            String[] arr = s.nextLine().split(" ");
            int[] arrNum = new int[arr.length];
            for (int i = 0; i < arrNum.length; i++) {
                arrNum[i] = Integer.parseInt(arr[i]);
            }
            int first = arrNum[0] - 1;
            int second = arrNum[1] - 1;
            for (int i = 0; i < pan.length; i++) {
                int val = pan[first][i];
                pan[first][i] = val < 1 ? 1 : 0;
            }

            for (int i = 0; i < pan.length; i++) {
                int val = pan[i][second];
                pan[i][second] = val < 1 ? 1 : 0;
            }
            max++;
            if (cnt <= max) {
                break;
            }
        }
        s.close();
        for (int i = 0; i < pan.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < pan[i].length; j++) {
                sb.append(pan[i][j]);
                if (j != pan[i].length - 1) {
                    sb.append(" ");
                }

            }
            System.out.println(sb.toString());
        }
    }

    public static void test34() {
        Scanner s = getScanner();
        // String[] to int[]
        int[] arrNum = Arrays.stream(s.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] fields = new int[arrNum[0]][arrNum[1]];
        // 좌표를 받을 횟수
        int num = Integer.parseInt(s.nextLine());
        // 막대 정보가 담길 배열
        int[][] sticks = new int[num][4];
        for (int i = 0; i < sticks.length; i++) {
            sticks[i] = Arrays.stream(s.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int len = sticks[i][0];
            // 0 가로, 1 세로
            int direction = sticks[i][1];
            int x = sticks[i][2] - 1;
            int y = sticks[i][3] - 1;
            if (direction == 0) {
                // 가로면 한 행을 찾아서 1을 삽입
                // 2차원 위치가 고정
                for (int j = 0; j < len; j++) {
                    fields[x][y++] = 1;
                }
            } else {
                // 세로면 한 열을 찾아서 1을 삽입
                // 1차원 위치가 고정
                for (int j = 0; j < len; j++) {
                    fields[x++][y] = 1;
                }
            }
        }
        s.close();
        for (int[] field : fields) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < field.length; j++) {
                sb.append(field[j]);
                if (j != field.length - 1) {
                    sb.append(" ");
                }
            }
            System.out.println(sb);
        }
    }

    public static void test35() {
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

    }
}
