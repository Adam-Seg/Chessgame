package boardgames;
import java.io.StringWriter;

public class Move {
    private Location start;
    private Location end;
    private Piece piece;

    public Move(Location aStart, Location anEnd, Piece aPiece){
        start = aStart;
        end = anEnd;
        piece = aPiece;
    }

    public Location getStart() {
        return start;
    }

    public Location getEnd() {
        return end;
    }

    public Piece getPiece() {
        return piece;
    }

    public void doIt(Board aBoard){
        if(start != null){
            aBoard.removePiece(start);
        }
        aBoard.setPiece(end, piece);
    }

    public void undoIt(Board aBoard){
        aBoard.removePiece(end);
        if(start != null){
            aBoard.setPiece(start, piece);
        }
    }

    @Override
    public String toString(){
        StringWriter writer = new StringWriter();
        writer.write(piece.toString());
        writer.write(" ");
        if(start != null){
            writer.write(start.toString());
            writer.write(" -> ");
        }
        writer.write(end.toString());
        return writer.toString();
    }
}
