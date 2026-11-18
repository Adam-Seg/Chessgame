package boardgames;

public class Queen extends Piece {
     @Override
    public String toString(){
        return "Q";
    }

    @Override
    public String fileName(){
        return "./queen.png";
    }
}
