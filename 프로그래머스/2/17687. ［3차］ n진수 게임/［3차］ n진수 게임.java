class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder all = new StringBuilder(t * m + 10);

        int num = 0;
        while (all.length() < t * m) {
            all.append(Integer.toString(num++, n).toUpperCase());
        }

        StringBuilder ans = new StringBuilder(t);
        int idx = p - 1;
        for (int i = 0; i < t; i++) {
            ans.append(all.charAt(idx));
            idx += m;
        }
        return ans.toString();
    }
}
