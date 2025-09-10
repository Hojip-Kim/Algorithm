class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int m = arr1.length;        // arr1 행
        int k = arr1[0].length;     // arr1 열 = arr2 행
        int n = arr2[0].length;     // arr2 열

        int[][] answer = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = 0;
                for (int t = 0; t < k; t++) {
                    sum += arr1[i][t] * arr2[t][j];
                }
                answer[i][j] = sum;
            }
        }
        return answer;
    }
}
