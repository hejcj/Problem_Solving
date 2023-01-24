import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		int a = sc.nextInt();
		
		for(int i=0; i<a; i++) {
			for(int j=0; j<i; j++) {
				sb.append(" ");
			}
			
			for(int j=2*a-1; j>i*2; j--) {
				sb.append("*");
			}
			sb.append("\n");
		}
		sc.close();
		System.out.println(sb);	
	}
}