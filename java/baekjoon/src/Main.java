import java.util.Scanner;

public class Main {

  public Scanner getScanner() {
    return new Scanner(System.in);
  }

  public void test() {
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

  public static void main(String[] args) {
    // 현재 풀고있는 문제
    Main main = new Main();
    main.test();
  }
}
