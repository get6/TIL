public class AverageFinder {
    double computeAverage(int[] intArray) {
        // 코드를 입력하세요.
        double sum = 0;
        for(int arr : intArray) {
            sum += arr;
        }
        return sum / intArray.length;
    }
}
