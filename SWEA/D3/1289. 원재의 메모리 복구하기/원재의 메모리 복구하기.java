import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        for (int i = 1; i <= T; i++) {
            String s = sc.nextLine();


            char current = '0';
            int cnt = 0;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) != current) {
                    current = s.charAt(j);
                    cnt++;
                }
            }
            System.out.println("#" + i+ " " + cnt);
        }
    }
}