import java.util.Scanner;

public class Solution {

	// 이용권 금액 배열
	static int[] price;
	// 최솟값
	static int min;
	// 수영장 이용 배열
	static int[] month;
	// 이용금액 구하는 백트래킹 메소드
	
	static void howMuch(int m, int sum) {
		
        // 이미 최솟값 보다 더 비싸게 돈을 줘야하면 가지치기
		if(sum >= min) return;
		
        // 12월 까지 다 계산이 끝났을 때
		if(m >= 12) {
			min = sum;
			return;
		}
		
		// 1일권과 1개월권 이용 금액 비교하기
		if(month[m] * price[0] > price[1]) {
			howMuch(m+1,sum+price[1]);
		} else {
			howMuch(m+1, month[m]*price[0] +sum);
		}
		
		howMuch(m+3,sum + price[2]);
	}
	
	public static void main(String[] args) {
		
		// 입력
		Scanner sc = new Scanner(System.in);
		// 출력
		StringBuilder sb = new StringBuilder();
		
		// 테스트 케이스 숫자
		int T = sc.nextInt();
		// 테스트 케이스 순회
		for (int tc = 1; tc <=T; tc++) {
			
			// 초기화
			price = new int[4];
			month = new int[12];
			
			for (int i = 0; i < 4; i++) {
				price[i] = sc.nextInt();
			}
			// 최솟값 1년 이용권으로 초기화
			min = price[3];
            
			for (int i = 0 ; i< 12; i++) {
				month[i] = sc.nextInt();
			}
			
			// 이용권 선택 백트래킹
			howMuch(0, 0);
			
			sb.append("#").append(tc).append(" ").append(min).append("\n");
			
		}
		System.out.println(sb);
		sc.close();
	}
}