package lecture;
import java.util.Scanner;

public class TaylorAll1 {
    public static void expandExp(double x, int n) {

        double s, g;

        System.out.printf("---Approximation of exp(%.6f)---%n", x);

        g = x;
        s = 1 + Math.exp(0)*g;

        for (int k = 2; k<=n; k++) {
            g *= x /k;
            s += g;
            System.out.printf("%d:%2.15f%n", k, s);
        } //end of for loop
        System.out.printf("Math.exp(%.6f): " + Math.exp(x), x);
    } // end of expandExp method

    public static void expandSin(double x, int n ) {

        int k;
        double s, g;

        System.out.printf("---Approximation of sin(%.6f)---%n", x);

        g = x;
        s = Math.cos(0)*g;
        for (k = 2; k<=n; k++) {

            g *= x/k;
            if ( k%4 == 1) {
                s += g;
            }

            if (k%4 == 3) {
                s += g*-1;
            }

            System.out.printf("%d:%.15f%n", k, s);
        } // end of for loop
        System.out.printf("Math.sin(%f): " + Math.sin(x), x );

    } // end of expandSin method

    public static void expandLog( double x, int n ) {

        int k;
        double derivative, g, s;
        System.out.printf("%n---Approximation of log(1+%.6f)---", x);

        g = x;
        s = g;
        derivative = 1.0;

        for (k=2; k<=n; k++) {

            derivative *= -(k-1);
            g *= x/k;
            s += g*derivative;
            System.out.printf("%d:%.15f%n", k, s);
        }


        System.out.printf("Math.log(1+%f):" + Math.log(1+x), x );
    } // end of expandLog method

    public static void main(String[] args) {
        Scanner c = new Scanner(System.in);
        double x;
        int n;

        for (int m = 1; m<=3; m++) {
            switch(m) {
                case 1:
                    System.out.println("For exp(x), ");
                    break;
                case 2:
                    System.out.println("For sin(x), ");
                    break;
                case 3:
                    System.out.println("For log(1+x), ");
                    break;
            } // end of switch
        }

        System.out.println("enter x (|x| >= 0) and n:");
        x = c.nextDouble();
        n = c.nextInt();
        if (Math.abs(x)>=1) {
            System.out.println("|x| >= 1.0");
        }
        else {
            expandExp(x,n);
            expandSin(x,n);
            expandLog(x,n);
        }


    }
}
