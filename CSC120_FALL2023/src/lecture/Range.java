package lecture;

public class Range {
        double low, high;
        public Range(double l, double h) {

            this.low = Math.min(l, h);
            this.high = Math.max(l, h);
        }
        public double getLow() {return low;}
        public double getHigh() {return high;}
        public boolean intersect( Range o ) {
            if(o.low < high && o.high > low) {
                return true;
            } else {
                return false;
            }
        }
        public boolean isIn( double p ) {
            if(low <= p && p <= high) {
                return true;
            } else {
                return false;
            }
        }
        public double distance( double p ) {
            double distance = 0;
            if(isIn(p)) distance = 0;
            if(p > getHigh()) distance = p - getHigh();
            if(p < getLow()) distance = getLow() - p;
            return distance;
        }
}
