import java.util.*;

public class DFSandBFS {
    private Scanner getScanner() {
        return new Scanner(System.in);
    }

    int n, m, v;
    int[][] inputs;
    boolean[] visitArr;
    List<List<Integer>> graphs;

    void test1() {
        Scanner s = getScanner();
        int[] conditions = Arrays.stream(s.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        // 정점의 개수
        n = conditions[0];
        // 간선의 개수
        m = conditions[1];
        // 탐색을 시작할 정점의 번호
        v = conditions[2];
        // 입력값을 담을 배열. 숫자를 하나씩 늘려주고 이 숫자값 그대로 배열 위치에 값을 넣었다는 표시를 해줄 것이다.
        inputs = new int[n + 1][n + 1];
        visitArr = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            int[] nums = Arrays.stream(s.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int n1 = nums[0]; // 간선으로 이어진 정점 1
            int n2 = nums[1]; // 정점 1과 간선으로 이어진 정점 2
            // 양방향인 경우 양쪽 다 지정
            inputs[n1][n2] = inputs[n2][n1] = 1;
        }

        // 0=DFS, 1=BFS
        graphs = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            graphs.add(new ArrayList<>());
        }

        dfs(v);
        visitArr = new boolean[n + 1];
        bfs(v);

        for (List<Integer> graph : graphs) {
            String str = graph.toString();
            System.out.println(str.substring(1, str.length() -1).replace(",", ""));
        }
    }

    void dfs(int v) {
        visitArr[v] = true;
        graphs.get(0).add(v);
        for (int i = 1; i < n + 1; i++) {
            if (inputs[v][i] == 1 && !visitArr[i]) {
                dfs(i);
            }
        }
    }

    void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visitArr[v] = true;

        while (!queue.isEmpty()) {
            v = queue.poll();
            graphs.get(1).add(v);
            for (int i = 1; i < n + 1; i++) {
                if (inputs[v][i] == 1 && !visitArr[i]) {
                    queue.offer(i);
                    visitArr[i] = true;
                }
            }
        }
    }

    void test2() {
        Scanner s = getScanner();
        int n = s.nextInt();
        int m = s.nextInt();
        boolean[][] network = new boolean[n + 1][n + 1];
        boolean[] visit = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            int u = s.nextInt();
            int v = s.nextInt();
            network[u][v] = true;
            network[v][u] = true;
        }
        s.close();

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visit[1] = true;
        int cnt = 0;
        while (!queue.isEmpty()) {
            int x = queue.poll();
            for (int i = 1; i <= n; i++) {
                if (network[x][i] && !visit[i]) {
                    queue.offer(i);
                    visit[i] = true;
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}
