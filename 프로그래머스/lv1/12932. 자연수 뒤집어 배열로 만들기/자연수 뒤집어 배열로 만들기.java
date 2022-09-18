class Solution {
    public int[] solution(long n) {
        int[] answer = {};
        int i = 0;
            answer = new int[(int) Math.log10(n) + 1];

            do {
                answer[i] = (int) (n % 10);
                n /= 10;
                i++;
            } while (n >= 1L);
            return answer;

    }
}