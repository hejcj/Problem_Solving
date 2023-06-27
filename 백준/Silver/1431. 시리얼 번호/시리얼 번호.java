import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws  Exception{
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 정렬 수행할 우선순위 큐
        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                
                // 1번조건 길이로 비교
                if(o1.length() > o2.length()) {
                    return 1;
                } else if (o1.length() < o2.length()) {
                    return -1;
                } else {

                    // 2번조건 String내의 숫자의 합으로 비교
                    int sumA = 0;
                    int sumB = 0;
                    for (int i = 0; i < o1.length(); i++) {
                        if(o1.charAt(i)-'0' >0 && o1.charAt(i)-'0' <10) {
                            sumA += o1.charAt(i) - '0';
                        }
                        if(o2.charAt(i)-'0' >0 && o2.charAt(i)-'0' <10) {
                            sumB += o2.charAt(i) - '0';
                        }
                    }
                    if(sumA > sumB) return 1;
                    else if (sumA < sumB) return -1;
                    
                    else {
                        // 3번조건 Stirng내으 사전순 정렬
                        for (int i = 0; i < o1.length(); i++) {
                            if(o1.charAt(i) > o2.charAt(i)) return 1;
                            else if(o1.charAt(i) < o2.charAt(i)) return -1;
                        }
                        return 0;
                    }
                }
            }
        });

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            pq.offer(br.readLine());
        }
        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()) {
            sb.append(pq.poll()).append("\n");

        }
        System.out.println(sb);
    }
}