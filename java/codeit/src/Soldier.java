import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Soldier {
    public static int getSurvivingIndex(int n, int k) {
        // 코드를 입력하세요.
        ArrayList<Integer> soldiers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            soldiers.add(i);
        }
        int kill = 0;
        // ArrayList에 1개만 남으면 반복 종료
        while (soldiers.size() > 1) {

            // 1번째  (0 + 5 - 1) =  4, 4 % 20 = 4
            // 2번째  (4 + 5 - 1) =  8, 8 % 19 = 8
            // 3번째  (8 + 5 - 1) = 12, 12 % 18 = 12
            // 4번째 (12 + 5 - 1) = 16, 12 % 17 = 16
            // 5번째 (16 + 5 - 1) = 20, 20 % 16 = 4
            kill = (kill + k - 1) % soldiers.size();
            System.out.println(soldiers.remove(kill) + "번 군사가 죽었습니다.");
        }

        return soldiers.get(0);
    }

    public static void main(String[] args) {
        Map<String, String> dict = new HashMap<>();
        for(String key : dict.keySet()) {

        }
        System.out.println("김신은 " + getSurvivingIndex(20, 5) + "번 자리에 서있으면 됩니다.");
    }
}