package boardgames;

public class Knight extends Piece {
    public static int[] fileOffsets = {-1, 1, 2, 2, 1, -1, -2, -2};
    public static int[] rankOffsets = {2, 2, 1, -1, -1, -2, -2, 1};

    @Override
    public String toString(){
        return "Kn";
    }

    @Override
    public String fileName(){
        return "./knight.png";
    }
}
