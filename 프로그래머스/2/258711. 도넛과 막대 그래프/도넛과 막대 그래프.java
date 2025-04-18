import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        Map<Integer,Integer> out = new HashMap<>();
        Map<Integer,Integer> in = new HashMap<>();
        int newNode = -1;
        int donut = 0;
        int bar = 0;
        int eight = 0;

        for(int [] e : edges){
            out.put(e[0],out.getOrDefault(e[0],0) + 1);
            in.put(e[1],in.getOrDefault(e[1],0) + 1);
        }
        for(int node : out.keySet()){
            if(out.get(node) > 1) {
                if(!in.containsKey(node)) newNode = node;
                else eight++;
            }
        }
        for(int node : in.keySet()){
            if(!out.containsKey(node)) bar++;
        }
        donut = out.get(newNode) - bar - eight;

        int[] answer = {newNode,donut,bar,eight};
        return answer;
    }
}