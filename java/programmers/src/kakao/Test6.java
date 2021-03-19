package kakao;

public class Test6 {

    int INF = 3 * 100000;

    void floyd(int n, int[][] dist) {
        for (int k = 0; k < n; k++) { // 경유지
            for (int i = 0; i < n; i++) { // 시작점
                for (int j = 0; j < n; j++) { // 도착점
                    int a = dist[i][k];
                    int b = dist[k][j];
                    int c = dist[i][j];
                    if (a + b < c) {
                        System.out.printf("k:%s i:%s j:%s cost:%s\n", k, i, j, a + b);
                        dist[i][j] = a + b;
                    }
                }
            }
        }
    }

    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    dist[i][j] = 0;
                } else {
                    // 최소비용 계산을 위해 최대값으로 지정
                    dist[i][j] = INF;
                }
            }
        }
        for (int[] fare : fares) {
            int x = fare[0];
            int y = fare[1];
            int cost = fare[2];

            dist[x - 1][y - 1] = cost;
            dist[y - 1][x - 1] = cost;
        }
        floyd(n, dist);

        int answer = INF;
        --s;
        --a;
        --b;
        for (int i = 0; i < n; i++) {
            answer = Math.min(answer, dist[s][i] + dist[i][a] + dist[i][b]);
        }
        return answer;
    }

    public static void main(String[] args) {
        Test6 test = new Test6();
        int answer = 0;
        answer = test.solution(6, 4, 6, 2, new int[][]{{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {
                2, 4, 66
        }, {
                2, 3, 22
        }, {
                1, 6, 25
        }
        });
        System.out.println(answer);
        answer = test.solution(7, 3, 4, 1, new int[][]
                {{5, 7, 9}, {4, 6, 4}, {3, 6, 1}, {3, 2, 3}, {2, 1, 6}}
        );
        System.out.println(answer);
    }
}
