import java.io.*;
import java.util.StringTokenizer;

public class Main {


    private static int[][] givenHouseColorWeight;

    private static int[][] dp;

    // 1번집의 색은 2번과 달라야함
    // N번집의색은 N-1번집 색과 달라야함
    // i번집의 색은 i-1, i+1번집의 색과 달라야함
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 집의 수
        int N = Integer.parseInt(br.readLine());
        givenHouseColorWeight = new int[N+1][3];
        dp = new int[N+1][3];

        for(int i = 1; i <= N; i++){
            String[] givenColorWeight = br.readLine().split(" ");
            for(int j = 0; j < 3; j++){
                givenHouseColorWeight[i][j] = Integer.parseInt(givenColorWeight[j]);
            }
        }

        dp[1][0] = givenHouseColorWeight[1][0];
        dp[1][1] = givenHouseColorWeight[1][1];
        dp[1][2] = givenHouseColorWeight[1][2];

        for(int i = 2; i < givenHouseColorWeight.length; i++){
            dp[i][0] = Math.min(dp[i-1][1]+givenHouseColorWeight[i][0], dp[i-1][2]+givenHouseColorWeight[i][0]);
            dp[i][1] = Math.min(dp[i-1][0]+givenHouseColorWeight[i][1], dp[i-1][2]+givenHouseColorWeight[i][1]);
            dp[i][2] = Math.min(dp[i-1][1]+givenHouseColorWeight[i][2], dp[i-1][0]+givenHouseColorWeight[i][2]);
        }

        int answer = Integer.MAX_VALUE;

        for(int i = 0; i < 3; i++){
            answer = Math.min(answer, dp[N][i]);
        }


        bw.append(answer + "\n");
        bw.flush();
        bw.close();
    }

}