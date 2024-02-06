package lecture;
import java.util.*;
public class practice {
    public static int[][] toCharTable(String[] sequence) {
        int count1 = 0, count2 = 0, count3 = 0;
        for(int numeral = 48; numeral < 58; numeral++) {
            for(int i = 0; i < sequence.length; i++) {
                String w = sequence[i];
                char c = w.charAt(i);
                if(c==numeral) count1++;
                else if(c >= 'A' && c <= 'Z') count2++;
                else count3++;
            }
        }
        return new int[sequence.length][3];
    }
    public static void main(String[] args) {
        Scanner c = new Scanner(System.in);
        System.out.println("Enter string sequence: ");
        int length = 0;
        String[] sequence = new String[length];
        while(c.hasNext()) {
            String w = c.next();
            length++;
            for(int i = 0; i < length; i++) {
                sequence[i] = w;
            }
        }
        System.out.print(toCharTable(sequence));
    }
}
