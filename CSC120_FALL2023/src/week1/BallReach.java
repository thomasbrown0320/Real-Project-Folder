package week1;
import java.util.*;
public class BallReach {
    public static final double EARTH_GRAVITY = 9.807;
    public static final double MOON_GRAVITY = 1.62;
    public static void message( String m ){
        System.out.printf( "........ %s ........%n", m );
    }
    public static void myPrint( String name, double value, String unit ){
        System.out.printf( "%30s:%14.4f (%s)%n", name, value, unit );
    }
    public static void compute( double height, double horizontal_speed_u, double vertical_speed, double gravity ){

       double upward_time_t0 = vertical_speed/gravity;
       double upward_distance_h0 = 1/2.0 * gravity * Math.pow(upward_time_t0, 2);
       double downward_distance_h1 = height + upward_distance_h0;
       double downward_time_t1 = Math.sqrt((2*downward_distance_h1)/gravity);
       double total_time_t2 = upward_time_t0 + downward_time_t1;
       double horizontal_distance_r = horizontal_speed_u * total_time_t2;

        myPrint("Height of the cliff: ", height, "m");
        myPrint("Horizontal speed: ", horizontal_speed_u, "m/s");
        myPrint("Initial vertical speed: ", vertical_speed, "m/s");
        myPrint("Gravity: ", gravity, "m/s^2");
        myPrint("Upward time: ", upward_time_t0, "s");
        myPrint("Upward distance: ", upward_distance_h0, "m");
        myPrint("Downward time: ", downward_time_t1, "s");
        myPrint("Downward distance: ", downward_distance_h1, "m");
        myPrint("Total time: ", total_time_t2, "s");
        myPrint("Horizontal distance: ", horizontal_distance_r, "m");
    }

    public static void main( String[] args ){
        double angle, speed, height, vertical_speed, horizontal_speed, radian;
        Scanner keyboard;
        keyboard = new Scanner(System.in);

        message("........Distance Calculation........");
        System.out.println("Enter angle (degree): ");
        angle = keyboard.nextDouble();
        angle = Math.max(0, Math.min(angle, 90));
        System.out.println("Enter speed: ");
        speed = keyboard.nextDouble();
        speed = Math.max(0, speed);
        System.out.println("Enter height: ");
        height = keyboard.nextDouble();
        height = Math.max(0, height);

        radian = (angle / 180.0 ) * Math.PI;
        vertical_speed = Math.sin(radian) * speed;
        horizontal_speed = Math.cos(radian) * speed;

        message("........On the Earth........");
        compute(height, horizontal_speed, vertical_speed, EARTH_GRAVITY);

        message("........On the Moon........");
        compute(height, horizontal_speed, vertical_speed, MOON_GRAVITY);
    }
}