import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String s = br.readLine();
            LinkedList<Character> list = new LinkedList<>();
            ListIterator<Character> iterator = list.listIterator();
            for (int j = 0; j < s.length(); j++) {
                if(s.charAt(j) == '<') {
                    if(iterator.hasPrevious())
                        iterator.previous();
                    continue;
                }
                if (s.charAt(j) == '>') {
                    if(iterator.hasNext())
                        iterator.next();
                    continue;
                }

                if(s.charAt(j) == '-') {
                    if(iterator.hasPrevious()) {
                        iterator.previous();
                        iterator.remove();
                    }
                    continue;
                }
                iterator.add(s.charAt(j));
            }
            for (char c : list) {
                sb.append(c);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}