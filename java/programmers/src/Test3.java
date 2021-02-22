import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Test3 {

    // 서로 다른 옷의 조합의 수를 구하라.
    public int solution(String[][] clothes) {
        // 곱해지기 위해 1로 설정
        int answer = 1;

        // 하나의 아이템과 같이 입을 수 있는 의상 찾기
        HashMap<String, Integer> hm = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            String[] arr = clothes[i];
            // 의상명
            String name = arr[0];
            // 의상 유형
            String type = arr[1];
            // hm에서 type으로 값을 꺼내온 후 없다면 0을 반환 그리고 1을 더해 hm에 담는다.
            hm.put(type, hm.getOrDefault(type, 0) + 1);
        }

        // 값만 불러오기
        for (int val : hm.values()) {
            // 상황 1 : headgear: 2, eyewear: 1 / answer = 1번째 (1*3) * 2번째 (3*2) = 6
            // 상황 2 : face: 3 / answer = 1번째 (1*4) = 4
            answer *= val + 1;
        }

        // 아무것도 입지 않는 날은 세지 않는다.
        return answer - 1;
    }

    public int solution2(String[][] clothes) {
        System.out.println(Arrays.stream(clothes)
                .collect(Collectors.groupingBy(p -> p[1], Collectors.mapping(p -> p[0], Collectors.counting()))));
        System.out.println(Arrays.stream(clothes)
                .collect(Collectors.groupingBy(p -> p[1], Collectors.mapping(p -> p[0], Collectors.counting()))).values());
        System.out.println(Arrays.stream(clothes)
                .collect(Collectors.groupingBy(p -> p[1], Collectors.mapping(p -> p[0], Collectors.counting()))).values().stream().reduce(1L,(aLong, aLong2) -> aLong * (aLong2 + 1)).intValue());
        return Arrays.stream(clothes)
                .collect(Collectors.groupingBy(p -> p[1], Collectors.mapping(p -> p[0], Collectors.counting())))
                .values().stream().reduce(1L, (x, y) -> x * (y + 1)).intValue() - 1;
    }

    public static void main(String[] args) {
        Test3 test3 = new Test3();
        int num = test3.solution2(new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {
                "green_turban", "headgear"}});
        System.out.println(num);
        num = test3.solution2(new String[][]{{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {
                "smoky_makeup", "face"}});
        System.out.println(num);
    }
}
