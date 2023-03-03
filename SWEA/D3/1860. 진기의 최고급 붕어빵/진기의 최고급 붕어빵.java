import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		
		int T = sc.nextInt();
		
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int K = sc.nextInt();
			
			String isSale = "Possible";
			
			int[] p = new int[11112];
			
			int max = 0;
			for (int i = 0; i < N; i ++) {
				int a = sc.nextInt();
				p[a]++;
				max = max > a ? max : a;
			}
			int b = 0;
			for (int i = 0; i <= max; i ++) {
				if(i != 0 && i % M == 0) b += K;
				if(p[i] > 0) b--;
				if(b < 0) {
					isSale = "Impossible";
					break;
				}
			}
			
			sb.append("#").append(tc).append(" ").append(isSale).append("\n");
			
		}
		System.out.println(sb);
		sc.close();
	}
	
}