import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class RockPaperScissors extends JFrame implements ActionListener {
    JButton rockButton, paperButton, scissorsButton;

    JLabel computerChoice;


    JLabel computerScore,playerScore;
    RPSBackend rpsBackend ;
    public RockPaperScissors(){
        super("RockingRock");


        setSize(450,575);

        setLayout(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        rpsBackend = new RPSBackend();



        addGuiComponents();












    }
    private void addGuiComponents(){
        computerScore = new JLabel("Computer : 0");


        computerScore.setBounds(0,43,450,30);
        computerScore.setFont(new Font("Dialog",Font.BOLD,26));


        computerScore.setHorizontalAlignment(SwingConstants.CENTER);

        add(computerScore);
    //computer choice**************
        computerChoice = new JLabel("?");

        computerChoice.setBounds(175,118,98,81);
        computerChoice.setFont((new Font("Dialog",Font.BOLD,26)));
        computerChoice.setHorizontalAlignment(SwingConstants.CENTER);
        computerChoice.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        add(computerChoice);

        //player score
        playerScore = new JLabel("Player : 0");

        playerScore.setBounds(0,317,450,30);
        playerScore.setFont((new Font("Dialog",Font.BOLD,18)));
        playerScore.setHorizontalAlignment(SwingConstants.CENTER);
        add(playerScore);


        //rockButton
        rockButton = new JButton("Rock");
        rockButton.setBounds(40,387,105,81);
        rockButton.setFont(new Font("Dialog",Font.BOLD,18));
        rockButton.addActionListener(this);
        add(rockButton);

        //paperbutton
        paperButton = new JButton("Paper");
        paperButton.setBounds(165,387,105,81);
        paperButton.setFont(new Font("Dialog",Font.BOLD,18));
        paperButton.addActionListener(this);
        add(paperButton);

        //scissorButton

        scissorsButton = new JButton("Scissor");
        scissorsButton.setBounds(290,387,105,81);
        scissorsButton.setFont(new Font("Dialog",Font.BOLD,18));
        scissorsButton.addActionListener(this);
        add(scissorsButton);

    }
    private void showDialogue(String message){
        JDialog showDialogue = new JDialog(this,"Result",true);
        showDialogue.setSize(227,114);
        showDialogue.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        showDialogue.setResizable(false);


        //dialoge
        JLabel resultDialgoue = new JLabel(message);
        resultDialgoue.setFont(new Font("Dialog",Font.PLAIN,18));
        resultDialgoue.setHorizontalAlignment(SwingConstants.CENTER);
        showDialogue.add(resultDialgoue,BorderLayout.CENTER);

        //tryagain button
        JButton tryAgain = new JButton("Try again..");
        tryAgain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                computerChoice.setText("?");

                showDialogue.dispose();
            }
        });
        showDialogue.add(tryAgain,BorderLayout.SOUTH);
        showDialogue.setLocationRelativeTo(this);

        showDialogue.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        String playerChoice = e.getActionCommand().toString();

        String result = rpsBackend.playingRPC(playerChoice);
        computerChoice.setText(rpsBackend.getComputerChoice());

        computerScore.setText("Computer: " + rpsBackend.getComputerScore());
        playerScore.setText("Player: " + rpsBackend.getPlayerScore());

        showDialogue(result);


    }

}
