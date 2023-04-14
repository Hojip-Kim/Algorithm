
import java.io.*;
import java.util.ArrayList;


public class Main {
    static ArrayList list;

    public static void push(int num){
        list.add(num);
    }

    public static Integer pop(){
        if(list.isEmpty()){
            return -1;
        }
        Integer tmp = (Integer) list.get(list.size()-1);
        list.remove(list.size()-1);
        return tmp;
    }

    public static Integer size(){
        return list.size();
    }

    public static int empty(){
        if(list.isEmpty()){
            return 1;
        }
        return 0;
    }

    public static Integer top(){
        if(list.isEmpty()){
            return -1;
        }
        return (Integer)list.get(list.size()-1);
    }


    public static void main(String[] args) throws IOException {

        list = new ArrayList();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer input_Allof_Size = Integer.parseInt(br.readLine()); // 총 input명령어를 넣을 사이즈 할당

        String[] arr= new String[input_Allof_Size]; // 명령어를 저장할 배열 선언

        for (int i = 0; i < input_Allof_Size; i++) {
            String tmp = br.readLine();
            arr[i] = tmp;
        }

     for(String tmp : arr){
         if(tmp.contains("push")){
             String[] tmp1 = tmp.split(" ");
             push(Integer.parseInt(tmp1[1]));
         }else if(tmp.contains("top")){
             System.out.println(top());
         }else if(tmp.contains("pop")){
             System.out.println(pop());
         } else if (tmp.contains("size")) {
             System.out.println(size());
         } else if(tmp.contains("empty")){
             System.out.println(empty());
         }
     }



    }
}