package boardgames;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import javafx.scene.paint.Color;

public class BoardTest {

    private Board board;
    private Location a1;
    private Location b3;

    @BeforeEach
    public void setUp(){
        board = new Board(8, Color.BLACK, Color.WHITE);
        a1 = new Location('a', 1);
        b3 = new Location('b', 3);
    }

    @AfterEach
    public void tearDown(){
        board = null;
        a1 = null;
        b3 = null;
    }

    @Test
    public void testConstructor(){
        assertEquals(8, board.size());
        assertEquals(Color.BLACK, board.getColor(a1));
        assertEquals(Color.WHITE, board.getColor(b3));
        assertEquals(Color.BLACK, board.getSquare(a1).getColor());
    }

    @Test
    public void testPieceManagement(){
        Piece piece = new Piece();
        board.setPiece(b3, piece);
        assertTrue(board.isEmpty(a1));
        assertFalse(board.isEmpty(b3));
        assertEquals(piece, board.getPiece(b3));
        assertFalse(board.isEmpty(b3));
        assertEquals(piece, board.removePiece(b3));
        assertTrue(board.isEmpty(b3));
    }

}
