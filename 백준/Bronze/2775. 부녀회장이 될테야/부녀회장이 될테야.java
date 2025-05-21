import java.io.*;

public class Main {

    // k층 n호에는 몇명이 사나
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());


        for(int i = 0; i < T; i++){
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            int[][] matrix = new int[k+1][n+1];

            for(int j = 1; j <= n; j++){
                matrix[0][j] = j;
            }

            for(int j = 1; j <= k; j ++){
                for(int l = 1; l <= n; l++){
                    matrix[j][l] = matrix[j-1][l] + matrix[j][l-1];
                }
            }
            bw.append(String.valueOf(matrix[k][n]) + "\n");
        }


        bw.flush();
        bw.close();
    }
}