import java.util.*;

class Node {
    private final int first;
    private final int second;

    public Node(int first, int second){
        this.first = first;
        this.second = second;
    }

    public int getFirst(){ return first; }
    public int getSecond(){ return second; }
}

class Solution {
    public int solution(int coin, int[] cards) {
        int n = cards.length;
        int target = n + 1;

        // 1) 손패 보유 표시, 2) 폐기된 카드 표시
        boolean[] hand  = new boolean[n+1];
        boolean[] trash = new boolean[n+1];

        // 즉시 낼 수 있는 1-코인 짝, 2-코인 대기 짝
        Deque<Node> isN        = new LinkedList<>();
        Deque<Node> doubleStk  = new ArrayDeque<>();

        // --- 초기 n/3장 손패 세팅 및 즉시 낼 수 있는 짝 탐지
        int idx = n / 3;
        for (int i = 0; i < idx; i++) {
            int c = cards[i];
            hand[c] = true;
            int opp = target - c;
            if (opp >= 1 && opp <= n && hand[opp]) {
                isN.offer(new Node(c, opp));
            }
        }

        int rounds = 0;
        // --- 매 라운드: 카드 두 장 뽑아서 process → 짝이 있으면 플레이 → 없으면 종료
        while (true) {
            rounds++;
            // 덱에 카드 두 장이 없으면 종료
            if (idx >= n - 1) break;

            coin = processCard(cards[idx++], target, coin, hand, trash, isN, doubleStk);
            coin = processCard(cards[idx++], target, coin, hand, trash, isN, doubleStk);

            // 1-코인 짝이 있으면 플레이
            if (!isN.isEmpty()) {
                isN.pollFirst();
                continue;
            }
            // 아니라면 2-코인으로 미리 준비해둔 짝이 있으면 플레이
            if (!doubleStk.isEmpty()) {
                doubleStk.pop();
                continue;
            }
            // 그 외엔 종료
            break;
        }

        return rounds;
    }

    private int processCard(int card, int target, int coin,
                            boolean[] hand, boolean[] trash,
                            Deque<Node> isN, Deque<Node> doubleStk) {
        int opp = target - card;

        // (1) 손패에 상대 카드가 있으면 코인 1개 써서 즉시 플레이 예약
        if (opp >= 1 && opp < hand.length && hand[opp] && coin > 0) {
            coin--;
            isN.offer(new Node(card, opp));

        // (2) 이미 2-코인으로 대기해둔 짝이 있고, 이번에도 손패에 상대 카드가 있으면
        //     코인 1개 환급하고 즉시 플레이 예약
        } else if (opp >= 1 && opp < hand.length && hand[opp] && !doubleStk.isEmpty()) {
            coin++;
            doubleStk.pop();
            isN.offer(new Node(card, opp));

        // (3) 동전 2개 사용해서, 버려진 카드(trash) 중 상대 카드를 구매 → 2-코인 대기 스택에 저장
        } else if (opp >= 1 && opp < trash.length && trash[opp] && coin > 1) {
            coin -= 2;
            doubleStk.push(new Node(card, opp));

        // (4) 그 외에는 그냥 버림
        } else {
            trash[card] = true;
        }

        return coin;
    }

    // 간단한 테스트용 main
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution(
            4, new int[]{3, 6, 7, 2, 1, 10, 5, 9, 8, 12, 11, 4}
        )); // 5

        System.out.println(sol.solution(
            3, new int[]{1, 2, 3, 4, 5, 8, 6, 7, 9, 10, 11, 12}
        )); // 2

        System.out.println(sol.solution(
            2, new int[]{5, 8, 1, 2, 9, 4, 12, 11, 3, 10, 6, 7}
        )); // 4

        System.out.println(sol.solution(
            10, new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18}
        )); // 1
    }
}
