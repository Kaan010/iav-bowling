import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyMain {

    private static final int totalFrameCount = 10;
    private static final Scanner myObj = new Scanner(System.in);
    private static int countOfPin = 10;
    private static int roundNumber = 0;

    public static void main(String[] args) throws InterruptedException {
        nonInteractiveGame();
    }

    private static void nonInteractiveGame() throws InterruptedException {
        Game bowlingGame = new Game();
        int knockedPin = 0, roundCount = 2;
        List<Integer> scoreList=new ArrayList<>();

        for (int i = 1; i <= totalFrameCount; i++) {
            System.out.println(i + "th frame ");
            for (int j = 1; j <= roundCount; j++) {
                System.out.print(j + "th shot -> ");

                knockedPin = rollTheBall(bowlingGame,countOfPin);
                countOfPin -= knockedPin;
                scoreList = bowlingGame.updateScoresOfGamePerFrame();
                roundNumber++;
                if (bowlingGame.isStrike(roundNumber - 1))
                    break;
            }
            countOfPin = 10;

            if (i == 10) { //if last round, player has one more chance to roll
                System.out.println("3th shot ->\nKnocked pin -> "
                        + bowlingGame.rollManuel(Integer.parseInt(myObj.nextLine()), 10));
                bowlingGame.updateScoresOfGamePerFrame();
            }
            for (int k = 0; k < i; k++)
                System.out.print(scoreList.get(k) + " ,");
            System.out.println("\n");

        }

    }

    private static int rollTheBall(Game myGame, int countOfPin) {
        int knockedPin;
        knockedPin = myGame.rollManuel(Integer.parseInt(myObj.nextLine()), countOfPin);
        System.out.println("Knocked pin -> " + knockedPin);
        return knockedPin;
    }
}
