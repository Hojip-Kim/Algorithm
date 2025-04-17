import java.util.HashMap;
import java.util.Map;

class Friend {
    private int giveNum = 0;
    private int receiveNum = 0;
    private String name = "";
    private Map<Friend, Integer> giftMap = new HashMap<>();
    private Map<Friend, Integer> receiveMap = new HashMap<>();

    public Friend(String name) {
        this.name = name;
    }

    public void mapInit(Friend friend){
        this.giftMap.put(friend, 0);
        this.receiveMap.put(friend, 0);
    }

    public Map<Friend, Integer> getGiftMap() {
        return giftMap;
    }

    public Map<Friend, Integer> getReceiveMap() {
        return receiveMap;
    }

    // 어떤 친구에게 준 갯수 높이기
    public void addGiveNum(Friend receiveFriend) {
        this.giveNum++;
        this.giftMap.put(receiveFriend, this.giftMap.get(receiveFriend) + 1);
    }
    // 어떤 친구에게 받은 갯수 높이기
    public void addReceiveNum(Friend giveFriend) {
        this.receiveNum++;
        this.receiveMap.put(giveFriend, this.receiveMap.get(giveFriend) + 1);
    }

    public int getGiveNum() {
        return this.giveNum;
    }

    public int getReceiveNum() {
        return this.receiveNum;
    }
    // 어떤 친구에게 몇개 줬는지
    public int getGiftMapNum(String friendName){
        return this.giftMap.get(friendName);
    }
    // 어떤 친구에게 몇개 받았는지
    public int getReceiveMapNum(String friendName){
        return this.receiveMap.get(friendName);
    }

    public String getName() {
        return this.name;


    }

    public int getGiftGap(){
        return giveNum - receiveNum;
    }
}
    class Solution {


        public int solution(String[] friends, String[] gifts) {
            int answer = 0;

            int[] ansList = new int[friends.length];
            int idx = 0;

            Map<String, Friend> friendMap = new HashMap<>();

            // friend 맵 초기화
            for(String friend : friends){
                Friend fr = new Friend(friend);
                friendMap.put(friend, fr);
            }

            // friend 내부 맵 초기화
            for(Friend friend : friendMap.values()){
                for(Friend innerFriend : friendMap.values()){
                if(innerFriend.getName().equals(friend.getName())){
                    continue;
                }
                friend.mapInit(innerFriend);
                }
            }

            for(String gift : gifts){
                String[] splitGift = gift.split(" ");
                Friend giver    = friendMap.get(splitGift[0]);
                Friend receiver = friendMap.get(splitGift[1]);

                // <-- 수정된 부분
                giver.addGiveNum(receiver);
                receiver.addReceiveNum(giver);
            }

            for(Friend friend : friendMap.values()){
                int nextMonthReceive = 0;
                // 현재 친구 선물 지수


                for(Friend giftFriend : friend.getGiftMap().keySet()){
                    // 만약 내가 어떤 친구에게 준 선물이 받은 선물보다 많다면
                    if(friend.getGiftMap().get(giftFriend) > friend.getReceiveMap().get(giftFriend)) {
                        // 받기
                        nextMonthReceive++;

                        // 만약 내가 어떤 친구에게 준 선물이 받은 선물과 같다면
                    }else if(friend.getGiftMap().get(giftFriend) == friend.getReceiveMap().get(giftFriend)){
                        // 그 안에서 선물지수가 내가 더 크다면 (1개받기)
                        if(friend.getGiftGap() > giftFriend.getGiftGap()){
                            nextMonthReceive++;
                        }
                        // 선물지수가 같다면 아무것도 안하기
                    }
                }
                ansList[idx++] = nextMonthReceive;
            }

            for(int ans : ansList){
                answer = Math.max(ans, answer);
            }

            return answer;
        }
    }