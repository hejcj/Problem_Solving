import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        long result = 0;
        for (int i = 0; i < N; i++) {
            int height = Integer.parseInt(br.readLine());

            if (stack.isEmpty()) {
                stack.push(height);
            } else {
                while (true) {

                    if (stack.peek() > height) {
                        result += stack.size();
                        stack.push(height);
                        break;
                    } else {
                        stack.pop();
                        if(stack.isEmpty()) {
                            stack.push(height);
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(result);
    }
}