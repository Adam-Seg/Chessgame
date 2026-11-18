package boardgames;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javafx.scene.paint.Color;

public class SquareTest {

    private Square lightSquare;
    private Square darkSquare;

    @BeforeEach
    private void setUp(){
        lightSquare = new Square(Color.WHITE);
        darkSquare = new Square(Color.BLACK);
    }

    @AfterEach
    private void tearDown(){
        lightSquare = null;
        darkSquare = null;
    }
    
    @Test
    public void testConstructor(){
        assertEquals(Color.WHITE, lightSquare.getColor());
        assertEquals(Color.BLACK, darkSquare.getColor());
        assertTrue(lightSquare.isEmpty());
        assertTrue(darkSquare.isEmpty());
    }

    @Test
    public void testPieceManagement(){
        Piece piece = new Piece();
        lightSquare.setPiece(piece);
        assertFalse(lightSquare.isEmpty());
        assertTrue(darkSquare.isEmpty());
        assertEquals(piece, lightSquare.getPiece());
        assertEquals(piece, lightSquare.removePiece());
        assertTrue(lightSquare.isEmpty());
    }
}
