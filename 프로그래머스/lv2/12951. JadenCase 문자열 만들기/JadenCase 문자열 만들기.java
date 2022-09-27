
class Solution {
    public String solution(String s) {
        String answer = "";

        String[] str = s.split("");

        int cnt = 0;
        for (int i = 0; i < str.length; i++) {
            if(str[i].contains(" ")){
                cnt = 0;
                continue;
            }else{
                if(cnt == 0){
                    str[i] = str[i].toUpperCase();
                    cnt++;
                }else{
                    str[i] = str[i].toLowerCase();
                }

                continue;
            }

        }
        for(int i = 0; i<str.length; i++){
            answer += str[i];
        }


        return answer;
    }
}