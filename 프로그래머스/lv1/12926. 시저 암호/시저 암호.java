import java.util.ArrayList;

class Solution {
    public String solution(String s, int n) {
        String answer = "";

        String[] arr = s.split("");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i].toUpperCase();
        }

        int[] arr2 = new int[s.length()];
        for(int i = 0; i<arr.length; i++){
            arr2[i] = (int)arr[i].charAt(0);
        }

        for (int i = 0; i < arr2.length; i++) {
            if(arr2[i] != 32){
                if(arr2[i] + n < 91){
                    arr2[i] = arr2[i] + n;
                }else{
                    arr2[i] = arr2[i] + n -26;
                }
            }else{
                continue;
            }
        }

        for(int i = 0; i < arr2.length; i++){
            if((int)s.charAt(i) >= 97){
              answer +=  (char)(arr2[i] + 32);
            }else{
                answer += (char)arr2[i];
            }
        }
        System.out.println(answer);
        return answer;
    }
}