package practiceExams;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class serverSocket {
    public static void main(String[] args) {
        connectToServer();
    }
    public static double Add(double[] numbers) {
        double sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        return sum;
    }

    public static void connectToServer() {
        try(ServerSocket serverSocket = new
                ServerSocket(9992)) {
            Socket connectionSocket = serverSocket.accept();
            InputStream inputToServer = connectionSocket.getInputStream();
            OutputStream outputFromServer = connectionSocket.getOutputStream();
            Scanner scanner = new Scanner(inputToServer, StandardCharsets.UTF_8);
            PrintWriter serverPrintOut = new PrintWriter(new OutputStreamWriter(outputFromServer, StandardCharsets.UTF_8), true);
            serverPrintOut.println("Hello! This is an interactive calculator.");
            serverPrintOut.println("What operation would you like to do (SD, Mean, Add, Subtract, Multiply, Divide, Mod)?");
            String operation = scanner.next();
            switch(operation) {
                case "SD": serverPrintOut.println("Enter an array of numbers separated by commas: "); break;
                case "Subtract", "Multiply", "Add": serverPrintOut.println("Enter 2 numbers: "); break;
                default:
                    throw new IllegalStateException("Unexpected value: " + operation);
            }
            String serverInput = scanner.nextLine();
            int k = 0;
            while(scanner.hasNextDouble()) {
                k++;
            }
            double[] numbers = new double[k];
            String[] ints = serverInput.split(", ");
            for(int i=0;i<k;i++) {
                numbers[i]=Integer.parseInt(ints[i]);
            }
            double sum = Add(numbers);
            serverPrintOut.printf("\nThe sum is %f", sum);

            boolean done = false;
            while(!done && scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if(line.toLowerCase().trim().equals("q")) {
                    done = true;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
