// Card.java defines the Card class which represents a flash cards.
// by locke1 Sun Dec  3 22:36:27 2017
import javax.swing.JOptionPane;

public class Card {
    private String question;
    private String stringAnswer;
    // use two bools for more robust control flow

    public Card(String q, String a) {
        question = q;
        stringAnswer = a;
    }

    // settors, getters:
    public void setQuestion(String q) {
        question = q;
    }
    public String getQuestion() throws NullPointerException {
        try {
            if (this == null)
                throw new NullPointerException();
            else
                return this.question;
        } catch (NullPointerException e) {
            // JOptionPane.showMessageDialog(null, "NullPointerException in getQuestion");
            return null;
        }
    }

    public void setStringAnswer(String a) throws IllegalArgumentException {
        try {
            if (a.equals(""))
                throw new IllegalArgumentException();
            else
                stringAnswer = a;
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Cannot create card with empty fields");
        }
    }
    public String getStringAnswer() {
        try {
            if (this == null)
                throw new NullPointerException();
            else
                return this.stringAnswer;
        } catch (NullPointerException e) {
            // JOptionPane.showMessageDialog(null, "NullPointerException in getQuestion");
            return null;
        }
    }
    @Override
    public String toString() {
        String s = String.format("%s, %s", getQuestion(), getStringAnswer());
        return s;
    }
}