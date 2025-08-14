import java.util.*;

class Solution {
    public int solution(String word) {
        int[] weight = {781, 156, 31, 6, 1};
        
        Map<Character, Integer> indexMap = Map.of(
            'A', 0, 'E', 1, 'I', 2, 'O', 3, 'U', 4
        );

        int ans = 0;
        for (int i = 0; i < word.length(); i++) {
            ans += indexMap.get(word.charAt(i)) * weight[i];
        }
        ans += word.length();
        return ans;
    }
}
