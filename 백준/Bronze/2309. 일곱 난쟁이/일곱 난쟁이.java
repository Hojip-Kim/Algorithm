import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        LinkedList<Integer> arr = new LinkedList<>();
        int answer = 0;

        for (int i = 0; i < 9; i++) {
            arr.add(a.nextInt());
            answer += arr.get(i);
        }
        int tmp1 = 0, tmp2 = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = i+1; j < 9; j++) {
                int num1 = answer - arr.get(i) - arr.get(j);
                if(num1 == 100){
                    tmp1 = i;
                    tmp2 = j;
                    break;
                }
            }
        }
        arr.remove(tmp2);
        arr.remove(tmp1);
        
        Collections.sort(arr);
        for (int i = 0; i < 7; i++) {
            System.out.println(arr.get(i));
        }


    }
}
