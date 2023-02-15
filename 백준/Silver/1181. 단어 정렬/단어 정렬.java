import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.TreeSet;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        TreeSet<String> set = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() > o2.length()) return 1;
                else if(o1.length() < o2.length()) return -1;
                else return o1.compareTo(o2);
             }
        });

        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }

        for (String a : set) {
            sb.append(a).append("\n");
        }

        System.out.println(sb);
    }
}
