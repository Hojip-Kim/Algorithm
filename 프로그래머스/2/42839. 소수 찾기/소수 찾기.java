import java.util.HashSet;
import java.util.Set;
 
public class Solution {
    private static Set<Integer> set;
    private static boolean[] visited = new boolean[7];
 
    public int solution(String numbers) {
        int answer = 0;
        set = new HashSet<>();
        
        dfs(numbers, "", 0);
 
        for (int num : set) {
            if (isPrime(num)) {
                answer++;
            }
        }
        return answer;
    }
 
    private void dfs(String numbers, String str, int depth) {
        if (depth > numbers.length()) {
            return;
        }
 
        for (int i = 0; i < numbers.length(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                set.add(Integer.parseInt(str + numbers.charAt(i)));
                dfs(numbers ,str + numbers.charAt(i), depth + 1);
                visited[i] = false;
            }
        }
    }
 
    private boolean isPrime(int prime) {
        if (prime < 2) {
            return false;
        }
        for (int i = 2; i <= (int) Math.sqrt(prime); i++) {
            if (prime % i == 0) {
                return false;
            }
        }
        return true;
    }
}