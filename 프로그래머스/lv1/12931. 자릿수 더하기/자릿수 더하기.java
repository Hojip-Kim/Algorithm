import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;

//TEST CODE n = 100;
        do{
            answer += n%10;
            n /= 10;
        }while(n >= 1);
// [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        return answer;
    }
}