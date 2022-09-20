import java.util.ArrayList;

class Solution {
    public long solution(int a, int b) {
        long answer = 0;

        int min1 = a-b;
        int min2 = b-a;
        ArrayList<Integer> arr = new ArrayList<Integer>();

        if(a>b){
            for(int i = 0; i<=min1; i++){
                arr.add(b);
                b++;
            }
            for(int i =0; i<arr.size(); i++){
                answer += arr.get(i);
            }



        }else if(a<b){
            for(int i = 0; i<=min2; i++){
                arr.add(a);
                a++;
        }
            for(int i =0; i<arr.size(); i++){
                answer += arr.get(i);
            }


        }else if(a==b){
        arr.add(a);
        answer = a;

        }

        return answer;
    }
}