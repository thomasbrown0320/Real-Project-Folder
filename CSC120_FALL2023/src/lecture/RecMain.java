package lecture;
import java.util.*;
public class RecMain {
    public static void main( String[] RecMain ) {
        Scanner keyboard = new Scanner( System.in );
        System.out.print( "Enter the two corners of rectangle 1: " );
        Rectangle r1 = new Rectangle( keyboard.nextDouble(),
                keyboard.nextDouble(),
                keyboard.nextDouble(),
                keyboard.nextDouble()  );
        System.out.print( "Enter the two corners of rectangle 2: " );
        Rectangle r2 = new Rectangle( keyboard.nextDouble(),
                keyboard.nextDouble(),
                keyboard.nextDouble(),
                keyboard.nextDouble()  );
        boolean f = r1.intersect( r2 );
        System.out.println( ( f ) ? "The rectangels intersects." :
                "The rectangles are disjoint." );
        System.out.print( "Enter x and y: " );
        double x = keyboard.nextDouble();
        double y = keyboard.nextDouble();
        f = r1.isIn( x, y );
        System.out.println( ( f ) ? "The point is in No.1."
                : "The point is not in No.1." );
        if ( !f )
            System.out.printf( "Its distance is %f.%n",
                    r1.distance( x, y ) );
        f = r2.isIn( x, y );
        System.out.println( ( f ) ? "The point is in No.2."
                : "The point is not in No.2." );
        if ( !f )
            System.out.printf( "Its distance is %f.%n",
                    r2.distance( x, y ) );
    }
}
