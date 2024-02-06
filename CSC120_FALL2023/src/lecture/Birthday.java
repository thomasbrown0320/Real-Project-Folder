package lecture;
import java.util.*;
public class Birthday {
    public static int[] oneTrial(int nPeople) {
        int[] theCounts = new int[365];
        for (int i = 1; i <= nPeople; i++) {
            int index = (int) (364 * Math.random());
            theCounts[index]++;
        }
        return theCounts;
    } // end of oneTTrial method
    public static boolean hasAHit(int[] theCounts) {
        boolean hasAHit=false;
        for (int theCount : theCounts) {
            if (theCount >= 2) {
                hasAHit = true;
                break;
            }
        }
        return hasAHit;
    } // end of hasAHit method

    public static double experiment1(int nPeople, int nReps) {
        double hitRate = 0;
        for(int i=0;i<=nReps;i++) {
            if(hasAHit(oneTrial(nPeople))) hitRate++;
        }
        hitRate /= nReps;
        return hitRate;
    } // end of experiment1 method

    public static int[] summarize(int[] theCounts) {
        int largest=0;
        int i;
        for(i=0;i<theCounts.length;i++) {
            if(theCounts[i]>largest) {
                largest = theCounts[i];
            }
        }
        int[] values = new int[largest+1];

        for(i=0;i<theCounts.length;i++) {

            for(int k=0;k<=largest;k++) {
                if(theCounts[i]==k) {
                    values[k]++;
                }
            }
        }
        for(i=0;i<=largest;i++) {
            System.out.printf("%d Hits: %d \n", i, values[i]);
        }
        return values;
    } // end of summarize method

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Experiment #1");
        System.out.println("Enter the no. of people: ");
        int nPeople = keyboard.nextInt();
        System.out.println("Enter no. of repetitions: ");
        int nReps = keyboard.nextInt();
        System.out.printf("Probability Of Hits: %.3f", experiment1(nPeople, nReps));
        System.out.println("\nExperiment 2");
        System.out.println("\nEnter the no. of people again: ");
        int n = keyboard.nextInt();
        System.out.print(Arrays.toString(summarize(oneTrial(n))));
    }

}