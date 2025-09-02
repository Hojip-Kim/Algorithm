import java.util.*;

public class Solution {
    public int solution(int n, int k) {
        String baseK = Integer.toString(n, k);
        String[] parts = baseK.split("0");
        int count = 0;

        for (String part : parts) {
            if (part.isEmpty()){
                continue;
            }

            long num = Long.parseLong(part);
            if (isPrime(num)) {
                count++;
            }
        }

        return count;
    }

    private boolean isPrime(long n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;

        long sqrt = (long) Math.sqrt(n);
        for (long i = 3; i <= sqrt; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
