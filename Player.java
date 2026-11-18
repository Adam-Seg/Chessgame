package boardgames;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public abstract class Player {
    protected Board board;
    protected ObservableList<Move> moves;

    public abstract boolean hasSolved();
    public abstract List<Move> nextLegalMoves();

    public Player(Board aBoard) {
        board = aBoard;
        moves = FXCollections.observableArrayList();
    }

    public Board getBoard() {
        return board;
    }

    public ObservableList<Move> getMoves() {
        return moves;
    }

    public boolean solve(){
        if(hasSolved()) return true;
        List<Move> nextLegalMoves = nextLegalMoves();
        for(Move eachMove : nextLegalMoves){
            make(eachMove);
            if(solve()) return true;
            unmake(eachMove);
        }
        return false;
    }

    public void make(Move aMove){
        aMove.doIt(board);
        moves.add(aMove);
    }

    public void unmake(Move aMove){
        moves.remove(moves.size()-1);
        aMove.undoIt(board);
    }
}
