import java.util.*;
public class Mastermind {

    public static int CountDigit(String num, int i) {
        StringBuilder builder = new StringBuilder();
        int count;
        if (num.length()!=4 && !num.equals("0"))
            throw new ArrayIndexOutOfBoundsException("Guess not of length 4");

        char c = builder.append(i).toString().charAt(0);

        count = 0;
        for (int m=0;m<num.length();m++){
            if (num.charAt(m)==c) count++;
        }
        return count;
    } // end of count digit method
    public static String generateNum() {
        StringBuilder builder = new StringBuilder();

        int[] code = new int[4];
        String codeword = "";

        code[0] = (int)(6*Math.random()+1);
        code[1] = (int)(6*Math.random()+1);
        code[2] = (int)(6*Math.random()+1);
        code[3] = (int)(6*Math.random()+1);
        for (int element = 0; element<4; element++) {
            builder.append(code[element]); codeword = builder.toString();
        }
        /* generate random numbers from 1-6 and append the elements to a string in order to
        access the elements later
        */
        return codeword;
    } //end of generateNum method

    public static void moreRounds(boolean moreRounds, String codeword) {
        Scanner keyboard = new Scanner(System.in);
        String guess;

        System.out.println("Reveal the codeword (y/n)? ");
        String s = keyboard.next();
        if (s.equals("y")) {
            System.out.println("The codeword is " + codeword);
        }
        int round = 0;
        while (moreRounds) {
            round++;

            System.out.printf("%nRound = %d, your guess (0 to stop): ", round);
            guess = keyboard.next();
            //receives guess from user as a string and increments round by 1

            if (guess.equals("0")) {
                break;
            }

            int hits = 0;
            for (int k = 0; k < guess.length(); k++) {
                if (guess.charAt(k)==codeword.charAt(k)) hits ++;
            } //formula for # of hits

            int total = 0;
            for (int i = 1 ; i <= 6; i++){
                total += Math.min(CountDigit(guess, i), CountDigit(codeword, i));
            }
            int misses = total-hits;
            //formula for # of misses

            System.out.printf("%d hits, %d misses", hits,misses);
            //prints hits and misses for each round

            if (guess.equals(codeword)) {
                System.out.println("\nYou've won!");
                System.out.println("\nAnother game (y/n)?");
                moreRounds = false;
            }
        } // end of while loop


    } //end of moreRounds method

    public static void main( String[] args ) {
        System.out.println("---- Let's play the game of Mastermind ----");
        Scanner keyboard = new Scanner(System.in);
        String codeword = generateNum();
        moreRounds(true, codeword);
        while (keyboard.hasNext()) {
            codeword = generateNum();
            String input = keyboard.nextLine();
            if (input.equals("y")) {
                moreRounds(true, codeword);
            } else break;
        }
    } //end of main method
}
