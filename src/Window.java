
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Map;
import javax.swing.*;
import javax.swing.border.Border;

public class Window {
    public static Font bigText = new Font("Product Sans", Font.PLAIN, 50);
    public static Font bigBoldText = new Font("Product Sans", Font.BOLD, 50);
    public static Font regularText = new Font("Product Sans", Font.PLAIN, 20);
    public static boolean firstClick = true;
    public static void createWindow() {
        JFrame frame = new JFrame("Spanish Conjugator");

        JLabel welcomeLabel = new JLabel("WELCOME!", SwingConstants.CENTER);
        welcomeLabel.setBounds(0, 150, 800, 50);
        welcomeLabel.setFont(bigText);
        frame.add(welcomeLabel);

        JLabel continueLabel = new JLabel("Click anywhere to continue", SwingConstants.CENTER);
        continueLabel.setBounds(0, 350, 800, 50);
        continueLabel.setFont(regularText);
        frame.add(continueLabel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(800, 600));
        frame.setVisible(true);

        frame.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (firstClick) {
                    mainPage(frame);
                    firstClick = false;
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    public static void mainPage(JFrame frame) {
        frame.getContentPane().removeAll();
        frame.repaint();

        JLabel instructions = new JLabel("Type the verb, and select the form", SwingConstants.CENTER);
        instructions.setFont(regularText);
        instructions.setBounds(0, 100, 800, 50);

        JTextField verb = new JTextField("Enter verb here");
        verb.setFont(regularText);
        verb.setBounds(25, 200, 750, 50);

        verb.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                verb.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });

        String[] verbFormOptions = {"Yo", "Tú", "Usted", "Nosotros", "Ustedes"};
        JComboBox<String> verbForm = new JComboBox<String>(verbFormOptions);
        verbForm.setFont(regularText);
        verbForm.setBounds(25, 300, 750, 50);

        JButton submit = new JButton("Submit");
        submit.setFont(regularText);
        submit.setBounds(350, 450, 100, 50);

        frame.add(instructions);
        frame.add(verb);
        frame.add(verbForm);
        frame.add(submit);

        submit.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String selectedVerb = verb.getText();
                String selectedVerbForm = verbFormOptions[verbForm.getSelectedIndex()].toLowerCase();
                resultPage(frame, selectedVerb, selectedVerbForm);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    public static void resultPage(JFrame frame, String verb, String verbForm) {
        frame.getContentPane().removeAll();
        frame.repaint();

        String conjugated = Education.conjugateVerb(verb, verbForm);

        JLabel res = new JLabel(conjugated, SwingConstants.CENTER);
        res.setFont(bigBoldText);
        res.setBounds(0, 200, 800, 100);

        JButton again = new JButton("Conjugate Another Verb");
        again.setFont(regularText);
        again.setBounds(200, 400, 400, 50);

        if (conjugated.equals("ERROR")) {
            res.setFont(regularText);
            res.setForeground(Color.red);
            res.setText("Verb entered incorrectly, please try again");
        }

        frame.add(res);
        frame.add(again);

        again.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mainPage(frame);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        createWindow();

    }
}