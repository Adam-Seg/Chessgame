package boardgames;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import javafx.scene.paint.Color;;

public class MoveTest {
    private Piece knight;
    private Location a1;
    private Location b3;
    private Board board;
    private Move createMove;
    private Move relocateMove;

    @BeforeEach
    public void setUp() {
        knight = new Knight();
        a1 = new Location('a', 1);
        b3 = new Location('b', 3);
        board = new Board(6, Color.BLACK, Color.WHITE);
        createMove = new Move(null, a1, knight);
        relocateMove = new Move(a1, b3, knight);
    }

    @AfterEach
    public void tearDown() {
        knight = null;
        a1 = null;
        b3 = null;
        board = null;
        createMove = null;
        relocateMove = null;
    }

    @Test
    public void testConstructor() {
        assertNull(createMove.getStart());
        assertEquals(a1, createMove.getEnd());
        assertEquals(knight, createMove.getPiece());
        assertEquals(a1, relocateMove.getStart());
        assertEquals(b3, relocateMove.getEnd());
        assertEquals(knight, relocateMove.getPiece());
    }

    @Test
    public void testCreateMove(){
        createMove.doIt(board);
        assertEquals(knight, board.getPiece(a1));
        createMove.undoIt(board);
        assertTrue(board.isEmpty(a1));
    }
}
