import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Map<String, Integer> map = new HashMap<>();
        
        boolean answer = true;
        
        for(String book : phone_book){
            if(!map.containsKey(book)){
                map.put(book, 0);
            }else{
                int value = map.get(book);
                value++;
                map.put(book, value);
            }
        }
        
        for(int i = 0; i < phone_book.length; i++){
            for(int j = 1; j < phone_book[i].length(); j++){
                if(map.containsKey(phone_book[i].substring(0, j))){
                    return false;
                }
            }
        }
        return answer;
    }
}