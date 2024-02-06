package lecture;
import java.util.Scanner;
public class Factoring {
    public static String factor(float input) {
        StringBuilder builder = new StringBuilder();
        float m = input;
        int d = 2;
        while (m>1) {
            if(m%d==0) {

                if (m<input) {
                    builder.append("*");
                }
                builder.append(d);
                int c = 0;
                while (m%d==0) {
                    m/=d;
                    c++;
                }
                if (c>1) {
                    builder.append("^" + c);
                }

            }
            d++;
        }//end of while loop
        return builder.toString();
    }//end of factor method
    public static String factor2(float input) {
        StringBuilder builder = new StringBuilder();
        float m = input;
        int d = 2;
        while (m>1) {
            if(m%d==0) {

                if (m<input) {
                    builder.append("*");
                }
                builder.append(d);
                while (m%d==0) {
                    m/=d;
                }

            }
            d++;
        }//end of while loop
        return builder.toString();
    }
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter a number >= 2: ");
        float n = keyboard.nextFloat();
        System.out.printf("%s%n%s",factor(n),factor2(n));
    }
}//end of Factor class
