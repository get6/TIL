package hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Test1 {

    public String solution(String[] participant, String[] completion) {
        int idx = 0;
        List<String> arr = Arrays.asList(completion);
        long findCount = 0;

        for (int i = 0; i < participant.length; i++) {
            String runner = participant[i];
            findCount = arr.stream().filter(c -> c.equals(runner)).count();
            if (findCount == 0) {
                idx = i;
                break;
            } else if (1 < findCount) {
                if (!isAllComplete(findCount, runner, completion)) {
                    idx = i;
                    break;
                }
            }

        }
        String answer = participant[idx];
        return answer;
    }


    public String solution2(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);
        System.out.println(Arrays.toString(participant));
        System.out.println(Arrays.toString(completion));
        String answer = participant[participant.length - 1];
        for (int i = 0; i < completion.length; i++) {
            String runner1 = participant[i];
            String runner2 = completion[i];
            if (!runner1.equals(runner2)) {
                answer = runner1;
                break;
            }
        }

        return answer;
    }

    public String solution3(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hm = new HashMap<>();
        // 참가자 이름을 key로 하고 value로는 key마다 배열에 포함된 총 갯수를 더한다.
        for (String player : participant) {
            hm.put(player, hm.getOrDefault(player, 0) + 1);
        }
        // 완주자 이름으로 꺼낸 값에 다시 갯수를 하나씩 배서 0으로 만드려고 한다.
        for (String player : completion) {
            hm.put(player, hm.get(player) - 1);
        }

        // 참가자 목록 중에 0이 아닌 애는 완주하지 못한 사람이기 때문에 0이 아니여서 끝난다.
        for (String key : hm.keySet()) {
            if (hm.get(key) != 0) {
                answer = key;
                break;
            }
        }
        return answer;
    }

    private boolean isAllComplete(long findCount, String runner, String[] completion) {
        List<String> arr = Arrays.asList(completion);
        return findCount == arr.stream().filter(c -> c.equals(runner)).count();
    }

    public static void main(String[] args) {
        Test1 test = new Test1();
        String answer = test.solution3(new String[]{"mislav", "stanko", "mislav", "ana"}, new String[]{"stanko", "ana", "mislav"});
        answer = test.solution2(new String[]{"marina", "josipa", "nikola", "vinko", "filipa"}, new String[]{"josipa", "filipa", "marina", "nikola"});
        System.out.println(answer);
    }
}
