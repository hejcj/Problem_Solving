import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        StringTokenizer st = new StringTokenizer(br.readLine());
        LinkedList<Integer> list = new LinkedList<>();
        int N = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }
        ListIterator<Integer> listIterator = list.listIterator();
        int K = Integer.parseInt(st.nextToken());
        int idx = 0;
        while (list.size() > 1) {
            idx++;
            if(idx % K  == 0) {
                if(!listIterator.hasNext())
                    listIterator = list.listIterator();
                sb.append(listIterator.next()).append(", ");
                listIterator.previous();
                listIterator.remove();
            } else {
                if(!listIterator.hasNext())
                    listIterator = list.listIterator();
                listIterator.next();
            }
        }

        sb.append(list.peekFirst()).append(">");
        System.out.println(sb);
    }
}