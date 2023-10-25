import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;

        int K = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        while(K-- > 0) {
            int n = Integer.parseInt(br.readLine());
            if(n==0) result -= stack.pop();
            else  {
                result += stack.push(n);
            }
        }
        System.out.println(result);
    }
}