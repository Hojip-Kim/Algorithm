

class Solution {
    public int solution(int n) {
        int answer = 0;
        String tmpSave = "";

        String laun = Integer.toString(n, 3);

        String[] arr = new String[laun.length()];
        for(int i = 0; i<laun.length(); i++){
            arr[i] = String.valueOf(laun.charAt(i));
        }
       

        String tmp;
        for (int i = 0; i < laun.length()/2; i++) {
            tmp = arr[i];
            arr[i] = arr[laun.length()-i-1];
            arr[laun.length()-i-1] = tmp;
        }
        
        for(String item : arr){
            tmpSave += item;
        }



        answer = Integer.parseInt(tmpSave, 3);


        return answer;
    }
}