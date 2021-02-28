import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Until_functions {

    public Scanner getScanner() {
        return new Scanner(System.in);
    }

    // 1의 자리는 비교 대상이 없으므로 한수
    // 2의 자리는 비교 대상이 있으나 모두 규칙을 만들고 끝나기 때문에 한수
    // 3의 자리부터 비교 대상의 규칙이 일치한다면 한수
    private boolean isHansu(int num) {
        char[] chs = String.valueOf(num).toCharArray();
        int rule = 0;
        boolean isHansu = false;
        for (int i = 0; i < chs.length - 1; i++) {
            int n1 = chs[i] - '0';
            int n2 = chs[i + 1] - '0';

            if (i == 0) {
                rule = n2 - n1;
                continue;
            }
            if (n2 - n1 == rule) {
                isHansu = true;
            } else {
                isHansu = false;
            }
        }

        return isHansu;
    }

    // 한수란 "각 자릿수들이 등차수열을 이루는 수"이다.
    // 등차수열이란 "각 항들이 일정한 차이를 보이는 수열"
    public void test() {
        Scanner s = getScanner();
        int num = s.nextInt();
        s.close();
        int cnt = 0;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            for (int i = 1; i <= num; i++) {
                if (i < 100) {
                    cnt++;
                } else if (isHansu(i)) {
                    cnt++;
                }
            }
            bw.write(cnt+ "");
            bw.flush();
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // 현재 풀고있는 문제
        Until_functions untilfunctions = new Until_functions();
        untilfunctions.test();
    }

    //    SELECT o.buyer_id, o.buy_date, l.book_name, l.price
//    FROM library AS l
//    JOIN orderInfo AS o
//    on l.book_id = o.book_id
//    WHERE l.book_name = 'Looking with Elice'
//    AND o.buy_date BETWEEN '2020-7-27' AND '2020-07-31'
//    ORDER BY o.buy_date ASC


    int[] nums;
    boolean[] visit;

    void find(int pos) {
        if (!visit[pos]) {
            visit[pos] = true;
            int num = nums[pos];
            find(pos + num);
        }
    }

    void test3() {
        Scanner s = getScanner();
        int n = Integer.parseInt(s.nextLine());
        nums = Arrays.stream(s.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        visit = new boolean[n];
        find(0);
        int cnt = 0;
        for (int i = 0; i < visit.length; i++) {
            if(visit[i]) {
                cnt++;
            }
        }
        System.out.println(cnt + 1);
    }
}
