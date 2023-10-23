import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            if("push".equals(s)) {
                stack.push(Integer.parseInt(st.nextToken()));
            } else if ("pop".equals(s)) {
                if(!stack.isEmpty()) sb.append(stack.pop());
                else sb.append("-1");
            } else if ("size".equals(s)) {
                sb.append(stack.size());
            } else if ("empty".equals(s)) {
                if(stack.isEmpty()) sb.append("1");
                else sb.append("0");
            } else if ("top".equals(s)) {
                if(stack.isEmpty()) sb.append("-1");
                else sb.append(stack.peek());
            }

            if(!"push".equals(s)) sb.append("\n");
        }
        System.out.println(sb);
    }
}