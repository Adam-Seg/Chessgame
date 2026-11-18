package boardgames;

import java.util.List;
import java.util.ArrayList;

public class KnightsTourPlayer extends Player {

    private Knight knight = new Knight();

    public KnightsTourPlayer(Board aBoard, Location start) {
        super(aBoard);
        Move startMove = new Move(null, start, knight);
        make(startMove);
    }

    @Override
    public boolean hasSolved() {
        return board.size() * board.size() == moves.size();
    }

    @Override
    public List<Move> nextLegalMoves() {
        List<Move> nextMoves = new ArrayList<Move>();
        Location currentLocation = moves.get(moves.size()-1).getEnd();
        List<Location> possibleLocations = nextPossibleLocations(currentLocation);
        for(Location eachLocation : possibleLocations){
            nextMoves.add(new Move(currentLocation, eachLocation, knight));
        }
        return nextMoves;
    }

    public boolean hasVisited(Location aLocation){
        for(Move eachMove : moves){
            if(eachMove.getEnd().equals(aLocation)){
                return true;
            }
        }
        return false;
    }

    public List<Location> nextPossibleLocations(Location aLocation){
        List<Location> locations = new ArrayList<Location>();
        for(int i = 0; i < Knight.fileOffsets.length; ++i){
            int fileIndex = aLocation.fileIndex + Knight.fileOffsets[i];
            int rankIndex = aLocation.rankIndex + Knight.rankOffsets[i];
            if(fileIndex > -1 && fileIndex < board.size() 
                && rankIndex > -1 && rankIndex < board.size()){
                Location possibleLocation = new Location(fileIndex, rankIndex);
                if(!hasVisited(possibleLocation)){
                    locations.add(possibleLocation);
                }
            }
        }
        return locations;
    }
    
}
