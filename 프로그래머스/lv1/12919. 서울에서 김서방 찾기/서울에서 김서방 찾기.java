public class Solution {

    public String solution(String[] seoul) {
        String answer = "";

        String[] arr = new String[1000];

        arr = seoul;

        for (int i = 0; i < arr.length; i++) {
            if(arr[i].length() <=20 && arr[i].length() > 0){
                if(arr[i].equals("Kim")){
                    answer = "김서방은 " + i +"에 있다";
                }
            }
        }

        return answer;
    }
}
