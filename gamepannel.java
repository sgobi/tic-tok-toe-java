
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
            buttons[i].setFocusable(false);
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






    @Override
    public void actionPerformed(ActionEvent ae) {

        for (int i = 0 ; i<9;i++)
        {
            if(ae.getSource()==buttons[i]){

                if(playerOneTurn){
                    
                    if(buttons[i].getText()==""){
                        buttons[i].setForeground(new Color(255,0,0));
                        buttons[i].setText("X");
                        playerOneTurn=false;
                        textLabel.setText("O Turn");
                        check();
                    }

                }
                else{

                    if(buttons[i].getText()==""){
                        buttons[i].setForeground(new Color(0,0,255));
                        buttons[i].setText("O");
                        playerOneTurn=true;
                        textLabel.setText("X Turn");
                        check();
                    }
                }


            }
           
        }



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
public void check(){
// *******************************************************************************************************************************************
//***********************************************xPlayerWins**********************************************************************************
// *******************************************************************************************************************************************
//Horizontal
System.out.println("hi");

if(
    (buttons[0].getText().equals("X"))&&
    (buttons[1].getText().equals("X"))&&
    (buttons[2].getText().equals("X"))
        ){
            xPlayerWins(0,1,2);
        }
    
        if(
    (buttons[3].getText().equals("X"))&&
    (buttons[4].getText().equals("X"))&&
    (buttons[5].getText().equals("X"))
        ){
            xPlayerWins(3,4,5);
        }
    
        if(
    (buttons[6].getText().equals("X"))&&
    (buttons[7].getText().equals("X"))&&
    (buttons[8].getText().equals("X"))
        ){
            xPlayerWins(6,7,8);
        }
    
    
    
    //Vertical
    
    
    if(
        (buttons[0].getText().equals("X"))&&
        (buttons[3].getText().equals("X"))&&
        (buttons[6].getText().equals("X"))
            ){
                xPlayerWins(0,3,6);
            }
        
            if(
        (buttons[1].getText().equals("X"))&&
        (buttons[4].getText().equals("X"))&&
        (buttons[7].getText().equals("X"))
            ){
                xPlayerWins(1,4,7);
            }
        
            if(
        (buttons[2].getText().equals("X"))&&
        (buttons[5].getText().equals("X"))&&
        (buttons[8].getText().equals("X"))
            ){
                xPlayerWins(2,5,8);
            }
    
    
    
    //Across
    if(
        (buttons[0].getText().equals("X"))&&
        (buttons[4].getText().equals("X"))&&
        (buttons[8].getText().equals("X"))
            ){
                xPlayerWins(0,4,8);
            }
        
            if(
        (buttons[2].getText().equals("X"))&&
        (buttons[4].getText().equals("X"))&&
        (buttons[6].getText().equals("X"))
            ){
                xPlayerWins(2,4,6);
            }
    
    
    
    
    // *******************************************************************************************************************************************
    //***********************************************oPlayerWins**********************************************************************************
    // *******************************************************************************************************************************************
    //Horizontal
    if(
        (buttons[0].getText().equals("O"))&&
        (buttons[1].getText().equals("O"))&&
        (buttons[2].getText().equals("O"))
            ){
                oPlayerWins(0,1,2);
            }
        
            if(
        (buttons[3].getText().equals("O"))&&
        (buttons[4].getText().equals("O"))&&
        (buttons[5].getText().equals("O"))
            ){
                oPlayerWins(3,4,5);
            }
        
            if(
        (buttons[6].getText().equals("O"))&&
        (buttons[7].getText().equals("O"))&&
        (buttons[8].getText().equals("O"))
            ){
                oPlayerWins(6,7,8);
            }
        
        
        
        //Vertical
        
        
        if(
            (buttons[0].getText().equals("O"))&&
            (buttons[3].getText().equals("O"))&&
            (buttons[6].getText().equals("O"))
                ){
                    oPlayerWins(0,3,6);
                }
            
                if(
            (buttons[1].getText().equals("O"))&&
            (buttons[4].getText().equals("O"))&&
            (buttons[7].getText().equals("O"))
                ){
                    oPlayerWins(1,4,7);
                }
            
                if(
            (buttons[2].getText().equals("O"))&&
            (buttons[5].getText().equals("O"))&&
            (buttons[8].getText().equals("O"))
                ){
                    oPlayerWins(2,5,8);
                }
        
        
        
        //Across
        if(
            (buttons[0].getText().equals("O"))&&
            (buttons[4].getText().equals("O"))&&
            (buttons[8].getText().equals("O"))
                ){
                    oPlayerWins(0,4,8);
                }
            
                if(
            (buttons[2].getText().equals("O"))&&
            (buttons[4].getText().equals("O"))&&
            (buttons[6].getText().equals("O"))
                ){
                    oPlayerWins(2,4,6);
                }
        
    
    
    
    


}

public void xPlayerWins(int a, int b, int c){
System.out.println("xPlayerWins");
buttons[a].setBackground(new Color(0,255,0));
buttons[b].setBackground(new Color(0,255,0));
buttons[c].setBackground(new Color(0,255,0));

for(int i=0; i<9;i++){
    buttons[i].setEnabled(false);
}
textLabel.setText("X is Winner Of The Game");



}
public void oPlayerWins(int a, int b, int c){
    System.out.println("xPlayerWins");

    buttons[a].setBackground(new Color(255,0,0));
buttons[b].setBackground(new Color(255,0,0));
buttons[c].setBackground(new Color(255,0,0));

for(int i=0; i<9;i++){
    buttons[i].setEnabled(false);
}
textLabel.setText("O is Winner Of The Game");

}

}
