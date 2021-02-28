import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.stream.IntStream;

public class Legacy {

    public Scanner getScanner() {
        return new Scanner(System.in);
    }

    public void test1() {
        System.out.println("|\\_/|");
        System.out.println("|q p|   /}");
        System.out.println("( 0 )\"\"\"\\");
        System.out.println("|\"^\"`    |");
        System.out.println("||_/=\\\\__|");
    }

    public void test2() {
        Scanner s = getScanner();
        int[] nums = Arrays.stream(s.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println((nums[0] + nums[1]) % nums[2]);
        System.out.println(((nums[0] % nums[2]) + (nums[1] % nums[2])) % nums[2]);
        System.out.println((nums[0] * nums[1]) % nums[2]);
        System.out.println(((nums[0] % nums[2]) * (nums[1] % nums[2])) % nums[2]);
    }

    public void test3() {
        Scanner s = getScanner();
        int num1 = s.nextInt();
        int num2 = s.nextInt();
        s.close();
        int sum = 0;
        // 입력받은 두번째 숫자를 문자열로 만듬
        char[] num2Chars = (num2 + "").toCharArray();
        for (int i = 0; i < num2Chars.length; i++) {
            // 두번째 숫자를 하나씩 떼어냄
            char num2Char = num2Chars[i];
            // 문자열 길이 - 반복 횟수 - 1 = 생성될 0의 갯수 ex) 천의 자리 0이 3개, 백의 자리 0이 2개, 십의 자리 0이 1개
            String zeros = new String(new char[num2Chars.length - i - 1]).replace("\0", "0");
            int number = num1 * Integer.parseInt(num2Char + zeros);
            sum += number;
            System.out.println(sum);
        }
        System.out.println(num1 * num2);
    }

    public void test4() {
        Scanner s = getScanner();
        int num1 = s.nextInt();
        int num2 = s.nextInt();
        s.close();
        // 입력받은 두번째 숫자를 문자열로 만듬
        char[] num2Chars = (num2 + "").toCharArray();
        for (int i = num2Chars.length - 1; 0 <= i; i--) {
            // 두번째 숫자를 하나씩 떼어냄
            char num2Char = num2Chars[i];
            int number = num1 * Integer.parseInt(String.valueOf(num2Char));
            System.out.println(number);
        }
        System.out.println(num1 * num2);
    }

    public void test5() {
        Scanner s = getScanner();
        int num = s.nextInt();
        // 윤년 구하기
        if ((num % 4) == 0 && (num % 100) != 0 || (num % 400) == 0) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }

    public void test6() {
        Scanner s = getScanner();
        int x = s.nextInt();
        int y = s.nextInt();
        s.close();
        boolean isUp = 0 < y;
        boolean isRight = 0 < x;
        if (isUp && isRight) {
            // 위이고 우측이면 제1사분면
            System.out.println(1);
        } else if (!isUp && isRight) {
            // 아래이고 우측이면 제4사분면
            System.out.println(4);
        } else if (isUp && !isRight) {
            // 위이고 좌측이면 제2사분면
            System.out.println(2);
        } else if (!isUp && !isRight) {
            // 아래이고 좌측이면 제 3사분면
            System.out.println(3);
        }
    }

    public void test7() {
        Scanner s = getScanner();
        int[] nums = Arrays.stream(s.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int hour = nums[0];
        int minute = nums[1];
        // 입력된 분에서 45를 뺏을 때 0보다 이하라면 hour를 한시간 뺀다.
        if (minute - 45 < 0) {
            hour -= 1;
            minute = 60 + (minute - 45);
        } else {
            minute -= 45;
        }
        if (hour < 0) {
            hour = 23;
        }
        System.out.println(hour + " " + minute);
    }

    public void test8() {
        Scanner s = getScanner();
        int num = s.nextInt();
        // 위에 nextInt는 한 줄을 끝내고 다음 줄을 보는 것이 아니기 때문에 아래 함수를 호출해 다음 줄로 이동시켜야한다.
        s.nextLine();
        String[] arr = new String[num];
        int start = 0;
        while (start < num) {
            arr[start++] = s.nextLine();
        }
        s.close();
        for (String str : arr) {
            int[] nums = Arrays.stream(str.split(" ")).mapToInt(Integer::parseInt).toArray();
            System.out.println(nums[0] + nums[1]);
        }
    }

    public void test9() {
        Scanner s = getScanner();
        int num = s.nextInt();
        s.nextLine();
        int start = 0;
        String[] arr = new String[num];
        while (start < num) {
            arr[start++] = s.nextLine();
        }
        s.close();

        BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            for (int i = 0; i < arr.length; i++) {
                int[] nums = Arrays.stream(arr[i].split(" ")).mapToInt(Integer::parseInt).toArray();
                bf.write(nums[0] + nums[1] + "\n");
            }
            bf.flush();
            bf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void test10() {
        Scanner s = getScanner();
        int num = s.nextInt();
        s.nextLine();
        String[] arr = new String[num];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = s.nextLine();
        }
        s.close();

        BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            for (int i = 0; i < num; i++) {
                int[] nums = Arrays.stream(arr[i].split(" ")).mapToInt(Integer::parseInt).toArray();
                bf.write(
                        "Case #"
                                + (i + 1)
                                + ": "
                                + nums[0]
                                + " + "
                                + nums[1]
                                + " = "
                                + (nums[0] + nums[1])
                                + "\n");
            }
            bf.flush();
            bf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void test11() {
        Scanner s = getScanner();
        int num = s.nextInt();
        s.close();

        BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            for (int i = 0; i < num; i++) {
                String empty = new String(new char[num - i - 1]).replace("\0", " ");
                String zeros = new String(new char[i + 1]).replace("\0", "*");
                bf.write(empty + zeros + "\n");
            }
            bf.flush();
            bf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void test12() {
        Scanner s = getScanner();
        StringBuilder input = new StringBuilder(s.nextLine());
        s.close();
        int answer = Integer.parseInt(input.toString());
        String nextVal;
        int cnt = 0;
        while (true) {
            if (input.length() < 2) {
                if (input.toString().equals("0")) {
                    cnt++;
                    break;
                }
                input.insert(0, "0");
            }
            int num2 = input.charAt(1) - '0';
            nextVal = input.charAt(0) - '0' + num2 + "";
            // char to string = Character.toString(char c)
            input.setLength(0);
            input.append(num2).append(nextVal.charAt(nextVal.length() - 1));
            cnt++;
            if (Integer.parseInt(input.toString()) == answer) break;
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            bw.write(cnt + "");
            bw.flush();
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void test13() {
        Scanner s = getScanner();
        int cnt = s.nextInt();
        s.nextLine();
        double[] nums = Arrays.stream(s.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
        int max = (int) nums[0];
        double sum = 0;
        for (int i = 1; i < nums.length; i++) {
            max = (int) Math.max(max, nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            double num = nums[i];
            nums[i] = num / max * 100;
            sum += nums[i];
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            bw.write(String.valueOf(sum / nums.length));
            bw.flush();
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void test14() {
        Scanner s = getScanner();
        int cnt = s.nextInt();
        s.nextLine();
        int[] score = new int[cnt];
        while (0 < cnt) {
            char[] oxs = s.nextLine().toCharArray();
            int wasO = 0;
            for (int i = 0; i < oxs.length; i++) {
                char ox = oxs[i];
                if (ox == 'O') {
                    if (wasO != 0) {
                        wasO += 1;
                    } else {
                        wasO++;
                    }
                    score[cnt - 1] += wasO;
                } else {
                    wasO = 0;
                }
            }
            cnt--;
        }
        s.close();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            for (int i = score.length - 1; -1 < i; i--) {
                bw.write(score[i] + "\n");
            }
            bw.flush();
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void test15() {
        Scanner s = getScanner();
        int cnt = s.nextInt();
        s.nextLine();
        double[] avgs = new double[cnt];
        while (0 < cnt) {
            int[] nums = Arrays.stream(s.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int avg = 0;
            // 1부터 시작하고 끝까지 가야하기 때문에 nums = 3이라면 1, 2, 3 까지 반복을 돌아야 한다.
            // nums 배열 중 첫번째는 반복 횟수가 되고, 1부터 시작되기 때문에 마지막 숫자도 처리하기 위해선,
            // 주어진 숫자로는 하나가 모자라기 때문에 i < nums[0] + 1이 되어야 한다.
            for (int i = 1; i < nums[0] + 1; i++) {
                int num = nums[i];
                avg += num;
            }
            avg = avg / nums[0];
            int overAvg = 0;
            for (int i = 1; i < nums[0] + 1; i++) {
                if (avg < nums[i]) {
                    overAvg++;
                }
            }
            avgs[cnt - 1] = ((double) overAvg / nums[0]) * 100;
            cnt--;
        }

        s.close();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            for (int i = avgs.length - 1; -1 < i; i--) {
                bw.write(String.format("%.3f", avgs[i]) + "%\n");
            }
            bw.flush();
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    int[] selfNums = new int[10001];

    public void selfNum(int num) {
        int selfNum = num;
        String numStr = num + "";
        char[] chs = numStr.toCharArray();
        for (char ch : chs) {
            int n = ch - '0';
            selfNum += n;
        }
        if (10000 < selfNum) {
            return;
        }
        selfNums[selfNum - 1] = selfNums[selfNum - 1] + 1;
        selfNum(selfNum);
    }

    public void test16() {
        for (int i = 1; i <= 10000; i++) {
            selfNum(i);
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int max = selfNums[0];
        try {
            for (int i = 0; i < 10000; i++) {
                int num = selfNums[i];
                max = Math.max(max, num);
                if (max == num) {
                }
                if (num == 0) {
                    bw.write(i + 1 + "\n");
                }
            }
            bw.flush();
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void test17() {
        Scanner s = getScanner();
        int num = s.nextInt();
        s.nextLine();
        // char array to int array
        int[] nums = s.nextLine().chars().map(ch -> ch - '0').toArray();
        int sum = 0;
        for (int i = 0; i < num; i++) {
            sum += nums[i];
        }
        System.out.println(sum);
    }

    void test18() {
        Scanner s = getScanner();
        String str = s.nextLine();
        int[] nums = IntStream.generate(() -> -1).limit('z' - 'a' + 1).toArray();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int idx = str.indexOf('a' + i);
            if (idx != -1) {
                if (num == -1) {
                    nums[i] = idx;
                }
            }
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            for (int num : nums) {
                bw.write(num + " ");
            }
            bw.flush();
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void test19() {
        Scanner s = getScanner();
        int num = s.nextInt();
        s.nextLine();
        String[] ans = new String[num];
        for (int i = 0; i < num; i++) {
            String[] arr = s.nextLine().split(" ");
            int loop = Integer.parseInt(arr[0]);
            char[] chs = arr[1].toCharArray();
            StringBuilder an = new StringBuilder();
            for (int j = 0; j < chs.length; j++) {
                char ch = chs[j];
                for (int k = 0; k < loop; k++) {
                    an.append(ch);
                }
            }
            ans[i] = an.toString();
        }
    }

    void test20() {
        Scanner s = getScanner();
        String str = s.nextLine().toUpperCase();
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> set = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            set.put(ch, set.getOrDefault(ch, 0) + 1);
        }
        Map.Entry<Character, Integer> max = set.entrySet().stream().max(Map.Entry.comparingByValue()).get();
        char maxChar = max.getKey();
        for (Map.Entry<Character, Integer> entry : set.entrySet()) {
            if (max != entry && max.getValue() <= entry.getValue()) {
                maxChar = '?';
            }
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            bw.write(maxChar);
            bw.flush();
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void test21() {
        Scanner s = getScanner();
        String str = s.nextLine();
        if (str.startsWith(" ")) {
            str = str.substring(1);
        }
        if (str.length() > 0 && str.lastIndexOf(" ") == str.length() - 1) {
            str = str.substring(0, str.length() - 1);
        }

        String[] sts;
        if (str.contains(" ")) {
            sts = str.split(" ");
        } else if(!str.equals("")) {
            sts = new String[]{str};
        } else {
            sts = new String[0];
        }


        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            bw.write(Integer.toString(sts.length));
            bw.flush();
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void test22() {
        Scanner s = getScanner();
        String[] nums = s.nextLine().split(" ");
        int[] rNums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            String num = nums[i];
            // StringBuffer로 문자열 뒤집기
            rNums[i] = Integer.parseInt(new StringBuffer(num).reverse().toString());
        }
        int max = Math.max(rNums[0], rNums[1]);
        System.out.println(max);
    }

    boolean hasCroatia(String str) {
        if (str.contains("c=")) return true;
        if (str.contains("c-")) return true;
        if (str.contains("dz=")) return true;
        if (str.contains("d-")) return true;
        if (str.contains("lj")) return true;
        if (str.contains("nj")) return true;
        if (str.contains("s=")) return true;
        return str.contains("z=");
    }

    void test23() {
        Scanner s = getScanner();
        String str = s.nextLine();
        s.close();
        StringBuffer sb = new StringBuffer();
        while (hasCroatia(str)) {
            if (str.contains("c=")) {
                sb.append("c=");
            } else if (str.contains("c-")) {
                sb.append("c-");
            } else if (str.contains("dz=")) {
                sb.append("dz=");
            } else if (str.contains("d-")) {
                sb.append("d-");
            } else if (str.contains("lj")) {
                sb.append("lj");
            } else if (str.contains("nj")) {
                sb.append("nj");
            } else if (str.contains("s=")) {
                sb.append("s=");
            } else if (str.contains("z=")) {
                sb.append("z=");
            }
            str = str.replace(sb, "*");
            sb.setLength(0);
        }
        System.out.println(str.length());
    }

    void test24() {
        Scanner s = getScanner();
        int num = s.nextInt();
        s.nextLine();
        int cnt = 0;
        for (int i = 0; i < num; i++) {
            String str = s.nextLine();
            if (str.length() < 2) {
                cnt++;
                continue;
            }
            Stack<Character> stack = new Stack<>();
            for (int j = 0; j < str.length(); j++) {
                char ch = str.charAt(j);
                if (stack.isEmpty()) {
                    stack.push(ch);
                    continue;
                }
                if (stack.contains(ch)) {
                    if (ch != stack.peek()) {
                        // 최상단이 아니면 이전에 들어간 값으로 그룹이 아님
                        break;
                    }
                } else {
                    stack.push(ch);
                }

                if (j == str.length() - 1) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

    void test25() {
        Scanner s = getScanner();
        // 고정 비용
        int a = s.nextInt();
        // 가변 비용
        int b = s.nextInt();
        // 노트북 가격
        long c = s.nextLong();

        // 손익분기점 찾기
        int i = -1;
        // 노트북 판매 가격이 가변 비용보다 큰 경우에만 손익분기점을 구할 수 있음
        if (b < c) {
//            while (true) {
//                // 노트북 n대 생산 비용
//                long cost = a + ((long) b * i);
//                // 노트북 가격 (가변 비용 * 노트북 생산 횟수) = 총 가변 비용, 노트북 가격 * 노트북 생산 횟수 = 총 수입
//                long sale = c * i;
//                if (cost < sale) {
//                    break;
//                }
//                i++;
//            }
            i = (int) (a / (c - b) + 1);
        }

        System.out.println(i);
    }
}
