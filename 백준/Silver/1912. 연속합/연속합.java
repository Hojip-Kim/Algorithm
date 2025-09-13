import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        int cur = arr[0];   // i에서 끝나는 최대 연속합
        int ans = arr[0];   // 전체 최대값
        for (int i = 1; i < n; i++) {
            cur = Math.max(arr[i], cur + arr[i]);
            ans = Math.max(ans, cur);
        }
        System.out.println(ans);
    }
}
