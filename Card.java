// Card.java defines the Card class which represents a flash cards.
// by locke1 Sun Dec  3 22:36:27 2017
import javax.swing.JOptionPane;

public class Card {
    private String question;
    private String stringAnswer;
    private int intAnswer;
    private boolean ansIsString;
    private boolean ansIsInt;
    // use two bools for more robust control flow

    public Card(String q, String a) {
        question = q;
        stringAnswer = a;
    }

    // predicate methods:
    public boolean ansIsString() {
        return ansIsString;
    }
    public boolean ansIsInt() {
        return ansIsInt;
    }
    public void setAnsIsString(boolean b) {
        ansIsString = b;
    } 
    public void setAnsIsInt(boolean b) {
        ansIsInt = b;
    }

    // settors, getters:
    public void setQuestion(String q) {
        question = q;
    }
    public String getQuestion() throws NullPointerException {
        try {
            if (this != null)
                return this.question;
            else throw new NullPointerException();
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "can't get a question because there are no more cards");
            return null;
        }
    }
    public void setStringAnswer(String a) {
        stringAnswer = a;
        setAnsIsString(true);
    }
    public String getStringAnswer() {
        return stringAnswer;
    }
    public void setIntAnswer(int a) {
        intAnswer = a;
        setAnsIsInt(true);
    }
    public int getIntAnswer() {
        return intAnswer;
    }
}