import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        HashSet a = new HashSet();

        for(int item : nums){
            a.add(item);
        }

        if(a.size() <=nums.length/2){
            answer = a.size();
        }
        else{
            answer = nums.length/2;
        }

        return answer;
    }
}