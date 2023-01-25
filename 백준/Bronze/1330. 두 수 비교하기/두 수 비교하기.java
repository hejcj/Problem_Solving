import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");

        if(Integer.parseInt(tokens[0]) > Integer.parseInt(tokens[1])) System.out.println(">");
        else if (Integer.parseInt(tokens[0]) < Integer.parseInt(tokens[1])) System.out.println("<");
        else System.out.println("==");
    }
}