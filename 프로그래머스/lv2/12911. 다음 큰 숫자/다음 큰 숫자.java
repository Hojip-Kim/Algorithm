public class Solution {

    public int solution(int n){
        int answer = 0;
        int cnt1 = 0;
        String num = Integer.toBinaryString(n);
        num = num.replace("0", "");
        cnt1  = num.length();

        int cnt2 = 0;
        int i = n+1;
        while(cnt1 != cnt2){
            String num2 = Integer.toBinaryString(i);
            num2 = num2.replace("0", "");
            cnt2 = num2.length();
            if(cnt2 == cnt1){
                answer = i;
                break;
            }else
            i++;
        }

        return answer;

    }
}