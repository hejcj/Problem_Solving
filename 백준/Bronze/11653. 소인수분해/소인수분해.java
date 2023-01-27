import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		boolean is_boolean = true;
		
		
		while (is_boolean == true) {
			is_boolean = false;
			
			for(int i = 2; i < n; i++) {
				if(n%i == 0) {
					sb.append(i);
					n /= i;
					is_boolean = true;
					break;
				}

			}
			if(is_boolean == false) sb.append(n);
			else sb.append("\n");
		}
		if(n != 1) System.out.println(sb);
	}
}