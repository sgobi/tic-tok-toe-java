
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class gamepannel implements ActionListener {

JPanel titlePanel =new JPanel();
JPanel buttonPannel =new JPanel();
JFrame gameFrame =new JFrame();
JLabel textLabel =new JLabel();
JButton[] buttons = new JButton[9];


    gamepannel()
    {
gameFrame.setTitle("TicTacToa");
gameFrame.setSize(new Dimension(800,800));
gameFrame.getContentPane().setBackground(new Color(50,50,50,50));
gameFrame.setLayout(new BorderLayout());
gameFrame.setLocationRelativeTo(null);
gameFrame.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
