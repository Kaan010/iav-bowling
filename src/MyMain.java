import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyMain {

    private static final int totalFrameCount = 10;
    private static final Scanner myObj = new Scanner(System.in);
    private static int countOfPin = 10;

    public static void main(String[] args) throws InterruptedException {
        interactiveGame();
    }

    private static void interactiveGame() throws InterruptedException {
        Game bowlingGame = new Game();
        int knockedPin = 0, roundCountPerFrame = 2, currentRoundNumber = 0;
        List<Integer> scoreList = new ArrayList<>();

        for (int i = 1; i <= totalFrameCount; i++) {
            System.out.println(i + "th frame ");
            for (int j = 1; j <= roundCountPerFrame; j++) {
                System.out.print(j + "th shot -> ");
                knockedPin = rollTheBall(bowlingGame, countOfPin);
                countOfPin -= knockedPin;
                currentRoundNumber++;
                scoreList = bowlingGame.updateScoresOfGamePerFrame();
                if (bowlingGame.isStrike(currentRoundNumber - 1)) break;
            }
            countOfPin = 10;
            makeAnExtraRollForLastRound(bowlingGame, i); //if last round, player has one more chance to roll
            printScoreUntilCurrentFrame(scoreList, i);
        }
    }

    private static void makeAnExtraRollForLastRound(Game bowlingGame, int i) {
        if (i == 10) {
            System.out.println("3th shot ->\nKnocked pin -> "
                    + bowlingGame.rollManuel(Integer.parseInt(myObj.nextLine()), 10));
            bowlingGame.updateScoresOfGamePerFrame();
        }
    }

    private static void printScoreUntilCurrentFrame(List<Integer> scoreList, int frameNumber) {
        for (int k = 0; k < frameNumber; k++)
            System.out.print(scoreList.get(k) + " ,");
        System.out.println("\n");
    }

    private static int rollTheBall(Game myGame, int countOfPin) {
        int knockedPin;
        knockedPin = myGame.rollManuel(Integer.parseInt(myObj.nextLine()), countOfPin);
        System.out.println("Knocked pin -> " + knockedPin);
        return knockedPin;
    }
}
