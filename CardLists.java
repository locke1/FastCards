// CardLists maintains the card priority lists for FastCards;
// locke1 Wed Dec  6 10:20:03 2017

import java.awt.*;
import javax.swing.*;
import java.util.*;

public class CardLists {
    private static ArrayList<Card> highPriorityCards, medPriorityCards, lowPriorityCards;

    public CardLists() {
        highPriorityCards = new ArrayList<Card>();
        medPriorityCards = new ArrayList<Card>();
        lowPriorityCards = new ArrayList<Card>();
    }

    // go through high list, then med list, then low list:
    public static Card getNextCard() throws NullPointerException {
        try {
            if (highPriorityCards.size() != 0)
                return highPriorityCards.get(0);
            else if (medPriorityCards.size() != 0)
                return medPriorityCards.get(0);
            else if (lowPriorityCards.size() != 0)
                return lowPriorityCards.get(0);
            else {
                throw new NullPointerException();
            }
        } catch (NullPointerException e) {
            // e.printStackTrace();
            JOptionPane.showMessageDialog(null, "There are no cards");
            return null;
        }
    }

    public static ArrayList<Card> getHighPriorityList() {
        return highPriorityCards;
    }
    public static ArrayList<Card> getMedPriorityList() {
        return medPriorityCards;
    }
    public static ArrayList<Card> getLowPriorityList() {
        return lowPriorityCards;
    }
    public static void addToHighPriorityList(Card c) {
        highPriorityCards.add(c);
        // System.out.printf("q %10s now in HP list at index %d \n",
        //     c.getQuestion(), highPriorityCards.indexOf(c));
    }
    public static void addToMedPriorityList(Card c) {
        medPriorityCards.add(c);
        // System.out.printf("q %10s now in MP list at index %d \n",
        //     c.getQuestion(), medPriorityCards.indexOf(c));
    }
    public static void addToLowPriorityList(Card c) {
       lowPriorityCards.add(c);
       // System.out.printf("q %10s now in LP list at index %d \n",
       //      c.getQuestion(), lowPriorityCards.indexOf(c));
    }
    public static void removeFromHighPriorityList(Card c) {
        highPriorityCards.remove(c);
    }
    public static void removeFromMedPriorityList(Card c) {
        medPriorityCards.remove(c);
    }
    public static void removeFromLowPriorityList(Card c) {
        lowPriorityCards.remove(c);
    }
}