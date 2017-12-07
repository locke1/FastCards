// WelcomeFrame houses the main menu for FastCards
// by locke1 Sun Dec  3 22:42:14 2017
import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomeFrame extends JFrame {
    private static GridBagLayout layout;
    private static GridBagConstraints constraints;
    private static JLabel welcomeLabel, highCountLabel, medCountLabel, lowCountLabel;
    private static JButton recallButton;
    private static JButton entryButton;

    public WelcomeFrame() {
        super("Welcome to FastCards");

        layout = new GridBagLayout();
        setLayout(layout);
        constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 3;
        constraints.weighty = 5;

        // intialize lists for storing cards:
        CardLists cardLists = new CardLists();

        welcomeLabel = new JLabel("FastCards", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("SansSerif", Font.BOLD, 40));
        addComponent(welcomeLabel, 0, 0, 3, 1);

        recallButton = new JButton("Review cards");
        addComponent(recallButton, 1, 0, 3, 1);
        recallButton.addActionListener(
            new ActionListener() {
                @Override 
                public void actionPerformed(ActionEvent event) {
                    showRecallFrame();
                }
            }
        );

        entryButton = new JButton("Enter cards");
        addComponent(entryButton, 2, 0, 3, 1);
        entryButton.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    showEntryFrame();
                }
            }
        );

        highCountLabel = new JLabel(String.format(
            "High cards: %d", CardLists.getHighPriorityList().size()));
        addComponent(highCountLabel, 3, 0, 1, 1);
        medCountLabel = new JLabel(String.format(
            "Med cards: %d", CardLists.getMedPriorityList().size()));
        addComponent(medCountLabel, 3, 1, 1, 1);
        lowCountLabel = new JLabel(String.format(
            "Low cards: %d", CardLists.getLowPriorityList().size()));
        addComponent(lowCountLabel, 3, 2, 1, 1);

    }

    // recall frame lets user review cards:
    public static void showRecallFrame() {
        RecallFrame recallFrame = new RecallFrame();
        recallFrame.setSize(500, 500);
        recallFrame.setVisible(true);
    }
    // entry frame lets user enter new cards:
    public static void showEntryFrame() {
        EntryFrame entryFrame = new EntryFrame();
        entryFrame.setSize(500, 500);
        entryFrame.setVisible(true);
    }
    public static void resetCounterLabels() {
        highCountLabel.setText(String.format(
            "High cards: %d", CardLists.getHighPriorityList().size()));
        medCountLabel.setText(String.format(
            "Med cards: %d", CardLists.getMedPriorityList().size()));
        lowCountLabel.setText(String.format(
            "Low cards: %d", CardLists.getLowPriorityList().size()));
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