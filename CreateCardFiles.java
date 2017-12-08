// CreateCardFiles outputs remainign high cards to cards.txt,
// which can then be inputted back into FastCards by ReadCardFile.
// by locke1 Thu Dec  7 13:00:47 2017
import java.io.*;
import java.lang.SecurityException;
import java.util.*;

public class CreateCardFiles {
    private static StringBuilder stringBuilder;
    private static Formatter output;

    public static void openCardsFile() {
        try {
            output = new Formatter("cards.txt"); // wipes any previous contents of cards.txt
        } catch (SecurityException securityException) {
            System.err.println("No write permission for cards.txt");
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Cannot find file cards.txt");
        } finally {
            // System.out.println("successfully opened cards.txt");
        }
    }

    public static void closeFile() {
        if (output != null)
            output.close();
    }

    public static void addCardsToFile() {
        openCardsFile(); // initialize the formatter output
        int count = 0; // count how many cards are being written
        int i = 0; // iterators...
        int j = 0;
        int k = 0;
        Card card; // used to specify card when emptying lists.
        stringBuilder = new StringBuilder();
        try {
            // System.out.printf("hi list is %d long\nmed list is %d long\nlow list is %d long\n",
            //     CardLists.getHighPriorityList().size(),
            //     CardLists.getMedPriorityList().size(),
            //     CardLists.getLowPriorityList().size());

            // append all high priority cards to stringBuilder,
            while (CardLists.getHighPriorityList().size() != 0) {
                String q = CardLists.getHighPriorityList().get(i).getQuestion();
                String a = CardLists.getHighPriorityList().get(i).getStringAnswer();
                stringBuilder.append(String.format("%s\n%s\n", q, a));
                card = new Card(q, a);
                CardLists.removeFromHighPriorityList(card);
                i++;
                count++;
            }
            // then append all med priority cards to stringBuilder...
            // try block code after this point is NOT executing. Why?
            // Medium and low cards are not being saved... lol just adjust
            // the spec such that only high cards are saved.
            System.out.println("i am right before second while loop");
            while (CardLists.getMedPriorityList().size() != 0) {
                System.out.println("i am inside second while loop");
                String q = CardLists.getMedPriorityList().get(j).getQuestion();
                String a = CardLists.getMedPriorityList().get(j).getStringAnswer();
                stringBuilder.append(String.format("%s\n%s\n", q, a));
                card = new Card(q, a);
                CardLists.removeFromMedPriorityList(card);
                j++;
                count++;
            // then all low priority cards,
            } while (CardLists.getLowPriorityList().size() != 0) {
                String q = CardLists.getLowPriorityList().get(k).getQuestion();
                String a = CardLists.getLowPriorityList().get(k).getStringAnswer();
                stringBuilder.append(String.format("%s\n%s\n", q, a));
                card = new Card(q, a);
                CardLists.removeFromLowPriorityList(card);
                k++;
                count++;
            }
        } 

        catch (FormatterClosedException formatterClosedException) {
            System.err.println("Formatter error. Terminating.");
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Invalid input. Try again.");
        } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            // System.err.println("Index out of bounds. Crashing");
            // indexOutOfBoundsException.printStackTrace();
        } finally {
            // then write all lines to output.
            output.format("%s", stringBuilder.toString());
            System.out.printf("CreateCardFiles: wrote %d cards to cards.txt\n", count);
        }
        closeFile();
    }
}