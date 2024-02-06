package lecture;
import java.util.*;
public class lectureswitch {
    /**
     * Compute the quantity from a radius value
     * @param option int representing what to compute
     * @param radius double representing the radius
     * @return the value represented
     */
    public static double calc( int option, double radius ) {
        radius = Math.abs(radius);
        return switch (option) {
            case 1 -> Math.PI * Math.pow(radius, 2);
            case 2 -> Math.PI * Math.pow(radius, 3) * 4 / 3;
            case 3 -> Math.PI * radius * 2;
            default -> 0;
        };
    }
    public static void main( String[] args ) {
        double r, result;
        int ch;
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter a choice for calculation 1=area 2=volume 3=circumference: ");
        ch = keyboard.nextInt();
        System.out.println("Input a value for radius: ");
        r = keyboard.nextDouble();

        result = calc( ch, r );
        System.out.println("Your result is " + result);

        switch (ch) {
            default -> throw new IllegalArgumentException("Invalid option choice.");
            case 1 -> System.out.printf("The area is %.5f.%n", result);
            case 2 -> System.out.printf("The volume is %.5f.$n", result);
            case 3 -> System.out.printf("The circumference is %.5f.%n", result);
        }
    }
}
