class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = {};

        String[] tmp = {};

        answer = new String[quiz.length];
        for(int i = 0; i<quiz.length; i++){
            tmp = quiz[i].split(" ");
            if(tmp[1].equals("-")){
                if(Integer.parseInt(tmp[0]) - Integer.parseInt(tmp[2]) == Integer.parseInt(tmp[4]))
                {
                    answer[i] = "O";
                }else{
                    answer[i] = "X";
                }
            }else{
                if(Integer.parseInt(tmp[0]) + Integer.parseInt(tmp[2]) == Integer.parseInt(tmp[4]))
                {
                    answer[i] = "O";
                }else{
                    answer[i] = "X";
                }
            }
        }

        for(String item : answer){
            System.out.print(item);
        }
        return answer;
    }
}