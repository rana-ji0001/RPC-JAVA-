import java.util.Random;

public class RPSBackend {

    private static final String[] computerChoices = { "Rock" , "Paper", "Scissor"};

    public String getComputerChoice() {
        return computerChoice;
    }

    public int getComputerScore() {
        return computerScore;
    }

    public int getPlayerScore() {
        return playerScore;
    }
    private String computerChoice;
    private int playerScore , computerScore;
    private Random random;

    public RPSBackend(){
        random = new Random();

    }
    public String playingRPC(String playerChoice){
        computerChoice = computerChoices[random.nextInt(computerChoices.length)];
        String result;
        if(computerChoice.equals("Rock")){
            if(playerChoice.equals("Paper")){
                result = "Player WIN";
                playerScore++;
            }else if(playerChoice.equals("Scissor")){
                result = "Computer WIN";
                computerScore++;
            }else{
                result = "Draw";

            }
        }else if(computerChoice.equals("Paper")){
            if(playerChoice.equals("Scissor")){
                result = "Player WIN";
                playerScore++;
            }else if(playerChoice.equals("Rock")){
                result = "Computer WIN";
                computerScore++;
            }else{
                result = "Draw";
            }
        }else{
            if(playerChoice.equals("Rock")){
                result = "Player WIN";
                playerScore++;
            }else if(playerChoice.equals("Paper")){
                result = "Computer WIN";
                computerScore++;
            }else{
                result = "Draw";
            }
        }
        return result;
    }
}
