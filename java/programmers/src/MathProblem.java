import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class MathProblem {

    // 분수찾기
    public void test() {
        Scanner s = new Scanner(System.in);
        // 찾을 분수의 번째
        int num = s.nextInt();
        s.close();
        // 1/1 1/2 2/1 3/1 2/2
        int cnt = 0;
        while (num > 0) {
            cnt++;
            num -= cnt;
        }
        if (cnt % 2 == 0) {
            System.out.printf("%d/%d\n", cnt + num, 1 + (-num));
        } else {
            System.out.printf("%d/%d\n", 1 + (-num), cnt + num);
        }
    }

    // 분수찾기
    public void test2() {
        Scanner s = new Scanner(System.in);
        // 찾을 분수의 번째
        int num = s.nextInt();
        s.close();
        int a = 1;
        while (num > a) {
            num -= a++;
        }
        if (a % 2 == 0) {
            System.out.println(num + "/" + (a + 1 - num));
        } else {
            System.out.println((a + 1 - num) + "/" + num);
        }
    }

    public void test3() {
        try {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            int[] nums = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int a = nums[0]; // 낮에 올라갈 수 있는 미터 2
            int b = nums[1]; // 밤에 미끄러지는 미터 1
            int v = nums[2]; // 높이가 v인 나무 막대 5
            bf.close();
            // 소괄호들이 먼저 계산되고 + 1
            int days = (v - b - 1) / (a - b) + 1;
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            bw.write(days + "");
            bw.flush();
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MathProblem mp = new MathProblem();
        mp.test3();
    }
}
