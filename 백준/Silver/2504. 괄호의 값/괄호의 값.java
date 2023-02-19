
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 열린것 그대로 넣어주기 스택에
            if (c == '(') {
                stack.push(0);

            } else if (c == '[') {
                stack.push(1);
            } else {
                int temp = 0;
                if (c == ')') {
                    while (!stack.isEmpty() && !(stack.peek() == 0)) {
                        if (stack.peek() == 1) {
                            System.out.println(0);
                            return;
                        }
                        temp += stack.pop();
                    }
                    if (stack.isEmpty()) {
                        System.out.println(0);
                        return;
                    }
                    stack.pop();
                    if(temp == 0) stack.push(2);
                    else stack.push(2 * temp);
                } else {
                    while (!stack.isEmpty() && !(stack.peek() == 1)) {
                        if (stack.peek() == 0) {
                            System.out.println(0);
                            return;
                        }
                        temp += stack.pop();
                    }
                    if (stack.isEmpty()) {
                        System.out.println(0);
                        return;
                    }
                    stack.pop();
                    if(temp == 0) stack.push(3);
                    else stack.push(3 * temp);
                }
            }
        }
        int result = 0;

        for (int c : stack) {
            if (c == 0 || c == 1) {
                System.out.println(0);
                return;
            }
            result += c;
        }
        System.out.println(result);
    }
}
