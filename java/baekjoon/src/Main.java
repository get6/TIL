import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

  public Scanner getScanner() {
    return new Scanner(System.in);
  }

  public void test() {
    Scanner s = getScanner();
    int[] condArr = Arrays.stream(s.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    int[] nums = Arrays.stream(s.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    s.close();

    BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(System.out));
    try {
      for (int i = 0; i < condArr[0]; i++) {
        int num = nums[i];
        if (num < condArr[1]) {
          String str = num + " ";
          bf.write(str);
        }
      }
      bf.flush();
      bf.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    // 현재 풀고있는 문제
    Main main = new Main();
    main.test();
  }
}
