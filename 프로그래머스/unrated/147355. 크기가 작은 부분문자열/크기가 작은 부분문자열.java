class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        for (int i = 0; i <= t.length() - p.length(); i++) {
            String tmp = "";
            for (int j = i; j < p.length()+i; j++) {
                tmp += t.charAt(j);
            }
            if(Long.parseLong(p) >= Long.parseLong(tmp)){
                answer++;
            }
        }
        return answer;
    }
}
