import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        int right = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            right = Math.max(right, arr[i]);
        }

        int M = Integer.parseInt(br.readLine());

        int left = 0;  // 최소값을 0으로 설정
        int result = 0;  // 결과값을 저장할 변수

        while (left <= right) {
            int mid = (left + right) / 2;
            int currentSum = sumAll(arr, mid);

            if (currentSum <= M) {
                result = mid;  // 현재의 mid 값을 결과로 저장
                left = mid + 1;  // 더 큰 값을 탐색
            } else {
                right = mid - 1;  // 더 작은 값을 탐색
            }
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static int sumAll(int[] _list, int target) {
        int sum = 0;
        for (int elem : _list) {
            sum += Math.min(elem, target);
        }
        return sum;
    }
}