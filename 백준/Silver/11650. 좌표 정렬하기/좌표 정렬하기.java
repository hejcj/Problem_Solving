import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());
        String[] list = new String[N];

        for (int i = 0; i < N; i++) {
            list[i] = br.readLine();
        }

        Arrays.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] s1 = o1.split(" ");
                String[] s2 = o2.split(" ");
                int num1 = Integer.parseInt(s1[0]);
                int num2 = Integer.parseInt(s2[0]);

                int num11 = Integer.parseInt(s1[1]);
                int num22 = Integer.parseInt(s2[1]);

                if(num1 > num2) return 1;
                else if (num1 < num2) return -1;
                else {
                    if(num11 > num22) return 1;
                    else return -1;
                }
            }
        });
        for (String a : list) {
            sb.append(a).append("\n");
        }
        System.out.println(sb);
    }
}