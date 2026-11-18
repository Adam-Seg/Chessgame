package boardgames;

import javafx.scene.paint.Color;

public class Square {
    private Color color;
    private Piece piece;

    public Square(Color aColor) {
        color = aColor;
        piece = null;
    }

    public Color getColor() {
        return color;
    }

    public boolean isEmpty() {
        return piece == null;
    }

    public void setPiece(Piece aPiece) {
        piece = aPiece;
    }

    public Piece getPiece() {
        return piece;
    }

    public Piece removePiece() {
        Piece answer = piece;
        piece = null;
        return answer;
    }
}
