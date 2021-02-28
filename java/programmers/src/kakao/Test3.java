package kakao;

// 문자열 압축
public class Test3 {

    public int solution(String s) {
        int answer = s.length();

        // i는 문자 길이, 절반만 검사한다. Why? 절반보다 크다면 그 뒤로는 연속된 문자가 존재할 수 없다.
        for (int i = 1; i <= s.length() / 2; i++) {
            // 추출 시작 위치
            int pos = 0;
            // i = 1이면 한글자씩, i = 2이면 두글자씩 자르게 된다.
            int len = s.length();

            // pos부터 pos + i까지 unit을 꺼내와서
            for (; pos + i <= s.length(); ) {
                // pos ~ pos + i에 해당하는 문자열 추출
                String unit = s.substring(pos, pos + i);
                // 추출했으니 추출된 위치의 다음 문자를 자르기 위해 위치값 변경
                pos += i;

                int cnt = 0;
                for (; pos + i <= s.length(); ) {
                    // unit과 다음 문자들이 계속 unit과 일치한다면 true
                    if (unit.equals(s.substring(pos, pos + i))) {
                        // 자른 문자와 이후의 문자가 같다면 해당 문자의 압축 횟수 증가
                        ++cnt;
                        // 횟수 증가됬으니 다음 문자로
                        pos += i;
                    } else {
                        // 다른 경우 다른 문자를 검사하게끔 넘어감
                        break;
                    }
                }
                // 연속된 문자가 하나 이상 존재한다면,
                if (cnt > 0) {
                    // 숫자로 치환된만큼 문자들 빼줘야 한다.
                    len -= i * cnt;
                    // 제출 중에 하나 에러가 났었음 ㅜ
                    String str = cnt + "";
                    len += str.length();

//                    if (cnt < 9) len += 1;
//                    else if (cnt < 99) len += 2;
//                    else if (cnt < 999) len += 3;
//                    else len += 4;
                }
            }

            answer = Math.min(answer, len);
        }

        return answer;
    }

    public int solution2(String s) {
        int answer = 0;

        for (int i = 1; i <= (s.length() / 2) + 1; i++) {
            int result = getSplitedLength(s, i, 1).length();
            answer = i == 1 ? result : Math.min(answer, result);
        }

        return answer;
    }

    public String getSplitedLength(String s, int n, int repeat) {
        if (s.length() < n) return s;
        String result = "";
        String preString = s.substring(0, n);
        String postString = s.substring(n, s.length());

        if (!postString.startsWith(preString)) {
            if (repeat == 1) return result += preString + getSplitedLength(postString, n, 1);
            return result += Integer.toString(repeat) + preString + getSplitedLength(postString, n, 1);
        }

        return result += getSplitedLength(postString, n, repeat + 1);
    }

    public static void main(String[] args) {
        Test3 test3 = new Test3();
        // 2a2ba3c
        int s1 = test3.solution2("ababcdcdababcdcd");
        System.out.println(s1);
    }
}
