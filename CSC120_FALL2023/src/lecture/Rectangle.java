package lecture;

public class Rectangle {
    public Range xRange, yRange;
    public Rectangle(double xLow, double yLow, double xHigh, double yHigh) {
        this.xRange = new Range(xLow, xHigh);
        this.yRange = new Range(yLow, yHigh);
    }
    public Range getXRange() {return xRange;}
    public Range getYRange() {return yRange;}
    public boolean intersect(Rectangle o) {
        if(xRange.intersect(o.getXRange()) && yRange.intersect(o.getYRange())) {
            return true;
        } else {
            return false;
        }
    }
    public boolean isIn(double x, double y) {
        boolean isIn = false;
        if(xRange.isIn(x) && yRange.isIn(y)) {
            isIn = true;
        }
        return isIn;
    }
    public double distance(double x, double y) {
        if(isIn(x, y)) {
            return 0;
        } else {
            double distance = Math.sqrt( Math.pow(xRange.distance(x), 2) + Math.pow(yRange.distance(y), 2));
            return distance;
        }
    }
}
