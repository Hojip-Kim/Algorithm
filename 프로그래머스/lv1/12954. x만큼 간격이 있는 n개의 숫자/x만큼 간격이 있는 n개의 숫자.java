class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        int j = 0;
        long i = 1;


        while(j<n){
            answer[j] = x * i;
            i++;
            j++;
        }

        for(int l =0; l<answer.length; l++){
            System.out.print(" " + answer[l]);
        }

        return answer;
    }
}