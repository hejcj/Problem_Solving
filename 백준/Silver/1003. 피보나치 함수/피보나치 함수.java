import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	// dp 
	public static void main(String[] args) throws IOException{
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] result = new int[41][2];
		int N = Integer.parseInt(br.readLine());
		
		result[0][0] = 1;
		result[0][1] = 0;
		result[1][0] = 0;
		result[1][1] = 1;
		
		
		for(int i = 2; i<=40; i++) {
			result[i][0] = result[i-1][0] +result[i-2][0];
			result[i][1] = result[i-1][1] +result[i-2][1];
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			int target = Integer.parseInt(br.readLine());
			sb.append(result[target][0]).append(" ").append(result[target][1]).append("\n");
		}
		
		System.out.println(sb);
		br.close();
	}
}