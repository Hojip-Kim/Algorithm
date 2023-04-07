class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[]{0, 0};

        int all = brown + yellow;


        for (int i = 1; i <= all; i++) { //50 22
          answer[0] = i;
          answer[1] = all/i;
          if(answer[0] >= answer[1] && all == answer[0]*answer[1]){
              if((answer[0]-2) * (answer[1]-2) == yellow){
                  break;
              }

          }
        }

        return answer;
    }
}