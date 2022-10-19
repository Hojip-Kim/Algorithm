class Solution {
    public int solution(int n) {
        int answer = 0;
        
        if(Math.sqrt(n) == (int)Math.sqrt(n)){
            answer = 1;
        }else{
            answer = 2;
        }
        

        return answer;
    }
}