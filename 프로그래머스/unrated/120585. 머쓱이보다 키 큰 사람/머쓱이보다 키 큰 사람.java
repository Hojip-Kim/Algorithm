class Solution {
    public int solution(int[] array, int height) {
        int answer = 0;
        
        for(int item : array){
            if(height<item){
                answer++;
            }
        }
        return answer;
    }
}