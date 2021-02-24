package stack;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Test1 {

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new ConcurrentLinkedDeque<>();
        int answer = 0;
        int sum = 0;
        // 트럭 갯수만큼 반복 진행
        for (int truck_weight : truck_weights) {
            // 특정 조건에 일치할때까지 현재 트럭이 다리를 지나야 함
            while (true) {
                if (queue.isEmpty()) {
                    // 큐가 비어있다면

                    // 아무것도 큐에 없다면 큐에 삽입
                    queue.add(truck_weight);
                    // 무계 합계에 트럭 무게를 더함
                    sum += truck_weight;
                    // 시간 증가
                    answer++;
                    // 다음 트럭으로
                    break;
                } else if (queue.size() == bridge_length) {
                    // 큐에 들어있는 트럭의 갯수와 다리 길이와 같다면(다리 1당 트럭 1대가 차지한다.)

                    // 큐에서 첫번째 값을 꺼내고 현재 합계값에서 다리를 다 지난 트럭의 무게만큼 뺀다.
                    sum -= queue.poll();
                } else {
                    if (weight < sum + truck_weight) {
                        // 다리가 버티는 무게 < 현재 통과 중인 트럭들의 무게 합 + 현재 트럭의 무게가 더 크다면

                        // 시간 증가
                        answer++;
                        // 다리의 무게보다 현재 무게와 더하지 않은 현재 트럭의 값이 더 크기 때문에
                        // 빈값을 넣음으로써 다리 길이를 맞춘다.
                        queue.add(0);
                    } else {
                        queue.add(truck_weight);
                        sum += truck_weight;
                        answer++;
                        // 다음 트럭으로
                        break;
                    }
                }
            }
        }
        // 소요 시간 + 다리의 무게
        return answer + bridge_length;
    }

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        int res = 0;
        res = test1.solution(2, 10, new int[]{7, 4, 5, 6});
        System.out.println(res);
        res = test1.solution(100, 100, new int[]{10});
        System.out.println(res);
    }
}
