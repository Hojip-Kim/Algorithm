import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        String[] a =  new String[2];
        for (int i = 0; i < a.length; i++) {
            a[i] = st.nextToken();
        }

        int A = Integer.parseInt(a[0]);
        int B = Integer.parseInt(a[1]);

        String[] arr = bf.readLine().split("");



        st = new StringTokenizer(bf.readLine());

        int[] arr2 = new int[4];
        int[] arr2_Compare = new int[4];

        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

//ACGT
//0000

        for (int i = 0; i < B; i++) {
            switch (arr[i]){
                case "A":
                    arr2_Compare[0]++;
                    break;

                case "C":
                    arr2_Compare[1]++;
                    break;

                case "G":
                    arr2_Compare[2]++;
                    break;

                case "T":
                    arr2_Compare[3]++;
                    break;
            }
        }
        int i = 0;
        int j = B-1;
        int cnt = 0;

        if(arr2[0] <= arr2_Compare[0] && arr2[1] <= arr2_Compare[1] && arr2[2] <= arr2_Compare[2] && arr2[3] <= arr2_Compare[3]){
            cnt++;
        }

        while(j+1 != A){


            switch (arr[i]){
                case "A":
                    arr2_Compare[0]--;
                    break;

                case "C":
                    arr2_Compare[1]--;
                    break;

                case "G":
                    arr2_Compare[2]--;
                    break;

                case "T":
                    arr2_Compare[3]--;
                    break;
            }
            switch (arr[j+1]){
                case "A":
                    arr2_Compare[0]++;
                    break;

                case "C":
                    arr2_Compare[1]++;
                    break;

                case "G":
                    arr2_Compare[2]++;
                    break;

                case "T":
                    arr2_Compare[3]++;
                    break;
            }
            if(arr2[0] <= arr2_Compare[0] && arr2[1] <= arr2_Compare[1] && arr2[2] <= arr2_Compare[2] && arr2[3] <= arr2_Compare[3]){
                cnt++;
            }
            i++;
            j++;

        }
        System.out.println(cnt);








    }
}