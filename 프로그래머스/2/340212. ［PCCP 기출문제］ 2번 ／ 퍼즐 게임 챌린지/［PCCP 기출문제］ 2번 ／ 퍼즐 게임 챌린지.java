class Solution {
    // 현재 퍼즐 난이도 diff
    // 현재 퍼즐 소요시간 time_cur
    // 이전 퍼즐 소요시간 time_prev
    // 숙련도 level
    // diff < level이면 퍼즐 틀리지않음, time_cur 사용 해결
    // diff > level이면 퍼즐을 총 diff-level번 틀림
    // 퍼즐을 틀릴 때 마다 time_cur 만큼의 시간을 사용
    // 추가로 time_prev 만큼의 시간 사용해서 이전 퍼즐 다시 풀고와야함.
    // 단, 이전 퍼즐을 다시 풀 때는 이전 퍼즐 난이도에 상관없이 틀리지않음.
    // diff-level 번 틀린 이후에 다시 퍼즐을 풀면 time_cur 만큼의 시간을 사용하여 퍼즐 해결
    // 숙련도 최소값을 정수로 return하도록 함수완성

    public int solution(int[] diffs, int[] times, long limit) {
        int maxDiff = 0;

        for(int diff : diffs) {
            maxDiff = Math.max(maxDiff, diff);
        }

        int l = 1;
        int r = maxDiff;
        int answer = maxDiff;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (totalTime(diffs, times, mid, limit) <= limit) {
                answer = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return answer;
    }

    private long totalTime(int[] diffs, int[] times, int level, long limit) {
        long sum = 0;
        for (int i = 0; i < diffs.length; i++) {
            if (diffs[i] > level) {
                sum += (diffs[i] - level) * (times[i] + times[i - 1]) + times[i];
            } else {
                sum += times[i];
            }
            if (sum > limit) {
                return sum;
            }
        }
        return sum;
    }
}