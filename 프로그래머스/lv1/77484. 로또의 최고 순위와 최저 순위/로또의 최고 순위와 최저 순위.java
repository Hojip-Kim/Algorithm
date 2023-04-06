import java.util.ArrayList;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int cnt1 = 0;
        int cnt2 = 0;

        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < win_nums.length; i++) {
            arr.add(win_nums[i]);
        }

        for (int i = 0; i < lottos.length; i++) {
        if(arr.contains(lottos[i])){
            cnt1++;
            } else if (lottos[i] == 0) {
            cnt2++;
        }
        }
        
        int[] answer = new int[]{7-(cnt1+cnt2),7-cnt1};
        if(cnt1 == 0 && cnt2 == 0){
            answer[0] = 6;
            answer[1] = 6;
        }else if(cnt1 == 0){
            answer[1] = 6;
        }
        
        return answer;
    }
}