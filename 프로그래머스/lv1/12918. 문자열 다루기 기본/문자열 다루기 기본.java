

class Solution {



    boolean isTrue(String str){
        boolean isTrue = true;

        for(int i = 0; i<str.length(); i++){
            if((int)(str.charAt(i)) < 58 && (int)(str.charAt(i)) > 47){
                continue;
            }
            else{
                isTrue = false;
            }
        }
        return isTrue;
    }
    public boolean solution(String s) {
        boolean answer = true;

        if((s.length() == 4 || s.length() == 6) && isTrue(s)){
            answer = true;
        }
        else{
            answer = false;
        }
        return answer;
    }
}