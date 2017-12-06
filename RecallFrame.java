// RecallPanel is the interface with which users review cards and set
// a new priority.
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RecallFrame extends JFrame {
    private static GridBagLayout layout;
    private static GridBagConstraints constraints;
    private static JTextField questionField, answerField;
    private static JButton showAnswerButton, nextCardButton;
    private static JButton setHighPriorityButton, setMedPriorityButton, setLowPriorityButton;
    private static Card currentCard;

    public RecallFrame() {
        super("Recalling Cards");

        // initialize layout:
        layout = new GridBagLayout();
        setLayout(layout);
        constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 4;
        constraints.weighty = 4;

        // insert question field:
        questionField = new JTextField(30);
        questionField.setEditable(false);
        currentCard = CardLists.getNextCard();
        questionField.setText(currentCard.getQuestion());
        addComponent(questionField, 0, 0, 4, 1);

        // insert answer field:
        answerField = new JTextField(30);
        answerField.setEditable(false);
        addComponent(answerField, 1, 0, 4, 1);

        // insert show answer button:
        showAnswerButton = new JButton("Show Answer");
        addComponent(showAnswerButton, 2, 0, 2, 1);
        showAnswerButton.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    // answer button (1) shows the answer,
                    answerField.setText(currentCard.getStringAnswer());
                    // (2) removes it from this priority list,
                    // expecting that the user will add it to a new one:
                    CardLists.removeFromHighPriorityList(currentCard);
                }
            }
        );

        // insert next card button:
        nextCardButton = new JButton("Next Card");
        addComponent(nextCardButton, 2, 2, 2, 1);
        nextCardButton.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    // next card button (3) advances currentCard
                    currentCard = CardLists.getNextCard();
                    // and (4) shows the next question:
                    questionField.setText(currentCard.getQuestion());
                    answerField.setText("");
                }
            }
        );
            

        // insert priority buttons:
        setHighPriorityButton = new JButton("Set High Priority");
        addComponent(setHighPriorityButton, 3, 0, 1, 1);
        setHighPriorityButton.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {                
                    String q = questionField.getText();
                    String a = answerField.getText();
                    Card newCard = new Card(q, a);
                    CardLists.addToHighPriorityList(newCard);

                    // next card button (3) advances currentCard
                    currentCard = CardLists.getNextCard();
                    // and (4) shows the next question:
                    questionField.setText(currentCard.getQuestion());
                    answerField.setText("");
                }
            }
        );
        setMedPriorityButton = new JButton("Set Medium Priority");
        addComponent(setMedPriorityButton, 3, 1, 1, 1);
        setLowPriorityButton = new JButton("Set Low Priority");
        addComponent(setLowPriorityButton, 3, 2, 1, 1);
    }
    
    private void addComponent(Component component,
        int row, int column, int width, int height) {
        constraints.gridx = column;
        constraints.gridy = row;
        constraints.gridwidth = width;
        constraints.gridheight = height;
        layout.setConstraints(component, constraints);
        add(component);
    }
}