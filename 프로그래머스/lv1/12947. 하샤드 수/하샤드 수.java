import java.util.ArrayList;

class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        int i = 0;
        int sum = 0;
        int y = 0;
        ArrayList<Integer> arr = new ArrayList<Integer>();
        y = x;
        while(x>=1){
            arr.add(x%10);
            i++;
            x/=10;
        }
        for(int j = 0; j<arr.size(); j++){
            sum += arr.get(j);
        }
        
        if(y % sum == 0){
            answer = true;
        }else{
            answer = false;
        }


        return answer;
    }
}