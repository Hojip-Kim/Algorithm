import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int M = Integer.parseInt(stringTokenizer.nextToken());

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        ArrayList<Integer> arr= new ArrayList<>();

        for (int i = 0; i < N; i++) {
            arr.add(Integer.parseInt(stringTokenizer.nextToken()));
        }

        int startidx = 0;
        int answer = 0;
        while(startidx!=N){
            if((float)M/2 != arr.get(startidx) && M != arr.get(startidx) && arr.contains(M-arr.get(startidx))){
                answer++;
                arr.remove(arr.indexOf(M-arr.get(startidx)));
                arr.remove(startidx);
                N -= 2;
            }else{
                startidx++;
            }
        }

        System.out.println(answer);


    }
}