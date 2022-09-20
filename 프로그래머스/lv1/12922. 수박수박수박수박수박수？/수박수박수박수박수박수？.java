import java.util.ArrayList;

class Solution {
    public String solution(int n) {
        String answer = "";

        ArrayList<String> arr = new ArrayList<String>();


        for(int i=1; i<=n; i++){
        if(i%2 == 1){
            arr.add("수");
        }else {
            arr.add("박");
        }
        }

        for(int j=0; j<arr.size(); j++){
            answer += arr.get(j);
        }

        return answer;
    }
}