import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(br.readLine().trim());
        }

        if (n == 1) {
            System.out.println(a[1]);
            return;
        }
        if (n == 2) {
            System.out.println(a[1] + a[2]);
            return;
        }

        int[] dp = new int[n + 1];
        dp[1] = a[1];
        dp[2] = a[1] + a[2];

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(
                        dp[i - 1],
                        Math.max(dp[i - 2] + a[i], dp[i - 3] + a[i - 1] + a[i])
                    );
        }
        System.out.println(dp[n]);
    }
}
