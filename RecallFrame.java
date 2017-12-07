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
    private static JPanel graphicsContext;
    private static JTextField questionField, answerField;
    private static JButton showAnswerButton, nextCardButton;
    private static JButton setHighPriorityButton, setMedPriorityButton, setLowPriorityButton, setNoPriorityButton;
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
        graphicsContext = new GraphicsContext();
        addComponent(graphicsContext, 0, 0, 4, 1);

        // insert answer field:
        answerField = new JTextField(30);
        answerField.setEditable(false);
        answerField.setHorizontalAlignment(SwingConstants.CENTER);
        addComponent(answerField, 1, 0, 4, 1);

        // insert show answer button:
        showAnswerButton = new JButton("Show Answer");
        addComponent(showAnswerButton, 2, 0, 4, 1);
        showAnswerButton.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    // answer button (1) shows the answer,
                    answerField.setText(currentCard.getStringAnswer());
                    // (2) removes it from this priority list,
                    // expecting since the user will add it to the end
                    // of another one:
                    CardLists.removeFromHighPriorityList(currentCard);
                    CardLists.removeFromMedPriorityList(currentCard);
                    CardLists.removeFromLowPriorityList(currentCard);
                }
            }
        );            

        // insert priority buttons:
        setHighPriorityButton = new JButton("Reset card with high priority,");
        addComponent(setHighPriorityButton, 3, 0, 1, 1);
        setHighPriorityButton.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {                
                    CardLists.addToHighPriorityList(currentCard);

                    // next card button (3) advances currentCard
                    currentCard = CardLists.getNextCard();
                    // and (4) shows the next question:
                    repaint();
                    answerField.setText("");
                    WelcomeFrame.resetCounterLabels();
                }
            }
        );
        setMedPriorityButton = new JButton("with medium priority,");
        addComponent(setMedPriorityButton, 3, 1, 1, 1);
        setMedPriorityButton.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {                
                    CardLists.addToMedPriorityList(currentCard);

                    // next card button (3) advances currentCard
                    currentCard = CardLists.getNextCard();
                    // and (4) shows the next question:
                    repaint();
                    answerField.setText("");
                    WelcomeFrame.resetCounterLabels();
                }
            }
        );
        setLowPriorityButton = new JButton("with low priority,");
        addComponent(setLowPriorityButton, 3, 2, 1, 1);
        setLowPriorityButton.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    // save current card at the end of the list...
                    CardLists.addToLowPriorityList(currentCard);
                    // next card button (3) advances currentCard
                    currentCard = CardLists.getNextCard();
                    // and (4) shows the next question:
                    repaint();
                    answerField.setText("");
                    WelcomeFrame.resetCounterLabels();
                }
            }
        );
        setNoPriorityButton = new JButton("or, \"I don\'t need to see this card again!\"");
        setLowPriorityButton.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    // next card button (3) advances currentCard
                    // without re-adding it to a list.
                    currentCard = CardLists.getNextCard();
                    // and (4) shows the next question:
                    repaint();
                    answerField.setText("");
                    WelcomeFrame.resetCounterLabels();
                }
            }
        );
        addComponent(setNoPriorityButton, 4, 0, 4, 1);
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

    private class GraphicsContext extends JPanel {
        public GraphicsContext() {
            currentCard = CardLists.getNextCard();
        }
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            setBackground(Color.WHITE);
            g.setColor(Color.BLUE);
            g.drawString(currentCard.getQuestion(), 150, 50);
        }
    }
        
}