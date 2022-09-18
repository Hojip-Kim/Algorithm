class Solution {
    public long solution(long n) {
        long answer = -1;
        long i = 0;
        do {
            i++;
            if(n == Math.pow(i, 2)){
            answer += Math.pow(i+1, 2)+1;
            break;
            }
            else continue;



        }while(i <= n/2);

        return answer;
    }
}