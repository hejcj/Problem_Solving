import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());


        Set<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }

        for (int i = 1; i <= 50; i++) {

            ArrayList<String> stringArrayList = new ArrayList<>();
            int index = 0;
            for (String s : set) {
                if (s.length() == i) {
                    stringArrayList.add(s);
                }
            }
            Object[] list = stringArrayList.toArray();

            Arrays.sort(list);
            for (Object a : list) {
                System.out.println(a);
            }
        }
    }
}