package kakao;

import java.util.Arrays;

public class Test5 {

    public boolean solution(int[][] key, int[][] lock) {
        // 한 칸이라도 겹쳐야 의미가 있기 때문에 복사할 자물쇠의 위치
        int offset = key.length - 1;
        // 5 * 5 * 4 * 3 * 3 = 480번 80개의 arr를 만들고 자물쇠를 넣어준다.
        for (int r = 0; r < offset + lock.length; r++) { // offset + lock.length = 2 + 3
            for (int c = 0; c < offset + lock.length; c++) { // Column도 정사각형이라 최대 반복 횟수는 같다.
                // 4번 90도씩 오른쪽으로 회전한다.
                for (int rot = 0; rot < 4; rot++) {
                    // 키와 자물쇠과 들어갈 2차원 배열 만듬
                    int[][] arr = new int[58][58];
                    // arr를 만들고 전부 0으로 비어있는 배열에 자물쇠의 위치를 저장한다.
                    for (int i = 0; i < lock.length; i++) {
                        for (int j = 0; j < lock[i].length; j++) {
                            // 자물쇠를 위치시킴
                            // 자물쇠를 네번 회전시켜도 자물쇠는 고정된 위치에 지정된다. 그러나 4번씩 반복되면서 새롭게 만들어지는 이유는 키가 배열에 저장되기 때문에
                            // 키를 제거하는 것 대신 새롭게 만들기 때문이다. 효율은 테스트를 해봐야 하지만..
                            arr[offset + i][offset + j] = lock[i][j];
                        }
                    }
                    // key를 arr에 rot의 값에 맞게 4방향 중 한 방향으로 삽입
                    match(arr, key, rot, r, c);
                    // 삽입된 키의 값이 lock 위치에서 다 1인지 확인
                    if (check(arr, offset, lock.length)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean check(int[][] arr, int offset, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 0 또는 2이면 열 수 없는 key
                if (arr[offset + i][offset + j] != 1) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * @param arr 자물쇠 배열
     * @param key 열쇠 배열
     * @param rot 방향
     * @param r   행
     * @param c   열
     */
    private void match(int[][] arr, int[][] key, int rot, int r, int c) {
        int n = key.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 자물쇠 주변으로 가기 위해
                // arr 2차원에는 i에 행을 더한 값
                // arr 1차원에는 i에 열을 더한 값
                if (rot == 0) {
                    // 정방향
                    // key는 그대로
                    // [0, 0, 0]
                    // [1, 0, 0]
                    // [0, 1, 1]
                    arr[r + i][c + j] += key[i][j];
                } else if (rot == 1) {
                    // 왼쪽으로 90도 회전
                    // n - 1 - i는 아무리 빼봤자 최소 0까지뿐이다. 3 - 1 - [0-2]
                    // [0, 0, 1]
                    // [0, 0, 1]
                    // [0, 1, 0]
                    arr[r + i][c + j] += key[j][n - 1 - i];
                } else if (rot == 2) {
                    // 왼쪽으로 180도 회전
                    // n - 1 - [ij]는 아무리 빼봤자 최소 0까지뿐이다. 3 - 1 - [0-2]
                    // [1, 1, 0]
                    // [0, 0, 1]
                    // [0, 0, 0]
                    arr[r + i][c + j] += key[n - 1 - i][n - 1 - j];
                } else {
                    // 왼쪽으로 270도 회전
                    // n - 1 - [j]는 아무리 빼봤자 최소 0까지뿐이다. 3 - 1 - [0-2]
                    // [0, 1, 0]
                    // [1, 0, 0]
                    // [1, 0, 0]
                    arr[r + i][c + j] += key[n - 1 - j][i];
                }
            }
        }
    }

    public static void main(String[] args) {
        Test5 test5 = new Test5();

        boolean answer = test5.solution(new int[][]{{0, 0, 0}, {1, 0, 0}, {0, 1, 1}}, new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}});
        System.out.println(answer);
    }
}
