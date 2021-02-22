import java.util.Arrays;
import java.util.HashSet;

public class Test2 {

    public boolean solution(String[] phone_book) {
        HashSet<String> hs = new HashSet<>(Arrays.asList(phone_book));
        boolean answer = true;
        for (String num : phone_book) {
            // contains 사용시 접두사가 아니므로 테스트 실패하는 경우가 있음(1, 5번 테스트) 0 == indexOf으로 수
            long cnt = hs.stream().filter(c -> !num.equals(c) && 0 == num.indexOf(c)).count();
            if (0 < cnt) {
                answer = false;
            }
            if (!answer) {
                break;
            }
        }

        return answer;
    }

    public boolean solution2(String[] phone_book) {
        for (int i = 0; i < phone_book.length; i++) {
            for (int j = i + 1; j < phone_book.length; j++) {
                if (phone_book[i].startsWith(phone_book[j])) {
                    return false;
                }
                if (phone_book[j].startsWith(phone_book[i])) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("987989".startsWith("87"));
        Test2 test2 = new Test2();
        boolean ans = test2.solution2(new String[]{"119", "97674223", "1195524421"});
        System.out.println(ans);
        ans = test2.solution2(new String[]{"123", "456", "789"});
        System.out.println(ans);
    }
}
