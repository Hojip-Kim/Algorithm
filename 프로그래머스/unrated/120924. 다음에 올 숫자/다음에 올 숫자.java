class Solution {
    public int solution(int[] common) {
        int answer = 0;
        int i = 0;
        if(common[1]-common[0] == common[2]-common[1]){
            i = common[common.length - 1];
            i += common[1]-common[0];
        }else{
            i = common[common.length -1];
            i *= common[1]/common[0];
        }
        answer = i;
        return answer;
    }
}