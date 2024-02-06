package lecture;
import java.util.*;
import java.io.File;
import java.io.IOException;
public class Election {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("votes.txt"));
        int counts = 0;
        while(in.hasNextLine()) {
            counts++;
        }
        String[] names = new String[counts];
        for(int i = 0; i < counts; i++) {
            names[i] = in.nextLine();
            System.out.println(names[i] + "e");
        }
    }
}
