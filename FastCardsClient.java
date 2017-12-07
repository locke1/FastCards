// FastCardsClient.java contains main() for the FastCards project.
// by locke1 Sun Dec  3 22:40:32 2017
import java.awt.*;
import javax.swing.*;
public class FastCardsClient {
    public static void main(String[] args) {
        WelcomeFrame welcomeFrame = new WelcomeFrame();
        welcomeFrame.setBackground(Color.WHITE);
        welcomeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        welcomeFrame.setSize(400, 300);
        welcomeFrame.setVisible(true);
    }
}