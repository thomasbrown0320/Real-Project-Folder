import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class Main
{
    public static void main(String[] args) throws Exception {
        URL url = new URL("https://api.stlouisfed.org/fred/releases?api_key=0824b9b991d972cc3103c15ce0431632&file_type=json");
        try {
            File myObj = new File("api.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), StandardCharsets.UTF_8));
            FileWriter w = new FileWriter("api.txt");
            for (String line; (line = reader.readLine()) != null;) {
                w.write("\n"+line);
            }
            w.flush(); w.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
