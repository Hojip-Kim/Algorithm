import java.io.*;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            String[] arr1 = br.readLine().split(" ");
            String[] arr2 = br.readLine().split(" ");
            int[] arr_Ans = new int[arr2.length];

            int start=0;
            int end=0;

            int[] arr2_ToInteger = new int[arr2.length];
        int tmp_2 = 0;
        for (int i = 0; i < arr2.length; i++) {
            arr2_ToInteger[i] = Integer.parseInt(arr2[i]);
            tmp_2 += arr2_ToInteger[i];
        }
        if(tmp_2 < Integer.parseInt(arr1[1])){
            bw.write(String.valueOf(0));
            bw.flush();
            bw.close();
        }

        //{5 1 3 5 10 7 4 9 2 8} , 15
        int tmp=0;
        while(true){
            if(tmp>= Integer.parseInt(arr1[1])){
            arr_Ans[start] = end-start;
            tmp -= arr2_ToInteger[start];
            start++;
            }else{
                tmp += arr2_ToInteger[end];
                end++;}
            if(end == arr2.length && tmp<Integer.parseInt(arr1[1])){
                break;
            }
        }

        Arrays.sort(arr_Ans);
        for (int i = 0; i < arr_Ans.length; i++) {
            if(arr_Ans[i] != 0){
                bw.write(String.valueOf(arr_Ans[i]));
                bw.flush();
                bw.close();
                break;
            }
        }





            }
        }


