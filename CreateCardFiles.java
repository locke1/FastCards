// CreateCardFiles outputs new cards to txt files,
// which can then be automagically inputted by FastCards.
// by locke1 Thu Dec  7 13:00:47 2017
import java.io.*;
import java.lang.SecurityException;
import java.util.*;

public class CreateCardFiles {
    private static Formatter output;

    public static void openCardsFile() {
        try {
            output = new Formatter("cards.txt");
        } catch (SecurityException securityException) {
            System.err.println("No write permission for cards.txt");
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Cannot find file cards.txt");
        } finally {
            System.out.println("successfully opened cards.txt");
        }
    }

    public static void closeFile() {
        if (output != null)
            output.close();
    }

    // make this just take one card?
    public static void addCardToFile(Card c) {
        openCardsFile();
        try {
            output.format("%s\n%s\n", c.getQuestion(), c.getStringAnswer());
        } catch (FormatterClosedException formatterClosedException) {
            System.err.println("Formatter error. Terminating.");
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Invalid input. Try again.");
        } finally {
            System.out.printf("successfully wrote %s to cards.txt\n", c.getQuestion());
        }
        closeFile();
    }
}