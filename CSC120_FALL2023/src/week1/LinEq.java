package week1;
import java.util.*;
public class LinEq {
    public static void main( String[] LinEq){
        //variable declaration and instantiation
        double a, b, c, d, p, q, x, y;
        Scanner keyboard;
        keyboard = new Scanner( System.in );

        //receives keyboard input for variables
        System.out.println("This program solves systems of linear equations");
        System.out.print("Please enter a, b, and p: ");
        a = keyboard.nextDouble();
        b = keyboard.nextDouble();
        p = keyboard.nextDouble();
        System.out.println("Please enter c, d, and q: ");
        c = keyboard.nextDouble();
        d = keyboard.nextDouble();
        q = keyboard.nextDouble();

        System.out.println("The equations are: ");
        System.out.printf("%f x + %f y = %f%nand%n%f x + %f y = %f%n",
                a, b, p, c, d, q);

        //outputs formatted solutions
        x = (d*p-b*q)/(a*d-b*c);
        y = (a*q-c*p)/(a*d-b*c);
        System.out.printf("The solution is: (%f, %f)", x, y);

    } //end of main method
} //end of LinEq class
