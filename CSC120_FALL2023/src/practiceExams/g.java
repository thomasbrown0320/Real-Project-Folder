package practiceExams;

import java.util.Scanner;

public class g extends x {
    
    x we = new x();

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    public static double SD(double[] numbers) {
        double sumSq = 0, sum = 0;
        for(double number : numbers) {
            sum += number;
        }
        double mean = sum/ numbers.length;
        for (double number : numbers) {
            sumSq += Math.pow(number-mean, 2);
        }

        return Math.sqrt(sumSq/numbers.length);
    }
    public static void main(String[] args) {
        Scanner c = new Scanner(System.in);
        String w = c.nextLine();
        String[] n = w.split(", ");
        double[] numbers = new double[n.length];
        double sum = 0;
        for(int i = 0; i < n.length; i++) {
            numbers[i] = Double.parseDouble(n[i]);
            sum += numbers[i];
        }
        System.out.printf("Sum: %3.5f\nArray size: %d\nSD: %3.5f\n", sum, n.length, SD(numbers));
    }
}
