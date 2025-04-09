class Expansion {
    boolean isActive;
    int serverNum;

    public Expansion(boolean isActive, int serverNum){
        this.isActive = isActive;
        this.serverNum = serverNum;
    }

    public boolean getIsActive(){
        return this.isActive;
    }

    public int getServerNum(){
        return this.serverNum;
    }

}

class Solution {

    static int[] palyers = {0, 2, 3, 3, 1, 2, 0, 0, 0, 0, 4, 2, 0, 6, 0, 4, 2, 13, 3, 5, 10, 0, 1, 5};
    static int m = 3;
    static int k = 5;

    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int opendServer = 0;

        Expansion[] serverExpansionMap = new Expansion[players.length];

        for(int i = 0; i < players.length; i++){
            if(i >= k && serverExpansionMap[i-k] != null && serverExpansionMap[i-k].getIsActive()){
                opendServer -= serverExpansionMap[i-k].getServerNum();
            }

            if(players[i] >= m){
                Expansion expansion;
                if(opendServer != 0 && players[i] >= m * opendServer){
                    expansion = new Expansion(true, (players[i] / m) - opendServer);
                    serverExpansionMap[i] = expansion;
                    opendServer += expansion.getServerNum();
                }else if(opendServer == 0){
                    expansion = new Expansion(true, players[i] / m);
                    serverExpansionMap[i] = expansion;
                    opendServer += expansion.getServerNum();
                }
            }
        }

        for(Expansion expansion : serverExpansionMap){
            if(expansion != null) {
                answer += expansion.getServerNum();
            }
        }

        return answer;
    }
}
