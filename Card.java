// Card.java defines the Card class which represents a flash cards.
// by locke1 Sun Dec  3 22:36:27 2017

public class Card {
    private String question;
    private String stringAnswer;
    private int intAnswer;
    private boolean ansIsString;
    private boolean ansIsInt;
    // use two bools for more robust control flow

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
    public String getQuestion() {
        return question;
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