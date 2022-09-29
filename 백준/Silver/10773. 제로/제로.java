import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        Stack stack = new Stack();
        int K = a.nextInt();

        for(int i = 0; i<K; i++){
            int A = a.nextInt();
            if(A != 0){
            stack.push(A);
            }
            else{
                stack.pop();
            }
        }
        int max = stack.size();
        int addNum = 0;
        if(!stack.isEmpty()){
        for (int i = 0; i <max ; i++) {
            addNum += (int)stack.pop();
        }
        }
        else{
            addNum = 0;
        }
        System.out.println(addNum);
    }
}
