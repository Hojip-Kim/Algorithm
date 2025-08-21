class Solution {
    public int[] solution(int n, long left, long right) {
        int len = (int)(right - left + 1);
        int[] answer = new int[len];
        
        for (long i = left; i <= right; i++) {
            // 행
            int row = (int)(i / n);
            // 열
            int col = (int)(i % n);
            answer[(int)(i - left)] = Math.max(row, col) + 1;
        }
        
        return answer;
    }
}
