package week1;
import java.util.Scanner;
public class congruence {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter numerator and denominator: ");
        int numerator= keyboard.nextInt();
        int denominator=keyboard.nextInt();
        getRemainder remainder = new getRemainder(numerator,denominator);
        System.out.printf("%d is congruent to %dmod%d", numerator, remainder.getRemainder(), denominator);
        System.out.println("\nEnter range of classes: ");
        int range = keyboard.nextInt();
        remainder.eqClasses(remainder.getRemainder(), range);
    }
}
