import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] s1 = s.split(" ");
        int n = Integer.parseInt(s1[0]);
        int k = Integer.parseInt(s1[1]);

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(i + 1);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        int index = 0;
        while (!list.isEmpty()) {
            index = (index + (k - 1)) % list.size();
            sb.append(list.remove(index));
            if (list.size() == 0) {
                sb.append(">");
            } else {
                sb.append(", ");
            }
        }
        System.out.println(sb);
    }
}