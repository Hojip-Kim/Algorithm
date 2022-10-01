import java.util.ArrayList;
class Solution {
    public int solution(int n) {
        int cnt = 0;
        ArrayList<Integer> arr = new ArrayList();
        for (int i = 0; i <= n ; i++) {
            arr.add(i);
        }
        for(int i = 1; i<=n/2; i++){
            int tmp = 0;
            for (int j = i; j <= n/2+1; j++) {
                tmp += arr.get(j);
                if(tmp == n){
                    cnt += 1;
                    break;
                }else if(tmp > n){
                    break;
                }
            }
        }

        return cnt+1;
    }
}