class Solution {
    public long solution(long n) {
        long answer = 0;


        do{
            answer *=10;
            answer += n%10;
            n /= 10;
        }while(n>=1);
        return answer;
    }
}