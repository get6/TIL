package kakao;

import java.util.Stack;

public class Test4 {

    int pos;

    boolean isCorrect(String str) {
        boolean ret = true;
        int left = 0, right = 0;
        Stack<Character> myStack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                left++;
                // left일때만 넣어줌으로써 right인 경우일 때, 이전 값이 '('인걸 알 수 있다.
                myStack.push('(');
            } else {
                right++;
                if (myStack.isEmpty()) {
                    // 비어있다는 건 ')'이 먼저 나온 경우
                    ret = false;
                } else {
                    // 이전에 '('가 있기 때문에, 없앰
                    myStack.pop();
                }
            }
            if (left == right) {
                // 잘라야하는 기준은 균형잡힌 괄호 문자열 다음이기 때문에 1을 더함
                pos = i + 1;
                return ret;
            }
        }

        return true;
    }

    public String solution(String p) {
        if (p.isEmpty()) return p;

        // 올바른 괄호 문자열인지 확인한다.
        boolean correct = isCorrect(p);
        // 균형잡힌 괄호 문자열을 u
        String u = p.substring(0, pos);
        String v = p.substring(pos);
        if (correct) {
            return u + solution(v);
        }

        StringBuilder answer = new StringBuilder("(" + solution(v) + ")");
        for (int i = 1; i < u.length() - 1; i++) {
            if (u.charAt(i) == '(') {
                answer.append(')');
            } else {
                answer.append('(');
            }
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        Test4 test4 = new Test4();
        String a1 = test4.solution("(()())()");
        System.out.println(a1);
        String a2 = test4.solution(")(");
        System.out.println(a2);
        String a3 = test4.solution("()))((()");
        System.out.println(a3);
    }
}
