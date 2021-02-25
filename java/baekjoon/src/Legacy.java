import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
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

}
