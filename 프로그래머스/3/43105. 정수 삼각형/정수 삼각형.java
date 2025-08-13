import java.util.*;

class Solution {
    private static int maxNum = -1;
    public int solution(int[][] triangle) {
        int answer = 0;
        
        for(int i = 0; i < triangle.length-1; i++){
            int markParent = 0;
            for(int j = 0; j < triangle[i].length; j++) {
                for(int k = j; k < j+2; k++){
                    // 부모 기준 왼쪽이고, 이전 부모마크가 0이면
                    if(k == j && markParent == 0){
                        // 바로 더하기
                        triangle[i+1][k] += triangle[i][j];
                    // 부모 기준 왼쪽이고, 이전 부모마크가 0이 아니면
                    }else if (k == j && markParent != 0){
                        // 마킹된 이전 부모와 현재 부모와 더한것 중 더 큰값이 더해짐
                        triangle[i+1][k] = Math.max(triangle[i][j]+triangle[i+1][k], markParent+triangle[i+1][k]);
                    // 부모 기준 오른쪽이면 right에 부모 마킹
                    }else {
                        if(triangle[i].length < k+1){
                            triangle[i+1][k] += triangle[i][j];
                        }else{
                            markParent = triangle[i][j];
                        }
                    }
                }
            }
        }
        int[] lastTriangle = triangle[triangle.length-1];
        for(int elem : lastTriangle) {
            maxNum = Math.max(maxNum, elem);
        }
        
        return maxNum;
    }
}