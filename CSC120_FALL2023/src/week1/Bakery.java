package week1;
import java.util.*;
public class Bakery {
    public static void main( String[] bakery){
        int pastry, coffee, sandwich, loaf;
        double pastries = 4.5;
        double coffees = 3.0;
        double sandwiches = 6.0;
        double loaves = 7.0;
        double subtotal, tax, total;
        Scanner keyboard;
        keyboard = new Scanner( System.in );

        System.out.printf("Welcome to Dana's Bakery! " +
                "%nPastries are $%.2f each %nCoffees are $%.2f each " +
                "%nSandwiches are $%.2f each %nLoaves of bread are $%.2f each "
                , pastries, coffees, sandwiches, loaves);

        System.out.println("\nHow many pastries? ");
        pastry = keyboard.nextInt();
        subtotal = (double)(pastry)*(pastries);
        System.out.println("Subtotal is " + subtotal);

        System.out.println("How many coffees? ");
        coffee = keyboard.nextInt();
        subtotal = (double)(pastry)*(pastries) + (double)(coffee)*(coffees);
        System.out.println("Subtotal is " + subtotal);

        System.out.println("How many sandwiches? ");
        sandwich = keyboard.nextInt();
        subtotal = (double)(pastry)*(pastries) + (double)(coffee)*(coffees)
        + (double)(sandwich)*(sandwiches);
        System.out.println("Subtotal is " + subtotal);

        System.out.println("How many loaves of bread? ");
        loaf = keyboard.nextInt();
        subtotal = (double)(pastry)*(pastries) + (double)(coffee)*(coffees)
                + (double)(sandwich)*(sandwiches) + (double)(loaf)*(loaves);
        System.out.println("Subtotal is " + subtotal);

        tax = (int)(subtotal*0.07*100)/100.0;
        System.out.println("Tax is " + tax);
        total = subtotal + tax;
        System.out.println("Total is " + total);
        System.out.print("Thank you for coming. See you soon!");

    }
}
