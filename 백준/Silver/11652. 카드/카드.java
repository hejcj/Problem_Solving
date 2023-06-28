import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Main
{
    static int N;
    static ArrayList<Long> list = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            list.add(Long.parseLong(br.readLine()));
        }

        Collections.sort(list);

        long current = list.get(0);
        int cnt = 1;
        long maxN = list.get(0);
        int maxCnt = 1;
        for (int i = 1; i < list.size(); i++) {
            long n = list.get(i);
            if(n != current) {
                if (cnt > maxCnt) {
                    maxCnt = cnt;
                    maxN = current;
                }
                cnt = 1;
                current = n;
            } else cnt++;
        }

        if (cnt > maxCnt) {
            maxN = current;
        }
        System.out.println(maxN);

    }
}