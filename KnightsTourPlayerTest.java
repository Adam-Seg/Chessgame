package boardgames;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import java.util.List;
import javafx.scene.paint.Color;

public class KnightsTourPlayerTest {

    private Board board;
    private KnightsTourPlayer player;
    Location a1;

    @BeforeEach
    public void setUp(){
        a1 = new Location('a', 1);
        board = new Board(6, Color.BLACK, Color.WHITE);
        player = new KnightsTourPlayer(board, a1);
    }


    // NOTE: We are going to "fake" a winning situation by directly adding
    // a dummy move to the move list until the number of moves equals
    // board size squared.
    @Test
    public void testHasSolved() {
        Move dummyMove = new Move(null, null, new Knight());
        for(int i = 0; i < board.size() * board.size() - 1; ++i){
            assertFalse(player.hasSolved());
            player.getMoves().add(dummyMove);
        }
        assertTrue(player.hasSolved());
    }

    @Test
    public void testNextLegalMoves() {
       // fail("Need to write this test.");
    }

    @Test
    public void testHasVisited(){
        Piece knight = new Knight();
        Location a1 = new Location('a', 1);
        Location b3 = new Location('b', 3);
        Location d2 = new Location('d', 2);
        Move moveToB3 = new Move(a1, b3, knight);
        Move moveToD2 = new Move(b3, d2, knight);
        assertTrue(player.hasVisited(a1));
        assertFalse(player.hasVisited(b3));
        assertFalse(player.hasVisited(d2));
        player.make(moveToB3);
        assertTrue(player.hasVisited(a1));
        assertTrue(player.hasVisited(b3));
        assertFalse(player.hasVisited(d2));
        player.make(moveToD2);
        assertTrue(player.hasVisited(a1));
        assertTrue(player.hasVisited(b3));
        assertTrue(player.hasVisited(d2));
    }

    @Test
    public void testNextPossibleLocations(){
        Location b3 = new Location('b', 3);
        Location c2 = new Location('c', 2);
        List<Location> locs = player.nextPossibleLocations(a1);
        assertEquals(2, locs.size());
        assertTrue(locs.contains(b3));
        assertTrue(locs.contains(c2));
        locs = player.nextPossibleLocations(b3);
        assertEquals(5, locs.size());
        assertFalse(locs.contains(a1));
    }

    @Test
    public void testSolve(){
        assertTrue(player.solve());
    }
}

