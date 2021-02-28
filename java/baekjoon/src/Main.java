import java.util.*;

public class Main {

    private Scanner getScanner() {
        return new Scanner(System.in);
    }

    String[] list;
    int[][] inputs;
    boolean[] visit;

    // 단방향 그래프
    void test() {
        Scanner sc = getScanner();
        String[] list = sc.nextLine().split(" ");
        int num = Integer.parseInt(sc.nextLine());
        int[][] inputs = new int[list.length + 1][list.length + 1];
        // 방문 처리용
        boolean[] visit = new boolean[list.length];
        for (int i = 0; i < num; i++) {
            String[] skills = sc.nextLine().split(" ");
            char s1 = (char) (skills[0].charAt(0) - 'a' + 1);
            char s2 = (char) (skills[1].charAt(0) - 'a' + 1);
            inputs[s1][s2] = 1;
        }

        bfs(list[0].charAt(0));
    }

    void bfs(char ch) {
        Queue<Character> queue = new LinkedList<>();
        queue.add(ch);
        visit[ch] = true;

        while (!queue.isEmpty()) {
            ch = queue.poll();
            for (int i = 1; i < list.length + 1; i++) {
                ch = list[i].charAt(0);
                if (inputs[ch][i] == 1 && !visit[i]) {
                    queue.offer(ch);
                    visit[i] = true;
                }
            }
        }
    }

    void test2() {
        Scanner s = getScanner();
        int[] nums = Arrays.stream(s.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        // 땅콩의 개수
        int n = nums[0];
        // 먹으려는 땅콩 개수
        int m = nums[1];
        // 소마의 위치
        int e = nums[2];

        int[] locations = Arrays.stream(s.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

    }


    void test4() {
        // 1시간당 천원
        // 매일 h시간
        // p대의 PC
        // ex 2 pc * 4 = 7명의 손님 4시간 이상 신청한 손님은 이용 못하고 금액을 계싼 안함

        Scanner s = getScanner();
        int[] nums = Arrays.stream(s.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        // PC 대수
        int p = nums[0];
        // 손님 수
        int n = nums[1];
        // 피시방 운영 시간
        int h = nums[2];
        Map<Integer, Integer> hm = new HashMap<>();
        int[][] inputs = new int[n][p];

        for (int i = 0; i < n; i++) {
            int[] res = Arrays.stream(s.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            inputs[i] = res;
        }

        for (int i = 0; i < p; i++) {
            hm.put(i + 1, 0);
        }

        for (int i = 0; i < inputs.length; i++) {
            int[] input = inputs[i];
            int x = input[0]; // 이용할 PC 번호
            int y = input[1]; // 이용할 시간
            int max = hm.get(x);
            if (y + max <= h) {
                hm.put(x, y + max);
            }
        }

        for (Map.Entry<Integer, Integer> en : hm.entrySet()) {
            System.out.println(en.getKey() + " " + (en.getValue() * 1000));
        }
    }

    int find(int pos, int[] nums, int len) {
        if (len < 1) {
            return 0;
        }
        int max = nums[pos];
        int cnt = pos;
        for (int i = pos + 1; i < len; i++) {
            max = Math.max(max, nums[i]);
            if (max <= nums[i]) {
                cnt = i;
            }
        }
        cnt = Math.max(cnt, len /2);
        find(cnt, nums, len / 2);

        return max;
    }

    public void test5() {
        Scanner sc = getScanner();
        int n = Integer.parseInt(sc.nextLine());
        int[] nums = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int max = find(0, nums, nums.length);
        System.out.println(max);

    }

    public static void main(String[] args) {
        Main ts = new Main();
        ts.test5();
    }
}
