import java.util.Arrays;
import java.util.Scanner;

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
    // x, y 좌표로 사분면 구하기
    if (isUp && isRight) {
      System.out.println(1);
    } else if (!isUp && isRight) {
      System.out.println(4);
    } else if (isUp && !isRight) {
      System.out.println(3);
    } else if (!isUp && !isRight) {
      System.out.println(4);
    }
  }
}
