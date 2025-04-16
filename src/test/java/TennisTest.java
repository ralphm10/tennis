import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TennisTest {

    private Player player1;
    private Player player2;
    private Game game;

    @BeforeEach
    void setUp() {
        player1 = new Player();
        player2 = new Player();
        game = new Game(player1, player2);
    }

    private void setDeuce() {
        for (int i = 0; i < 3; i++) {
            game.winBall(player1);
            game.winBall(player2);
        }
    }

    @Test
    void playerScore15AfterWinningOnePoint() {
        game.winBall(player1);
        int playerScore = player1.getScore();
        assertEquals(15, game.getDisplayScore(playerScore));
    }

    @Test
    void playerScore30AfterWinningTwoPoints() {
        game.winBall(player1);
        game.winBall(player1);
        int playerScore = player1.getScore();
        assertEquals(30, game.getDisplayScore(playerScore));
    }

    @Test
    void playerScore40AfterWinningThreePoints() {
        for (int i = 0; i < 3; i++) {
            game.winBall(player1);
        }
        int playerScore = player1.getScore();
        assertEquals(40, game.getDisplayScore(playerScore));
    }

    @Test
    void playerWinsGameAfterWiningFourUnansweredPoints() {
        for (int i = 0; i < 4; i++) {
            game.winBall(player1);
        }
        assertEquals(1, player1.getGames());
    }

    @Test
    void gameIsDeuceIfBothPlayersHave3Points() {
        setDeuce();
        Assertions.assertTrue(game.isDeuce());
    }

    @Test
    void playerHasAdvantageAfterWinningPointFromDeuce() {
        setDeuce();
        Assertions.assertTrue(game.isDeuce());

        game.winBall(player1);
        assertTrue(player1.hasAdvantage());
    }

    @Test
    void playerWinsWithTwoUnansweredPointsFromDeuce() {
        setDeuce();
        assertTrue(game.isDeuce());

        for (int i = 0; i < 2; i++) {
            game.winBall(player1);
        }

        Assertions.assertEquals(1, player1.getGames());
    }

    @Test
    void scoreIsDeuceIfPlayerWithAdvantageLosesBall() {
        setDeuce();
        assertTrue(game.isDeuce());

        game.winBall(player1);
        assertTrue(player1.hasAdvantage());
        assertFalse(game.isDeuce());

        game.winBall(player2);
        assertTrue(game.isDeuce());
    }
}
