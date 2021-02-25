package kakao;

import java.util.*;

// 메뉴 리뉴
public class Test1 {
    List<Map<String, Integer>> foodMaps = new ArrayList<>();
    int[] maxCnt = new int[11];

    private void comb(char[] chas, int pos, StringBuilder sb) {
        // 문자열의 길이보다 pos의 길이가 길다면 끝까지 도달한 경우이다.
        if (pos >= chas.length) {
            int len = sb.length();
            if (2 <= len) {
                Map<String, Integer> foodMap = foodMaps.get(len);
                String str = sb.toString();
                int cnt = foodMap.getOrDefault(str, 0) + 1;
                foodMap.put(str, cnt);
                maxCnt[len] = Math.max(maxCnt[len], cnt);
            }
            return;
        }

        comb(chas, pos + 1, sb.append(chas[pos]));
        sb.setLength(sb.length() - 1);
        comb(chas, pos + 1, sb);
    }

    public String[] solution(String[] orders, int[] course) {
        for (int i = 0; i < 11; i++) {
            foodMaps.add(new HashMap<>());
        }
        for (String order : orders) {
            char[] chas = order.toCharArray();
            // Colletions.sort랑은 다르다
            Arrays.sort(chas);
            comb(chas, 0, new StringBuilder());
        }
        List<String> list = new ArrayList<>();
        // 코스요리로 지정할 갯수를 반복해서 돌며 foodMaps에서 Map을 꺼낸다.
        for (int len : course) {
            // len의 값으로(코스로 지정할 갯수) foodMap을 반복시킨다.
            for (Map.Entry<String, Integer> food : foodMaps.get(len).entrySet()) {
                // 조합된 음식이 시켜진 횟수
                int val = food.getValue();
                // 횟수 == 코스로 지정할 갯수 중에서 제일 큰 값이 같다면 넣는다.
                if (val >= 2 && val == maxCnt[len]) {
                    list.add(food.getKey());
                }
            }
        }
        Collections.sort(list);
        String[] answer = list.toArray(String[]::new);
        System.out.println(Arrays.toString(answer));
        return answer;
    }

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        test1.solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[]{2, 3, 4});
    }
}
