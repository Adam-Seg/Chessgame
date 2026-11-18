package boardgames;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.util.List;
import javafx.scene.paint.Color;

public class NQueensPlayerTest {

    Board board;
    NQueensPlayer player;
    Location b1 = new Location('b', 1);
    Location a2 = new Location('a', 2);
    Location b4 = new Location('b', 4);
    Location c4 = new Location('c', 4);
    Location d3 = new Location('d', 3);
    Location d2 = new Location('d', 2);
    Location d1 = new Location('d', 1);
    Move queenB1 = new Move(null, b1, new Queen());

    @BeforeEach
    public void setUp() {
        board = new Board(8, Color.BLACK, Color.WHITE);
        player = new NQueensPlayer(board);
    }

    @AfterEach
    public void tearDown() {
        board = null;
        player = null;
    }

    // NOTE: We are going to "fake" a winning situation by directly adding
    // a dummy move to the move list until the number of moves equals
    // board size.
    @Test
    void testHasSolved() {
        Move dummyMove = new Move(null, null, new Queen());
        for (int i = 0; i < board.size(); ++i) {
            assertFalse(player.hasSolved());
            player.getMoves().add(dummyMove);
        }
        assertTrue(player.hasSolved());
    }

    @Test
    void testNextLegalMoves() {
        Move queenD2 = new Move(null, d2, new Queen());
        List<Move> nextMoves = player.nextLegalMoves();
        assertEquals(8, nextMoves.size());
        player.make(queenB1);
        nextMoves = player.nextLegalMoves();
        assertEquals(5, nextMoves.size());
        player.make(queenD2);
        nextMoves = player.nextLegalMoves();
        assertEquals(4, nextMoves.size());

    }

    @Test
    void testIsSafe() {
        player.make(queenB1);
        assertFalse(player.isSafe(a2));
        assertTrue(player.isSafe(d2));
    }

    @Test
    void testIsInSight(){
        assertTrue(player.isInSight(b1, a2));
        assertTrue(player.isInSight(b1, b4));
        assertFalse(player.isInSight(b1, c4));
        assertTrue(player.isInSight(b1, d3));
        assertFalse(player.isInSight(b1, d2));        
        assertTrue(player.isInSight(b1, d1));
    }

    @Test
    public void testSolve(){
        assertTrue(player.solve());
    }
}
