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
            String s = "NullPointerException thrown in getNextCard()";
            // JOptionPane.showMessageDialog(null, s);
            WelcomeFrame.resetCounterLabels();
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
    public static void addToHighPriorityList(Card c) throws IllegalArgumentException {
        try {
            if (c == null)
                throw new IllegalArgumentException("Can\'t add empty card to list");
            else
                highPriorityCards.add(c);
        } catch (IllegalArgumentException e) {
            System.err.println("Can\'t add empty card to list");
        }
        
        // System.out.printf("q %10s now in HP list at index %d \n",
        //     c.getQuestion(), highPriorityCards.indexOf(c));
    }
    public static void addToMedPriorityList(Card c) throws IllegalArgumentException {
        try {
            if (c == null)
                throw new IllegalArgumentException("Can\'t add empty card to list");
            else
                medPriorityCards.add(c);
        } catch (IllegalArgumentException e) {
            System.err.println("Can\'t add empty card to list");
        }
    }
    public static void addToLowPriorityList(Card c) throws IllegalArgumentException {
        try {
            if (c == null)
                throw new IllegalArgumentException("Can\'t add empty card to list");
            else
                lowPriorityCards.add(c);
        } catch (IllegalArgumentException e) {
            System.err.println("Can\'t add empty card to list");
        }
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
    public static boolean isEmpty() {
        if (highPriorityCards.size() == 0 &&
            medPriorityCards.size() == 0 &&
            lowPriorityCards.size() == 0)    
            return true;
        else
            return false;
    }
}