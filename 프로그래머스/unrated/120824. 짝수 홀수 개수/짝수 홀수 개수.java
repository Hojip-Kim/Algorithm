class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = {};
        int cnt1 = 0;
        int cnt2 = 0;
        for(int i = 0; i<num_list.length; i++){
            if(num_list[i] % 2 == 0){
                cnt2++;
            }else{
                cnt1++;
            }
        }
        answer = new int[]{cnt2, cnt1};

        return answer;
    }
}