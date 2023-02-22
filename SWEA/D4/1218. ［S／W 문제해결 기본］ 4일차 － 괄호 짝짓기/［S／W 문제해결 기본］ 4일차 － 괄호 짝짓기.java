import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {

        // 10개의 테스트 케이스
        // 스택
        // 스캐너
        // 유효하면 1 유효하지 않으면 0
        final int T = 10;
        final int IS_TRUE = 1;
        final int IS_FALSE = 0;

        Scanner sc = new Scanner(System.in);

        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(sc.nextLine());
            Stack<Character> stack = new Stack<>();
            String s = sc.nextLine();
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (c == '(' || c == '[' || c == '{' || c == '<') {
                    stack.push(c);
                } else {
                    if ((c == ')' && stack.peek() == '(') || (c == ']' && stack.peek() == '[') ||
                            (c == '}' && stack.peek() == '{') || (c == '>' && stack.peek() == '<')) {
                        stack.pop();
                    } else {
                        break;
                    }
                }
            }
            if(stack.isEmpty()) System.out.println("#" + i + " " + IS_TRUE);
            else System.out.println("#" + i + " " + IS_FALSE);
        }
    }
}