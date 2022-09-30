class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        int[][] arr3 = new int[n][n];
        int[][] arr4 = new int[n][n];
        int a = n;



        for(int i = 0 ; i<arr3.length; i++){

            for(int j = 0; j<arr3[i].length; j++){
                String str = String.format("%0" + n + "d", Long.parseLong(Integer.toBinaryString(arr1[i])));
                String[] arr1_Binary  = str.split("");
                arr3[i][j] = Integer.parseInt(arr1_Binary[j]);


                String str2 = String.format("%0" + n + "d", Long.parseLong(Integer.toBinaryString(arr2[i])));
                String[] arr2_Binary = str2.split("");
                arr4[i][j] = Integer.parseInt(arr2_Binary[j]);
            }
        }

        for(int i = 0; i<arr3.length; i++){
            String tmp_String = "";
            for(int j = 0; j<arr3[i].length; j++){
                if(arr3[i][j] + arr4[i][j] >=1){
                    tmp_String += "#";
                }else{
                    tmp_String += " ";
                }
            }
            answer[i] = tmp_String;
        }


        return answer;
    }
}