// WelcomeFrame houses the main menu for FastCards
// by locke1 Sun Dec  3 22:42:14 2017
import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomeFrame extends JFrame {

    private static JLabel welcomeLabel;
    private static JButton recallButton;
    private static JButton entryButton;

    public WelcomeFrame() {
        super("Welcome to FastCards");

        setLayout(new BorderLayout());

        // intialize lists for storing cards:
        CardLists cardLists = new CardLists();

        welcomeLabel = new JLabel("FastCards", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("SansSerif", Font.BOLD, 40));
        add(welcomeLabel, BorderLayout.NORTH);

        recallButton = new JButton("Review cards");
        add(recallButton, BorderLayout.CENTER);
        recallButton.addActionListener(
            new ActionListener() {
                @Override 
                public void actionPerformed(ActionEvent event) {
                    showRecallFrame();
                }
            }
        );

        entryButton = new JButton("Enter cards");
        add(entryButton, BorderLayout.SOUTH);
        entryButton.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    showEntryFrame();
                }
            }
        );
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
}