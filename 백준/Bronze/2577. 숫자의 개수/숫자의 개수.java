import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        int[] num = new int[10];

        int multiple = a*b*c;
        while(multiple != 0){
            num[multiple%10]++;
            multiple /= 10;
        }
        for (int i : num) {
            bw.write(Integer.toString(i));
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}