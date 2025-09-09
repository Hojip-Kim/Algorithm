import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        // 정렬: col - 1 기준 오름차순, 같으면 첫 번째 열 내림차순
        Arrays.sort(data, (a, b) -> {
            if (a[col - 1] == b[col - 1]) {
                return b[0] - a[0]; // 첫 번째 열 내림차순
            }
            return a[col - 1] - b[col - 1]; // col 기준 오름차순
        });

        int answer = 0;

        for (int i = row_begin - 1; i < row_end; i++) {
            int sum = 0;
            for (int val : data[i]) {
                sum += val % (i + 1);
            }
            answer ^= sum;
        }

        return answer;
    }
}
