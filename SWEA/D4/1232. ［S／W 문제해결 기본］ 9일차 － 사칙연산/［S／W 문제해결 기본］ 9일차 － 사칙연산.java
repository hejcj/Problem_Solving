import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        int T = 10;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(br.readLine());

            // 노드를 담을 스택
            Stack<String> stack = new Stack<>();
            
            // 노드 결과를 담을 배열 실수로 계산
            double[] cal = new double[N + 1];

            // 스택에 각 노드들 입력
            for (int j = 0; j < N; j++) {
                stack.push(br.readLine());
            }

            for (int j = 0; j < N; j++) {
                // 스택에서 빼면서
                StringTokenizer st = new StringTokenizer(stack.pop());
                // 노드 번호
                int nodeN = Integer.parseInt(st.nextToken());

                String a = st.nextToken();
                switch (a) {
                    // 노드가 연산자라면
                    case "+" :
                        cal[nodeN] = cal[Integer.parseInt(st.nextToken())] + cal[Integer.parseInt(st.nextToken())];
                        break;
                    case "-":
                        cal[nodeN] = cal[Integer.parseInt(st.nextToken())] - cal[Integer.parseInt(st.nextToken())];
                        break;
                    case "/":
                        cal[nodeN] = cal[Integer.parseInt(st.nextToken())] / cal[Integer.parseInt(st.nextToken())];
                        break;
                    case "*" :
                        cal[nodeN] = cal[Integer.parseInt(st.nextToken())] * cal[Integer.parseInt(st.nextToken())];
                        break;
                    default:
                        // 노드가 정수라면
                        cal[nodeN] = Double.parseDouble(a);
                        break;
                }
            }
            System.out.println("#" + i +" "+(int)cal[1]);
        }
    }
}