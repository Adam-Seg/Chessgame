package boardgames;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.paint.Color;

public class Board implements Observable {
    private Square[][] squares;
    private List<InvalidationListener> listeners;

    public Board(int size, Color dark, Color light){
        Color[] colors = {dark, light};
        squares = new Square[size][size];
        for(int fileIndex = 0; fileIndex < squares.length; ++fileIndex){
            for(int rankIndex = 0; rankIndex < squares[fileIndex].length; ++rankIndex){
                squares[fileIndex][rankIndex] = new Square(colors[(fileIndex + rankIndex)%2]);
            }
        }
        listeners = new ArrayList<InvalidationListener>();
    }

    public void clear(){
        for(int fileIndex = 0; fileIndex < squares.length; ++fileIndex){
            for(int rankIndex = 0; rankIndex < squares[fileIndex].length; ++rankIndex){
                squares[fileIndex][rankIndex].removePiece();
            }
        }
        notifyListeners();
    }

    public int size(){
        return squares.length;
    }

    public Square getSquare(Location aLoc){
        return squares[aLoc.fileIndex][aLoc.rankIndex];
    }

    public Color getColor(Location aLoc){
        return getSquare(aLoc).getColor();
    }

    public Piece getPiece(Location aLoc){
        return getSquare(aLoc).getPiece();
    }

    public void setPiece(Location aLoc, Piece aPiece){
        getSquare(aLoc).setPiece(aPiece);
        notifyListeners();
    }

    public Piece removePiece(Location aLoc){
        Piece answer = getSquare(aLoc).removePiece();
        notifyListeners();
        return answer;
    }

    public boolean isEmpty(Location aLoc){
        return getSquare(aLoc).isEmpty();
    }

    @Override
    public void addListener(InvalidationListener aListener) {
        listeners.add(aListener);
    }

    @Override
    public void removeListener(InvalidationListener aListener) {
        listeners.remove(aListener);
    }

    public void notifyListeners(){
        for(InvalidationListener eachListener : listeners){
            eachListener.invalidated(this);
        }
    }
}
