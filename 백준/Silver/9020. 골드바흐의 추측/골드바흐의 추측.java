import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		
		int[] is_Prime = new int[10001];
		
		// n[1]번까지 소수판별
		// n[2]번이 n[2-1]번 보다 크다면 그 부분만 다시 소수 판별
		
		int[] n = new int[t+1];
		
		for(int i =1; i <= t; i++) {	
			 n[i] = Integer.parseInt(br.readLine());
		}
		
		for(int z =1; z<=t;z++) {
		
			if(n[z-1] < n[z]) {
				for(int i =2; i < n[z]; i++) {
					if(is_Prime[i] == 0) is_Prime[i] = 1;
						for(int j = i+i; j < n[z]; j += i) is_Prime[j] = 2;	
					}
				}
			
			for(int i = n[z]/2 ; i< n[z]; i++) {
				if(is_Prime[i] == 1 && is_Prime[n[z]-i] == 1) {
					sb.append(n[z]-i).append(" ").append(i).append("\n");
					break;
				}
			}
		}
		System.out.println(sb);
	}
}
