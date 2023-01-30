import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static int[] recursion(String s, int l, int r, int[] result){
        result[1]++;

        if(l >= r) {
            result[0] = 1;
            return result;
        }
        else if(s.charAt(l) != s.charAt(r)) {
            result[0] = 0;
            return result;
        }
        else return recursion(s , l+1, r-1,result);
    }
    public static int[] isPalindrome(String s) {
        int[] result = new int[2];
        result = recursion(s,0,s.length()-1,result);
        return result;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < t; i++) {
            int[] result = isPalindrome(br.readLine());
            sb.append(result[0]).append(" ").append(result[1]).append("\n");
        }
        System.out.println(sb);
    }
}