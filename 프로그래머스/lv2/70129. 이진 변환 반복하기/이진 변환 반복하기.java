class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        int before = 0;
        int cnt = 0;

        int after = 0;
        //제거할 0의 개수
        int zero_num_cnt = 0;

        while(!s.equals("1")){
            before = s.length();
            s = s.replace("0", "");
            after =  s.length();
            zero_num_cnt += before - after;

            s = Integer.toBinaryString(after);
            cnt++;

        }
        answer = new int[]{cnt, zero_num_cnt};
        return answer;
    }
}