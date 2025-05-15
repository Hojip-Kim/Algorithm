import java.io.*;

public class Main {

    private static int[] dp = new int[1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        // n = 1 : return 1;
        // n = 2 : return 2;
        // n = 3 : 2*2
        // n = 4 : 2*2
        // n = 5 : (2*2) * 3
        // n = 6 : 2*2*2
        // n = 7 : 2*2*2*4
        // n = 8 : 2*2*2*2
        // n = 9 : 2*2*2*2*5
        // n = 10 : 2*2*2*2*2
        // n 홀수 : 2^(((n+1)/2)-1)*((n+1)/2)
        // n 짝수 : 2^((n/2)-1) - 2 에서도적용이됨
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i <= n; i++){
            dp[i] = (dp[i-1] + dp[i-2]) % 10007;
        }

        bw.write(String.valueOf(dp[n]));
        bw.flush();
        bw.close();
    }
    
}