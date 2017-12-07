// EntryPanel is the interface through which users enter new cards.
// by locke1 Sun Dec  3 22:42:42 2017
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class EntryFrame extends JFrame {
    private static GridBagLayout layout;
    private static GridBagConstraints constraints;
    private static JButton addWithHighPriorityButton,
                            addWithMedPriorityButton,
                            addWithLowPriorityButton;
    private static JTextField questionField, answerField;
    private static Card currentCard;

    public EntryFrame() {
        super("Entering new cards");

        CreateCardFiles.openCardsFile();

        // initialize layout:
        layout = new GridBagLayout();
        setLayout(layout);
        constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 4;
        constraints.weighty = 4;

        // insert question field:
        questionField = new JTextField(30);
        questionField.setHorizontalAlignment(SwingConstants.CENTER);
        // questionField.setText(CardLists.getNextQuestion());
        questionField.setText("Enter a question here...");
        addComponent(questionField, 0, 0, 4, 1);

        // insert answer field:
        answerField = new JTextField(30);
        answerField.setHorizontalAlignment(SwingConstants.CENTER);
        answerField.setText("Enter an answer here...");
        addComponent(answerField, 1, 0, 4, 1);

        // insert priority buttons:
        addWithHighPriorityButton = new JButton("Add Card with High Priority");
        addComponent(addWithHighPriorityButton, 3, 0, 1, 1);
        addWithHighPriorityButton.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    String q = questionField.getText();
                    String a = answerField.getText();
                    Card card = new Card(q, a);
                    CardLists.addToHighPriorityList(card);
                    CreateCardFiles.addCardToFile(card);

                    questionField.setText("Added to high priority list. Enter another question here...");
                    answerField.setText("Enter another answer here...");
                    WelcomeFrame.resetCounterLabels();
                }
            }
        );
        addWithMedPriorityButton = new JButton("Add Card with Medium Priority");
        addComponent(addWithMedPriorityButton, 3, 1, 1, 1);
        addWithMedPriorityButton.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    String q = questionField.getText();
                    String a = answerField.getText();
                    Card card = new Card(q, a);
                    CardLists.addToMedPriorityList(card);
                    CreateCardFiles.addCardToFile(card);

                    questionField.setText("Added to Med priority list. Enter another question here...");
                    answerField.setText("Enter another answer here...");
                    WelcomeFrame.resetCounterLabels();
                }
            }
        );
        addWithLowPriorityButton = new JButton("Add Card with Low Priority");
        addComponent(addWithLowPriorityButton, 3, 2, 1, 1);
        addWithLowPriorityButton.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    String q = questionField.getText();
                    String a = answerField.getText();
                    Card card = new Card(q, a);
                    CardLists.addToLowPriorityList(card);
                    CreateCardFiles.addCardToFile(card);

                    questionField.setText("Added to low priority list. Enter another question here...");
                    answerField.setText("Enter another answer here...");
                    WelcomeFrame.resetCounterLabels();
                }
            }
        );

        // create new card button handler adds Card to RecallFrame.addHighPriorityCard(newCard);
    }

    public static void addToHighPriorityList() {
        String q = questionField.getText();
        String a = answerField.getText();
        Card card = new Card(q, a);
        CardLists.addToHighPriorityList(card);
    }
    public static void addToMedPriorityList() {
        String q = questionField.getText();
        String a = answerField.getText();
        Card card = new Card(q, a);
        CardLists.addToMedPriorityList(card);
    }
    public static void addToLowPriorityList() {
        String q = questionField.getText();
        String a = answerField.getText();
        Card card = new Card(q, a);
        CardLists.addToLowPriorityList(card);
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