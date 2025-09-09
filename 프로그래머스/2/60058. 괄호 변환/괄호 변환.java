class Solution {
    public String solution(String p) {
        return solve(p);
    }

    private String solve(String s) {
        if (s.isEmpty()) return s;

        // 1. u, v 분리
        int idx = splitBalancedIndex(s);
        String u = s.substring(0, idx);
        String v = s.substring(idx);

        // 2. u가 올바른 괄호 문자열이면 v를 재귀 처리하여 붙임
        if (isCorrect(u)) {
            return u + solve(v);
        }

        // 3. u가 올바르지 않으면 규칙대로 새 문자열 생성
        StringBuilder sb = new StringBuilder();
        sb.append('(')
          .append(solve(v))
          .append(')');

        // u의 첫/마지막 문자 제거 후 나머지 뒤집기
        for (int i = 1; i < u.length() - 1; i++) {
            char c = u.charAt(i);
            sb.append(c == '(' ? ')' : '(');
        }
        return sb.toString();
    }

    // s를 앞에서부터 스캔하며 균형이 처음 0이 되는 위치 반환
    private int splitBalancedIndex(String s) {
        int bal = 0;
        for (int i = 0; i < s.length(); i++) {
            bal += (s.charAt(i) == '(') ? 1 : -1;
            if (bal == 0) return i + 1; // [0, i]가 균형
        }
        return s.length(); // 이론상 도달 X
    }

    // 올바른 괄호 문자열 판별
    private boolean isCorrect(String s) {
        int bal = 0;
        for (int i = 0; i < s.length(); i++) {
            bal += (s.charAt(i) == '(') ? 1 : -1;
            if (bal < 0) return false; // 닫는 괄호가 더 많아지는 순간 불일치
        }
        return bal == 0;
    }
}
