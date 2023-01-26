import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        int a = System.in.read();
        double n = 0.0;

        if( a== 70) System.out.println("0.0");
        else{
            if(a==65) n=4.0;
            else if (a == 66) n=3.0;
            else if (a == 67) n=2.0;
            else n=1.0;

            int b = System.in.read();
            if(b == 43) n += 0.3;
            else if (b==45) n-= 0.3;

            System.out.println(n);
        }
    }
}