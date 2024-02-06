package lecture;

public class Auto {
    private static String theMake;
    private static String theModel;
    private static int thePrice;

    public Auto(String theMake, String theMake1, int thePrice) {
        this.theMake = theMake;
        this.theModel = theModel;
        this.thePrice = thePrice;
    }

    public static String getMakeAndModel(String theMake, String theModel) {
        String makeAndModel;
        makeAndModel = theMake + " " + theModel;
        return makeAndModel;
    }
}
