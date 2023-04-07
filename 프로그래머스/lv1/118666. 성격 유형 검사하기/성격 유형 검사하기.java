import static java.lang.Math.abs;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        int[] arr_2 = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
       String vote = "RTCFJMAN";


        for (int i = 0; i < choices.length; i++) {
            if(choices[i] >4){
              arr_2[vote.indexOf(String.valueOf(survey[i].charAt(1)))] += choices[i]-4; // survey에서 각 행에서 뽑아낸것중 표가 많은걸 뽑아냄.
            }else if(choices[i]<4){
                arr_2[vote.indexOf(String.valueOf(survey[i].charAt(0)))] += abs(choices[i]-4);
            }else{
                continue;
            }
        }

        for (int i = 0; i < arr_2.length/2; i++) {
            if(arr_2[2*i] >= arr_2[2*i+1]){
               answer+=String.valueOf(vote.charAt(2*i));
            }else{
                answer+=String.valueOf(vote.charAt(2*i+1));
            }
        }
        
        return answer;
    }
}