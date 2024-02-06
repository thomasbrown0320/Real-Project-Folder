package week1;
import java.util.*;
public class comparison {
    public static double rectlinearArea( double x, double y, double z ) {
        double area;
        area = 2 * (x*y + y*z + z*x);
        return area;
    }
    public static double cylinderArea( double radius, double length ) {
        double area;
        area = 2 * Math.PI * Math.pow( radius, 2 ) + 2 * Math.PI * radius * length;
        return area;
    }
    public static double squarepyramidArea( double side, double length ) {
        double area, s;
        s = (length + length + side) / 2 ;
        area = Math.sqrt( s * ( s - length ) * ( s - length ) * ( s - side ));
        return area;
    }
    public static double getDouble( Scanner keyboard ) {
        double number;

        if ( !keyboard.hasNextDouble() ) {
            return 10.0;
        } else {
            number = keyboard.nextDouble();
            if ( number < 0 ) {
                return 10.0;
            }
            else {
                return number;
            }
        }

    }
    public static int getInt( Scanner keyboard ) {
        int shape;
        if (keyboard.hasNextInt()) {
            shape = keyboard.nextInt();
            if (shape >= 1 && shape <= 3) return shape;
        }
        else return 1;
        return shape;
    }

    public static double getArea( Scanner keyboard, int shape ) {
        double area;
        double length = getDouble(keyboard);
        switch (shape) {
            case 1 -> {
                System.out.println("Enter Cylinder Radius and Length");
                double radius = getDouble(keyboard);
                area = cylinderArea(radius, length);
                System.out.printf("The area is %.6f", area);
            }
            case 2 -> {
                System.out.println("Enter pyramid side and Length: ");
                double side = getDouble(keyboard);
                area = squarepyramidArea(side, length);
                System.out.printf("The area is %.2f", area);
            }
            case 3 -> {
                System.out.println("Enter x y z: ");
                double x = getDouble(keyboard);
                double y = getDouble(keyboard);
                double z = getDouble(keyboard);
                area = rectlinearArea(x, y, z);
                System.out.printf("The area is %.6f", area);
            }
            default -> area = 1;
        }
            return area;
        }

    public static void main( String[] args ) {
        Scanner keyboard = new Scanner( System.in );
        System.out.println("---- comparing two 3d shapes ----");
        System.out.println("Shape 1. Which shape is it? ");
        int shape1 = getInt( keyboard );
        getArea(keyboard, shape1);

        System.out.println("\nShape 2. Which shape is it? ");
        int shape2 = getInt( keyboard );
        getArea(keyboard, shape2);

        System.out.println( Math.max(shape1, shape2) + " has a bigger area.");
    }
    }
