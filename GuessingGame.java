import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuessingGame {
    private int targetNumber;
    private int numberOfGuesses;

    public GuessingGame() {
        targetNumber = (int) (Math.random() * 100) + 1; // Generate a random number between 1 and 100
        numberOfGuesses = 0;
    }

    public void play() {
        JFrame frame = new JFrame("Guessing Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel promptLabel = new JLabel("Enter your guess:");
        JTextField inputField = new JTextField(10);
        JButton guessButton = new JButton("Guess");
        JTextArea resultArea = new JTextArea(10, 30);
        resultArea.setEditable(false);

        guessButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText();
                try {
                    int guess = Integer.parseInt(input);
                    numberOfGuesses++;
                    String result;
                    if (guess == targetNumber) {
                        result = "Congratulations! You guessed the correct number in " + numberOfGuesses + " tries.";
                        guessButton.setEnabled(false);
                    } else if (guess < targetNumber) {
                        result = "Too low! Try again.";
                    } else {
                        result = "Too high! Try again.";
                    }
                    resultArea.append(guess + ": " + result + "\n");
                    inputField.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input! Please enter a number.");
                }
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(promptLabel);
        panel.add(inputField);
        panel.add(guessButton);

        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(panel, BorderLayout.NORTH);
        frame.getContentPane().add(new JScrollPane(resultArea), BorderLayout.CENTER);

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        GuessingGame game = new GuessingGame();
        game.play();
    }
}
