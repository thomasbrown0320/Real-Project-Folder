package prog05;


import prog02.GUI;
import prog02.UserInterface;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class NotWordle { // NotWordle class
    UserInterface ui; // class variable

    NotWordle(UserInterface ui) { // constructor that takes a UserInterface
        this.ui = ui; // and stores it in a class variable
    }

    private class Node {
        private String word;
        private Node next;
        private Node (String word) {
            this.word = word;
            next = null;
        }
    }
    List<Node> wordEntries = new ArrayList<Node>();

    void loadWords(String file) {
        try {
            File words = new File(file);
            String word;
            Scanner sc = new Scanner(words);
            while (sc.hasNextLine()) {
                word = sc.nextLine();
                Node node = new Node(word);
                wordEntries.add(node);
            }
        } catch(FileNotFoundException e) {ui.sendMessage("Uh oh: java.io.FileNotFoundException: "
                + file + " (No such file or directory)");}
    }

    private Node find(String word) {
        for(Node n:wordEntries)
            if(n.word.equals(word))
                return n;
        return null;
    }
    void play(String startWord, String targetWord) {
        // In play, do the following forever (until the return occurs).
        // Tell the user the current word (the start) and the target word.
        while(true) {
            String nextWord;
            ui.sendMessage("Current word: " + startWord +
                    "\n Target word: " + targetWord);
            nextWord = ui.getInfo("What is your next word? ");
            if(nextWord==null) {ui.sendMessage("No more words provided. Exiting..."); break;}
            if(find(nextWord)==null) {
                ui.sendMessage(nextWord + " is not a word");
            } else if (differByOneLetter(nextWord, startWord)) {
                startWord = nextWord;
                if(nextWord.equals(targetWord)) {
                    ui.sendMessage("You win!");
                    break;
                }
            } else {ui.sendMessage("Sorry, but " + nextWord +
                    " differs by more than one letter from " + startWord);}
        }
    }
    void solve(String startWord, String targetWord) {
        startWord = "snow";
        targetWord = "rain";
        Queue<Node> nodeQueue = new LinkedQueue<>();
        Node start = find(startWord);
        nodeQueue.offer(start);
        Node nextNode = null;

        int polls = 0;
        while(!nodeQueue.isEmpty()) {
            Node theNode = nodeQueue.poll();
            polls++;
            for(Node n:wordEntries)
                if(!n.equals(start) && n.next==null && differByOneLetter(theNode.word, n.word)) {
                    nextNode = n;
                    nextNode.next = theNode;
                    nodeQueue.offer(nextNode);
                    if(nextNode.word.equals(targetWord)) {
                        ui.sendMessage("Success!");
                        for(Node node = n; node!=null; node = node.next) {
                            String s = " ";
                            s = node.word + "\n" + s;
                            ui.sendMessage(s);
                            ui.sendMessage("LinkedQueue yields " + polls + " polls");
                            return;
                        }
                    }
                }
        }

    }

    static boolean differByOneLetter(String input, String start) {
        int difference = 0;
        if(input.length()!=start.length())
            return false;
        for(int i = 0; i < start.length(); i++)
            if(input.charAt(i)!=start.charAt(i))
                difference++;
        return difference==1;
    }

    public static void main(String[] args) {
        //In its main method, create a new NotWordle with a new GUI and store the NotWordle in game.
        NotWordle game = new NotWordle(new GUI("Not Wordle"));
        while(true) {
            String file = game.ui.getInfo("Enter word file: ");
            if(file==null)
                break;
            game.loadWords(file);
            //Ask the user for a starting word and a target word.
            //game.ui
            String startWord = game.ui.getInfo("Start word: ");
            if(startWord==null)
                break;
            String targetWord = game.ui.getInfo("Target word: ");
            if(targetWord==null)
                break;
            //Ask if the human or computer should play;
            String[] commands = {"Human plays.", "Computer plays."};
            int i = game.ui.getCommand(commands);
            //if human
            //call game.play(startWord,targetWord)
            //if computer
            //call game.solve
            switch (i) {
                case -1:
                    break;
                case 0:
                    game.play(startWord, targetWord);
                    break;
                case 1:
                    game.solve(startWord, targetWord);
                    break;
            }
        }
    }
}


