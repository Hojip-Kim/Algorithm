class Solution {
    private static int answer = 0;
    public int solution(int[] numbers, int target) {
        recursion(numbers, target, 0, 0);
        
        return answer;
    }
    
    public void recursion(int[] numbers, int target, int depth, int result) {
        if(depth == numbers.length){
            if(target == result){
                answer++;
            }
            return;
        }
        
        
        int plus = result + numbers[depth];
        int minus = result - numbers[depth];
        
        recursion(numbers, target, depth+1, plus);
        recursion(numbers, target, depth+1, minus);
        
    }
    
    
}