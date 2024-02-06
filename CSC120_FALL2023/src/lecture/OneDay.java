package lecture;

public class OneDay implements OneDayInt {
    private int month;
    private int day;
    private int year;
    private double amount;
    public OneDay(int theYear, int theMonth, int theDay, double theAmount) {
        this.month = theMonth;
        this.year = theYear;
        this.day = theDay;
        theAmount = getAmount();
    }

    @Override
    public double getAmount() {
        return 0;
    }
}
