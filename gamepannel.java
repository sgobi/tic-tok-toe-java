
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class gamepannel implements ActionListener {

    JPanel titlePanel = new JPanel();
    JPanel buttonPannel = new JPanel();
    JFrame gameFrame = new JFrame();
    JLabel textLabel = new JLabel();
    JButton[] buttons = new JButton[9];
    Random random = new Random();
    boolean playerOneTurn = false;

    gamepannel() {
        gameFrame.setTitle("TicTacToa");
        gameFrame.setSize(new Dimension(800, 800));
        gameFrame.getContentPane().setBackground(new Color(50, 50, 50, 50));
        gameFrame.setLayout(new BorderLayout());
        gameFrame.setLocationRelativeTo(null);
        gameFrame.setVisible(true);

        textLabel.setBackground(new Color(25, 25, 25));
        textLabel.setForeground(new Color(25, 225, 0));
        textLabel.setFont(new Font("Ink Free", Font.BOLD, 75));
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        textLabel.setText("Tic Tac Toa");
        textLabel.setOpaque(true);

        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBounds(0, 0, 800, 100);

        buttonPannel.setLayout(new GridLayout(3, 3));
        buttonPannel.setBackground(new Color(150, 150, 150));
        buttonPannel.setFocusable(false);

        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
            buttonPannel.add(buttons[i]);
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        titlePanel.add(textLabel);
        gameFrame.add(titlePanel, BorderLayout.NORTH);
        gameFrame.add(buttonPannel);

        gameStart();
    }

    public void gameStart() {
        firstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        for (int i = 0; i < 9; i++) {
            if (ae.getSource() == buttons[i]) {

                if (playerOneTurn) {

                    if (buttons[i].getText().equals("")) {
                        buttons[i].setForeground(new Color(255, 0, 0));
                        buttons[i].setText("X");
                        playerOneTurn = false;
                        textLabel.setText("O Turn");
                        check();
                    }

                } else {

                    if (buttons[i].getText().equals("")) {
                        buttons[i].setForeground(new Color(0, 0, 255));
                        buttons[i].setText("O");
                        playerOneTurn = true;
                        textLabel.setText("X Turn");
                        check();
                    }
                }

            }

        }

    }

    public void firstTurn() {
        try {
            //  int palyer =random.nextInt(2); //here 0 or 1 that mean O or X
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
        }
        if (random.nextInt(2) == 0) {
            playerOneTurn = true;
            textLabel.setText("X Turn");

        } else {
            playerOneTurn = false;
            textLabel.setText("O Turn");

        }
    }

    private boolean checkCombination(int a, int b, int c, String player) {
        return buttons[a].getText().equals(player) && buttons[b].getText().equals(player) && buttons[c].getText().equals(player);
    }

    public void check() {
        String[][] winningCombos = {
            {"0", "1", "2"}, {"3", "4", "5"}, {"6", "7", "8"}, // Horizontal
            {"0", "3", "6"}, {"1", "4", "7"}, {"2", "5", "8"}, // Vertical
            {"0", "4", "8"}, {"2", "4", "6"} // Diagonal
        };
        for (String[] combo : winningCombos) {
            int a = Integer.parseInt(combo[0]);
            int b = Integer.parseInt(combo[1]);
            int c = Integer.parseInt(combo[2]);

            if (checkCombination(a, b, c, "X")) {
                xPlayerWins(a, b, c);
                return;
            } else if (checkCombination(a, b, c, "O")) {
                oPlayerWins(a, b, c);
                return;
            }

        }
        // Check for draw
        boolean draw = true;
        for (int i = 0; i < 9; i++) {
            if (buttons[i].getText().equals("")) {
                draw = false; // If any button is still empty, it's not a draw yet
                break;
            }
        }

        if (draw) {
            textLabel.setText("It's a Draw!");  // Display the draw message
            for (int i = 0; i < 9; i++) {
                buttons[i].setEnabled(false);  // Disable all buttons after a draw
            }
        }
    }

    public void xPlayerWins(int a, int b, int c) {
        buttons[a].setBackground(new Color(0, 255, 0));
        buttons[b].setBackground(new Color(0, 255, 0));
        buttons[c].setBackground(new Color(0, 255, 0));

        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        textLabel.setText("X is Winner Of The Game");

    }

    public void oPlayerWins(int a, int b, int c) {

        buttons[a].setBackground(new Color(255, 0, 0));
        buttons[b].setBackground(new Color(255, 0, 0));
        buttons[c].setBackground(new Color(255, 0, 0));

        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        textLabel.setText("O is Winner Of The Game");

    }

}
