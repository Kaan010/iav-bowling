import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Game {
    private static final int totalFrameCount = 10;
    private static final Scanner myObj = new Scanner(System.in);
    private int roll = 0;
    private int[] rollArray = new int[22];
    private List<Integer> scoresByFrame = new ArrayList<>();

    public int rollManuel(int pinsDown, int pinsLeft) {
        while (pinsDown > pinsLeft) {
            System.err.println("You cannot hit more than exist pin! Try again:");
            pinsDown = Integer.parseInt(myObj.nextLine());
        }
        rollArray[roll++] = pinsDown;
        return pinsDown;
    }

    public int randomRoll(int pinsLeft) { //TODO: Use it for non-interactive game
        rollArray[roll++] = ThreadLocalRandom.current().nextInt(0, pinsLeft + 1);
        return rollArray[roll - 1];
    }

    public List<Integer> updateScoresOfGamePerFrame() {
        scoresByFrame.clear();
        int score = 0;
        int cursor = 0;
        for (int frame = 0; frame < totalFrameCount; frame++) {
            if (isStrike(cursor)) {
                score += 10 + rollArray[cursor + 1] + rollArray[cursor + 2];
                cursor++;
            } else if (isSpare(cursor)) {
                score += 10 + rollArray[cursor + 2];
                cursor += 2;
            } else {
                score += rollArray[cursor] + rollArray[cursor + 1];
                cursor += 2;
            }
            scoresByFrame.add(frame, score);
        }
        return scoresByFrame;
    }

    public boolean isStrike(int cursor) {
        return rollArray[cursor] == 10;
    }

    private boolean isSpare(int cursor) {
        return rollArray[cursor] + rollArray[cursor + 1] == 10;
    }


}
