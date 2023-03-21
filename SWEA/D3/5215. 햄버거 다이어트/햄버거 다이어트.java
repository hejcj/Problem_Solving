import java.util.Scanner;

public class Solution {
	static int N;
	static int L;
	static int max;
	static int[][] burger;
	
	static void recur(int n, int sum, int score) {
		
		
		// 종료 조건 선택한 버거의 칼로리의 합이 제한 칼로리를 넘어서면 그만 고르기
		if(sum > L) return;
		
		if(n == N) {
			max = max > score ? max : score;
			return;
		}
		
		recur(n+1,sum, score);
		recur(n+1,sum +=burger[n][1], score +=burger[n][0]);
		
	}
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		StringBuilder sb =  new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			
			// 결과값
			sb.append("#").append(tc).append(" ");
			
			N = sc.nextInt();
			L = sc.nextInt();
			
			
			max = 0;
			// 버거 배열
			burger = new int[N][2];
			
			// 입력 받기
			for (int i = 0; i < N; i++) {
				burger[i][0] = sc.nextInt();
				burger[i][1] = sc.nextInt();
			}
			
			
			// 재귀로 풀기
			recur(0,0,0);
			
			
			sb.append(max).append("\n");
			
		}
		System.out.println(sb);
	}
}