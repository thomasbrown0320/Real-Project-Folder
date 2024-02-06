package lecture;
public class BettingWhile {
    public interface bets {
        public double getVelocity();
        public double getAngle();
    }
    public static class Velocity implements bets {
        private double velocity;
        private double angle;
        public Velocity(double velocity, double angle) {
            this.setVelocity(velocity);
            this.setAngle(angle);
        }
        public double getVelocity() {
            return velocity* getAngle();
        }
        public double getAngle() {
            return angle;
        }

        public void setVelocity(double velocity) {
            this.velocity = velocity;
        }

        public void setAngle(double angle) {
            this.angle = angle;
        }
    }
    public static void main(String[] args) {
        Velocity fifi = new Velocity(22.34, 42);
        System.out.printf("Angle is: " + fifi.getAngle() + "\nVelocity is: " + fifi.getVelocity());

    }
}
