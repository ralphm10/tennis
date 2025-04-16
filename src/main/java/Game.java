public class Game {
    private static final int[] POINTS = new int[]{0, 15, 30, 40};
    private final Player player1;
    private final Player player2;
    private boolean deuce;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void winBall(Player player) {
        if (getOpponent(player).hasAdvantage()) {
            deuce = true;
        } else if (player.getScore() == 3 && !deuce || player.hasAdvantage()) {
            player.winGame();
        } else if (deuce) {
            player.setAdvantage(true);
            deuce = false;
        } else {
            player.winPoint();
            setDeuce();
        }
    }

    private Player getOpponent(Player player) {
        return player == player1 ? player2 : player1;
    }

    public int convertPoints(int score) {
        return POINTS[score];
    }

    public boolean isDeuce() {
        return deuce;
    }

    public void setDeuce() {
        deuce = player1.getScore() == 3 && player2.getScore() == 3;
    }
}
