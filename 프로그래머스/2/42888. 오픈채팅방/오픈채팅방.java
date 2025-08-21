import java.util.*;

class Solution {
    
    private Map<String, String> userMap = new HashMap<>();
    
    public String[] solution(String[] record) {
        String[] answer;
        
        int len = 0;
        // 닉네임 변경방법
        // 1. 채팅방 나간 후 새로운 닉네임으로 다시들어감
        // 2. 채팅방에서 닉네임 변경
        // 닉네임 변경시 기존 채팅방 출력되어있던 메시지 닉네임 전부 변경
        for(String str : record) {
            String[] splitedStr = str.split(" ");
            if(!"Change".equals(splitedStr[0])){
                len++;
            }
        }
        
        answer = new String[len];
        
        int index = 0;
        
        for(String str : record) {
            
            String[] splitedStr = str.split(" ");
            String operation = splitedStr[0];
            String userId = splitedStr[1];
            if(!"Leave".equals(operation)) {
                String nickName = splitedStr[2];
                // 닉네임작업 완료
                corp(operation, userId, nickName);
            }
        }
        
        for(String str : record) {
            String[] splitedStr = str.split(" ");
            String operation = splitedStr[0];
            String userId = splitedStr[1];
            // change가 아닌 operation이라면 조합
            if(!"Change".equals(operation)) {
                String message = toMessage(operation, userId);
                answer[index] = message;
                index++;
            }
        }
        
        return answer;
    }
    
    // "Enter", "Leave", "Change"
    private void corp(String str, String uid, String nickName) {
        if("Enter".equals(str)) {
            userMap.put(uid, nickName);
        }else {
            if(userMap.containsKey(uid)) {
                userMap.put(uid, nickName);
                return;
            }
        }
    }
    
    private String toMessage(String str, String uid) {
        // 들어왔다면
        if("Enter".equals(str)) {
            return userMap.get(uid) + "님이 들어왔습니다.";
            // 나갔다면
        }else if("Leave".equals(str)) {
            return userMap.get(uid) + "님이 나갔습니다.";
        }
        // 여기까지 닿지않음.
        return "";
    }
}