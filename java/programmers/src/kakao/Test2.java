package kakao;

// 신규 아이디 추천
public class Test2 {

    private boolean isValid(char c) {
        // 여기서 문자, 숫자만 허용
        if (Character.isLetterOrDigit(c)) return true;
        // 허용된 특정 문자들
        if (c == '-' || c == '_' || c == '.') return true;

        return false;
    }

    public String solution(String new_id) {
        StringBuilder answer = new StringBuilder();

        boolean isLastDot = false;
        for (char c : new_id.toCharArray()) {
            if (!isValid(c)) continue;

            // .이라면 수행하는 구간
            if (c == '.') {
                // 아직 더해지기 전과 이전 반복이 .인 경우에는 통과
                if (answer.length() == 0 || isLastDot) continue;
                // .을 찾은 표시
                isLastDot = true;
            } else {
                // .이 아닌 경우 해당 변수 초기화
                isLastDot = false;
            }

            c = Character.toLowerCase(c);
            answer.append(c);
        }

        if (answer.length() > 15) {
            answer.setLength(15);
        }

        if (answer.length() == 0) {
            answer.append('a');
        }

        if (answer.charAt(answer.length() - 1) == '.') {
            answer.setLength(answer.length() - 1);
        }

        if (answer.length() < 3) {
            char cha = answer.charAt(answer.length() - 1);
            while (answer.length() < 3) {
                answer.append(cha);
            }
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        Test2 test2 = new Test2();
        String answer = test2.solution("...!@BaT#*..y.abcdefghijklm");
        System.out.println(answer);
    }
}
