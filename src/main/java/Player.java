public class Player {
    private int points = 0;
    private int games = 0;
    private boolean advantage;

    public int getScore() {
        return points;
    }

    public void winPoint() {
        points ++;
    }

    public int getGames() {
        return games;
    }

    public void winGame() {
        games ++;
    }

    public boolean hasAdvantage() {
        return advantage;
    }

    public void setAdvantage(boolean advantage) {
        this.advantage = advantage;
    }
}
