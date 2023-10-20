import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();

        LinkedList<Character> list = s.chars()
                .mapToObj(c -> (char) c)
                .collect(LinkedList::new, LinkedList::add, LinkedList::addAll);

        int cursor = 0;
        ListIterator<Character> iterator = list.listIterator();

        while (iterator.hasNext()) {
            iterator.next();
            cursor++;
        }
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char command = st.nextToken().charAt(0);

            if (command == 'L') {
                if(!iterator.hasPrevious()) continue;
                cursor--;
                iterator.previous();
                continue;
            }
            if (command == 'D') {
                if(iterator.hasNext()) {
                    cursor++;
                    iterator.next();
                }
                continue;
            }
            if (command == 'B') {
                if(!iterator.hasPrevious()) continue;
                iterator.previous();
                iterator.remove();
                cursor--;
                continue;
            }

            if (command == 'P') {
                iterator.add(st.nextToken().charAt(0));
                cursor++;
            }
        }

        for (char c : list) {
            sb.append(c);
        }
        System.out.println(sb);
    }
}