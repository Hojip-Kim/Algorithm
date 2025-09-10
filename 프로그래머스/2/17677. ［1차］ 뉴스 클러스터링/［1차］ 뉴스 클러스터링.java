import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        Map<String, Integer> a = buildMultiSet(str1.toLowerCase());
        Map<String, Integer> b = buildMultiSet(str2.toLowerCase());

        if (a.isEmpty() && b.isEmpty()) return 65536; // 둘 다 공집합이면 1 * 65536

        int inter = 0, union = 0;
        Set<String> keys = new HashSet<>();
        keys.addAll(a.keySet());
        keys.addAll(b.keySet());

        for (String k : keys) {
            int c1 = a.getOrDefault(k, 0);
            int c2 = b.getOrDefault(k, 0);
            inter += Math.min(c1, c2);
            union += Math.max(c1, c2);
        }

        return (int) ((double) inter / union * 65536); 
    }

    private Map<String, Integer> buildMultiSet(String s) {
        Map<String, Integer> m = new HashMap<>();
        for (int i = 0; i < s.length() - 1; i++) {
            char c1 = s.charAt(i);
            char c2 = s.charAt(i + 1);
            if (Character.isLetter(c1) && Character.isLetter(c2)) {
                String token = "" + c1 + c2;
                m.put(token, m.getOrDefault(token, 0) + 1);
            }
        }
        return m;
        }
}
