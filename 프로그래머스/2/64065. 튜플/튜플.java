import java.util.*;

class Solution {
    public int[] solution(String s) {
        String[] parts = s.substring(2, s.length() - 2)
                          .replace("},{", "-")
                          .split("-");

        Arrays.sort(parts, Comparator.comparingInt(String::length));

        Set<Integer> tuple = new LinkedHashSet<>();

        for (String part : parts) {
            String[] nums = part.split(",");
            for (String numStr : nums) {
                tuple.add(Integer.parseInt(numStr));
            }
        }

        return tuple.stream().mapToInt(Integer::intValue).toArray();
    }
}
