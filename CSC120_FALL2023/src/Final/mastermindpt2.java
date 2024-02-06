package Final;
import java.util.*;
public class mastermindpt2 {

    /**
     * Counts the instances of a particular digit in the codeword/guess
     * @param num String representing the guess/codeword
     * @param i integer that is being counted
     * @return count
     */
    public static int CountDigit(String num, int i) {
        int count = 0;
        for (int m = 0; m < 4; m++) {
            if (num.charAt(m) == i) count++;
        }
        return count;
    } // end of count digit method

    public static int[] feedback(String codeword, String guess) {
        int hits = 0;
        for (int k = 0; k < codeword.length(); k++) {
            if (codeword.charAt(k) == guess.charAt(k)) hits++;
        } //formula for # of hits
        int total = 0;
        for (int i = 49; i <= 54; i++) {
            total += Math.min(CountDigit(guess, i), CountDigit(codeword, i));
        }
        int misses = total - hits;
        //formula for # of misses
        return new int[]{hits, misses};
    } //end of feedback method

    /**
     * Updates candidate list by instantiating new array with all elements that generate the same feedback as guess
     * @param candidates String array that contains all candidates from previous round
     * @param codeword String codeword
     * @param guess String guess
     * @return updated array with every element that shares the same feedback copied
     */
    public static String[] newCandidateList(String[] candidates, String codeword, String guess) {
        String[] temp = new String[candidates.length];
        int p = 0;
        for (String candidate : candidates) {
            if (Arrays.equals(feedback(codeword, guess), feedback(guess, candidate))) {
                temp[p] = candidate;
                p++;
            }
        }
        return Arrays.copyOf(temp, p);
    }
    public static String[] getList(int[] intCandidates) {
        Arrays.sort(intCandidates);
        String a = Arrays.toString(intCandidates);
        // converts candidate array to a string array
        return a.substring(1, a.length()-1).split(", ");
    }
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int[] intCandidates = new int[1296];
        boolean moreGames, userFeedback, inGame;
        for(int i = 0; i < 1296; i++) {
            intCandidates[i] = (i / 216 % 6 + 1) * 1000 +
                    (i / 36 % 6 + 1) * 100 +
                    (i / 6 % 6 + 1) * 10 +
                    i % 6 + 1;
        } // loops over each candidate codeword in base 6 to generate each digit

        moreGames = true;
        while (moreGames) {
            System.out.println("\n---- Let's play the game of Mastermind. ----");
            System.out.println("Enter your codeword: ");
            String codeword = keyboard.nextLine();
            for (int i = 0; i < 4; i++) {
                if (codeword.charAt(i) < 49 || codeword.charAt(i) > 54)
                    throw new IllegalArgumentException("Invalid codeword");
            }
            if (codeword.length() > 4) throw new ArrayIndexOutOfBoundsException("Invalid codeword");
            // checks if entered codeword is valid for the game
            System.out.println("\nEnter feedback yourself (y/n)? ");
            String input = keyboard.nextLine();
            userFeedback = input.equals("y");
            // responsible for determining whether the hits/misses methods are called

            int round = 1;
            inGame = true;
            String[] candidates = getList(intCandidates);
            String guess = candidates[(int) (1296 * Math.random())];
            int size = 1296;
            while (inGame) {

                round++;
                System.out.printf("\nRound = %d, size = %d, Guess = %4s", round, size, guess);
                int[] feedback = feedback(codeword, guess); //receive feedback from method
                candidates = newCandidateList(candidates, codeword, guess);//creates new candidate list from feedback
                size = candidates.length;
                guess = candidates[(int) (size * Math.random())]; //next guess is pulled from new candidate list

                if (userFeedback) {
                    System.out.println("\nEnter feedback: ");
                    String user = keyboard.nextLine();
                    if (size == 1 && !user.equals("40")) {
                        System.out.println("Could not find codeword.");
                        break;
                    }
                    if (user.equals("40")) {
                        System.out.println("\nAnother game (y/n)?");
                        String answer = keyboard.nextLine();
                        moreGames = (answer.equals("y"));
                        round = 1;
                        candidates = getList(intCandidates);
                        guess = candidates[(int) (size * Math.random())]; //next guess is pulled from new candidate list
                    } // if user feedback indicates 4 hits, user is prompted to play another game and list is reset
                } else {
                    System.out.printf("\nhits=%d, misses=%d", feedback[0], feedback[1]);
                    if (feedback[0] == 4) {
                        System.out.println("\nAnother game (y/n)?");
                        String answer = keyboard.nextLine();
                        inGame = false;
                        moreGames = (answer.equals("y"));
                        round = 1;
                        candidates = getList(intCandidates);
                        guess = candidates[(int) (size * Math.random())]; //next guess is pulled from new candidate list
                    }
                } // end of elif block which handles user feedback
            } // end of while loop in-game
        } // end of while loop for another game
    } // end of main method
} // end of mastermindpt2 class