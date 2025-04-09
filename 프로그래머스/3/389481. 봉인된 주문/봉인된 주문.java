import java.util.*;

class Solution {
    // 문자열을 주문서에서의 위치(1-based)로 변환
    public static long wordToPos(String word) {
        long pos = 0;
        int len = word.length();
        // len보다 짧은 모든 문자열 개수 계산
        for (int i = 1; i < len; i++) {
            pos += Math.pow(26, i);
        }
        // 같은 길이에서 사전순 위치 계산
        for (int i = 0; i < len; i++) {
            pos += (word.charAt(i) - 'a') * Math.pow(26, len - 1 - i);
        }
        return pos + 1; // 1-based로 반환
    }

    // 위치(1-based)를 문자열로 변환
    public static String posToWord(long pos) {
        if (pos <= 0) return "a";
        pos--; // 0-based로 변환
        int len = 1;
        long total = 0;
        // 적절한 길이 찾기
        while (true) {
            long count = (long)Math.pow(26, len);
            if (total + count >= pos + 1) break;
            total += count;
            len++;
        }
        pos -= total; // 해당 길이 내에서의 상대적 위치
        StringBuilder sb = new StringBuilder();
        for (int i = len - 1; i >= 0; i--) {
            long base = (long)Math.pow(26, i);
            int digit = (int)(pos / base);
            sb.append((char)('a' + digit));
            pos %= base;
        }
        return sb.toString();
    }

    public String solution(long n, String[] bans) {
        // bans를 위치로 변환
        List<Long> banPositions = new ArrayList<>();
        for (String ban : bans) {
            banPositions.add(wordToPos(ban));
        }
        Collections.sort(banPositions);

        // n보다 작은 삭제된 주문 수를 계산하며 n 조정
        long finalPos = n;
        long offset = 0;
        for (long banPos : banPositions) {
            if (banPos <= finalPos + offset) {
                offset++;
            } else {
                break; // 정렬된 리스트이므로 더 볼 필요 없음
            }
        }
        finalPos += offset;

        return posToWord(finalPos);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(30, new String[]{"d", "e", "bb", "aa", "ae"})); // "ah"
        System.out.println(solution.solution(7388, new String[]{"gqk", "kdn", "jxj", "jxi", "fug", "jxg", "ewq", "len", "bhc"})); // "jxk"
    }
}