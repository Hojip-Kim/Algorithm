class Solution {
    public int solution(int order) {
        int answer = 0;

        String orderToString = Integer.toString(order);
        int length = orderToString.length();

//        Instant startTime = Instant.now();
        for (int i = 0; i < length; i++) {
            char a = orderToString.charAt(i);
            if(a == '3' || a == '6' || a == '9'){
                answer++;
            }
        }

//        Instant endTime = Instant.now();
//
//        Duration duration = Duration.between(startTime, endTime);
//
//        System.out.println("걸린 시간 : " + duration.toMillis());
        

        return answer;
    }
}