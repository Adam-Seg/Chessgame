package boardgames;

import java.util.ArrayList;
import java.util.List;

public class NQueensPlayer extends Player {

    private Queen queen = new Queen();

    public NQueensPlayer(Board aBoard) {
        super(aBoard);
    }

    @Override
    public boolean hasSolved() {
        return moves.size() == board.size();
    }

    @Override
    public List<Move> nextLegalMoves() {
        List<Move> nextMoves = new ArrayList<>();
        int row = moves.size();
        int size = board.size();
        for (int file = 0; file < size; file++) {
            Location aLoc = new Location(file, row);
            if (isSafe(aLoc)) {
                nextMoves.add(new Move(null, aLoc, queen));
            }
        }
        return nextMoves;
    }

    public boolean isSafe(Location aLoc) {
        for (Move m : moves) {
            Location q = m.getEnd();
            if (isInSight(q, aLoc)) {
                return false;
            }
        }
        return true;
    }

    public boolean isInSight(Location from, Location to) {
        int f1 = from.fileIndex;
        int r1 = from.rankIndex;
        int f2 = to.fileIndex;
        int r2 = to.rankIndex;
        if (r1 == r2)
            return true;
        if (f1 == f2)
            return true;
        if (Math.abs(f1 - f2) == Math.abs(r1 - r2))
            return true;

        return false;
    }
}
