// When FastCards opens, ReadCardFile adds any contents of cards.txt into CardLists.
// WelcomeFrame will call this class when the window first opens.
// * heavily inspired by Figure 15.6 from Deitel Java How To Program *
// by locke1 Thu Dec  7 14:42:18 2017
import java.io.*;
import java.lang.IllegalStateException;
import java.nio.file.*;
import java.util.*;

public class ReadCardFile {
    private static Scanner input;
    private static ArrayList<String> questions = new ArrayList<String>();
    private static ArrayList<String> answers = new ArrayList<String>();

    public static void openCardsFile() {
        try {
            input = new Scanner(Paths.get("cards.txt"));
        } catch (IOException ioException) {
            System.err.println("Error opening cards.txt. Terminating...");
        }
    }
    public static void readCardsRecords() {
        try {
            openCardsFile();
            int i = 0;
            while (input.hasNextLine()) {
                questions.add(input.nextLine());
                answers.add(input.nextLine());
            }
            System.out.printf("ReadCardFile: loaded %d card(s) from cards.txt\n",
                questions.size());

            for (int j = 0; j < questions.size(); j++) {
                CardLists.addToHighPriorityList(new Card(questions.get(j), answers.get(j)));
            }
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("NoSuchElementException. Input file is improperly formatted.");
        } catch (IllegalStateException illegalStateException) {
            System.err.println("Error reading from file.");
        } finally {
            closeFile();
        }
    }

    public static void closeFile() {
        if (input != null)
            input.close();
    }
}