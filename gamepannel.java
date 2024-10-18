
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
    boolean playerOneTurn =false;
    gamepannel() {
        gameFrame.setTitle("TicTacToa");
        gameFrame.setSize(new Dimension(800, 800));
        gameFrame.getContentPane().setBackground(new Color(50, 50, 50, 50));
        gameFrame.setLayout(new BorderLayout());
        gameFrame.setLocationRelativeTo(null);
        gameFrame.setVisible(true);

        textLabel.setBackground(new Color(25, 25, 25));
        textLabel.setForeground(new Color(25, 225,0 ));
        textLabel.setFont(new Font("Ink Free", Font.BOLD, 75));
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        textLabel.setText("Tic Tac Toa");
        textLabel.setOpaque(true);

        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBounds(0, 0, 800, 100);
      
        buttonPannel.setLayout(new GridLayout(3,3));
        buttonPannel.setBackground(new Color(150, 150, 150));
     
        for (int i= 0; i<9;i++){
            buttons[i] = new JButton();
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
            buttonPannel.add(buttons[i]);
            buttonPannel.setFocusable(false);
            buttons[i].addActionListener(this);
        }

        titlePanel.add(textLabel);
        gameFrame.add(titlePanel,BorderLayout.NORTH);
        gameFrame.add(buttonPannel);

        gameStart();
    }


    public void gameStart(){
        firstTurn();
    }
public void firstTurn(){
        try {
            //  int palyer =random.nextInt(2); //here 0 or 1 that mean O or X
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
        }
    if (random.nextInt(2)==0) {
        playerOneTurn=true;
        textLabel.setText("X Turn");
    }
    else{
        playerOneTurn=false;
        textLabel.setText("O Turn");
    }
}
public void check(){}

public void xPlayerWins(){}
public void oPlayerWins(){}



    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
