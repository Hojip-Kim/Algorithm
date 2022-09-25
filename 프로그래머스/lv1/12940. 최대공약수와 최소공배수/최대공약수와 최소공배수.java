

class Solution {
    public int[] solution(int n, int m) {
        int[] answer = {};
        int measure = 0;
        int multiple = 0;
        if(n<=m){
        for(int i = 1; i<=m; i++){
            if(n%i == 0 && m%i == 0){
                measure = i;
            }
        }
        }else{
            for(int i = 1; i<=n; i++){
                if(n%i == 0 && m%i == 0){
                    measure = i;
                }
            }
        }
        multiple = m*n / measure;
        answer = new int[]{measure, multiple};
        return answer;
    }
}
