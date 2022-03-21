import java.util.List;
import java.util.Objects;

public class Player {
    private String name;
    private List<Integer> scores;
    private int currentScore=0;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getScores() {
        return scores;
    }

    public void addToScoresList(int index, Integer scoreOfOneFrame) {
        this.scores.add(index,scoreOfOneFrame);
    }

    public int getCurrentScore() {
        return currentScore;
    }

    public void setCurrentScore(int currentScore) {
        this.currentScore = currentScore;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", scores=" + scores +
                ", currentScore=" + currentScore +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return currentScore == player.currentScore && name.equals(player.name) && Objects.equals(scores, player.scores);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, scores, currentScore);
    }
}
