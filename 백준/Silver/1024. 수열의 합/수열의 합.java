import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        for (int k = L; k <= 100; k++) {
            long numerator = N - (long)k * (k - 1) / 2; // N - k(k-1)/2
            if (numerator < 0) break;                   // 더 길어지면 더 작아지므로 불가능
            if (numerator % k != 0) continue;           // a가 정수가 아니면 패스

            long a = numerator / k;                     // 시작값
            if (a < 0) continue;                        // 음수면 조건 위반

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < k; i++) {
                if (i > 0) sb.append(' ');
                sb.append(a + i);
            }
            System.out.println(sb.toString());
            return;
        }

        System.out.println(-1);
    }
}
