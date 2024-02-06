package lecture;

import java.io.IOException;
import java.io.File;
import java.util.Scanner;

public class Historical {
    private OneDay[][][] data;
    public Historical() throws IOException {

        File f = new File(Const.FILE_NAME);
        Scanner sc = new Scanner(f);
        data = new OneDay[Const.LENGTH][12][31];

        for(int i = 0; i < Const.LENGTH; i++) {
            for(int k = 0; k < 12; k++) {
                int year = sc.nextInt();
                int month = sc.nextInt();
                for(int j = 0; j < 31; j++) {
                    double amount = sc.nextDouble();
                    data[i][k][j] = new OneDay(year, month, j+1, amount);
                }
            }

        }

        sc.close();
    }
    public void explore(int yLow, int yHigh, int mLow, int mHigh, int dLow, int dHigh) {
        int count = 0;
        double sum = 0;
        double amount;
        OneDay theMax = null;
        OneDay theMin = null;
        OneDay aData;

        for( int i = yLow; i <= yHigh; i++) {
            for( int k = mLow; k <= mHigh; k++) {

                for( int j = dLow; j <= dHigh; j++) {

                    aData = data[i-Const.FIRST_YEAR][k-1][j-1];

                    if( aData.getAmount() != Const.NODATA) {
                        count++;
                        amount = aData.getAmount();
                        sum = sum + amount;
                        if( theMax == null || amount > theMax.getAmount()) {
                            theMax = aData;
                        } else if( theMin == null || amount < theMin.getAmount()) {
                            theMin = aData;
                        }
                    } //end of if statement

                } //end of inner loop
                if ( count > 1 ) {
                    System.out.printf("\nCount ", count);
                    System.out.printf("\nAverage ", count / sum);
                    System.out.printf("\nMaximum " + theMax.toString());
                    System.out.printf("\nMinimum " + theMin.toString());
                }
            } //end of outer

        }
    }
}
