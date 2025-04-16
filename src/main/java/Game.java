public class Game {
    private static final int[] DISPLAY_SCORES = new int[]{0, 15, 30, 40};
    public static final int WINNING_SCORE = 3;
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
            return;
        }

        if (isWinningPoint(player)) {
            player.winGame();
            return;
        }

        if (deuce) {
            player.setAdvantage(true);
            deuce = false;
            return;
        }

        player.winPoint();
        setDeuce();
    }

    private boolean isWinningPoint(Player player) {
        return (player.getScore() == WINNING_SCORE && !deuce)
                || player.hasAdvantage();
    }


    private Player getOpponent(Player player) {
        return player == player1 ? player2 : player1;
    }

    public int getDisplayScore(int score) {
        return DISPLAY_SCORES[score];
    }

    public boolean isDeuce() {
        return deuce;
    }

    public void setDeuce() {
        deuce = player1.getScore() == WINNING_SCORE && player2.getScore() == WINNING_SCORE;
    }
}
