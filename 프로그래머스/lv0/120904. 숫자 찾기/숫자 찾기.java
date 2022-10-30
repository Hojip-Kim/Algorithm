class Solution {
    public int solution(int num, int k) {
        int answer = 0;
        String a = Integer.toString(num);
        String[] arr = a.split("");
        String b = Integer.toString(k);

        for (int i = 0; i < a.length(); i++) {
            if(arr[i].contains(b)){
                answer = i+1;
                break;
            }
        }
        if(answer != 0){
            return answer;
        }else{
            return -1;
        }
        
    }
}