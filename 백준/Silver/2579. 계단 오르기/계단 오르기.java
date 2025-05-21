import java.io.*;

public class Main {


    // 계단 밟으면 그 계단에 쓰여있는 점수 get
    // 계단은 한번에 한계단/두계단씩
    // 연속된 세 개의 계딴 x
    // 마지막 도착 계단은 반드시 밟아야함
    // 이 게임에서 얻을 수 있는 총 점수 최댓값

    private static int[] dp = new int[301];
    private static int[] givenStair = new int[301];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int stairNum = Integer.parseInt(br.readLine());

        for(int i = 1; i <= stairNum; i++) {
            givenStair[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = givenStair[1];

        if(stairNum > 1) {
            dp[2] = givenStair[2]+givenStair[1];
        }
        if(stairNum > 2){
            dp[3] = Math.max(givenStair[1]+givenStair[3], givenStair[2]+givenStair[3]);
        }

        for(int i = 4; i <= stairNum; i++) {

            dp[i] = Math.max(dp[i-2] + givenStair[i], dp[i-3]+givenStair[i-1] + givenStair[i]);
        }

        bw.write(String.valueOf(dp[stairNum]) + "\n");
        bw.flush();
        bw.close();
    }
}