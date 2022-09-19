class Solution {
    boolean solution(String s) {
        boolean answer = true;

        char a = 'p';
        char b=  'y';
        int count1 = 0;
        int count2 = 0;


        String c = s.toLowerCase();

        for(int i=0; i<c.length(); i++){
            if(c.charAt(i) == a){
                count1++;
            }
            else continue;
        }
        for(int i=0; i<c.length(); i++){
            if(c.charAt(i) == b){
                count2++;
            }
            else continue;
        }

        if(count2 == count1){
            answer = true;
        }
        else{
            answer = false;
        }


        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.


        return answer;
    }
}