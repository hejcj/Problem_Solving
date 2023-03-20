import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {

			int N = sc.nextInt();
			int M = sc.nextInt();

			boolean isOn = true;

			Queue<Integer> queue = new LinkedList<>();
			
		
	
			while(M > 0) {
				if(M%2 == 0) queue.offer(0);
				else queue.offer(1);
				M /= 2; 
			}
			
			for(int i = 0; i < N; i++) {
				if(queue.isEmpty() || queue.poll() == 0) {
					isOn =false;
					break;
				}
			}


			if (!isOn)
				sb.append("#").append(tc).append(" ").append("OFF").append("\n");
			else
				sb.append("#").append(tc).append(" ").append("ON").append("\n");
		}
		System.out.println(sb);
	
		// 31 
		// 32 1 1 1 1 1 1
//		System.out.println((int)Math.pow(2, 30));
		
		// 1 3 7 15 31
		// 
	}
}