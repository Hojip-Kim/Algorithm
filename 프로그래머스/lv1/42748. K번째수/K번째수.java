import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};

        answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            if(commands[i][0] != commands[i][1]){
            int[] arr = new int[commands[i][1]-commands[i][0]+1];
                for(int j = commands[i][0]; j<=commands[i][1]; j++){
                    arr[j-commands[i][0]] = array[j-1];
                }
                Arrays.sort(arr);
                answer[i] = arr[commands[i][2]-1];
            }
            else{
                int[] arr = new int[1];
                arr[0] = array[commands[i][0]-1];
                answer[i] = arr[0];
            }

        }
        
        return answer;
        }

    }
