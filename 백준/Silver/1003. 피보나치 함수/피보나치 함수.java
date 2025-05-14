import java.io.*;

public class Main {

    private static int[] dp = new int[10001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2; i < 41; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            if (N == 0) {
                sb.append("1 0\n");
                continue;
            }else if (N == 1) {
                sb.append("0 1\n");
                continue;
            }

            sb.append(dp[N-1] + " " + dp[N] + "\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}