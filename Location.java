package boardgames;

public class Location {
    public int fileIndex;
    public int rankIndex;

    public Location(int fileIndex, int rankIndex) {
        this.fileIndex = fileIndex;
        this.rankIndex = rankIndex;
    }

    public Location(char file, int rank) {
        this.fileIndex = (int) (file - 'a');
        this.rankIndex = rank - 1;
    }

    public char getFile(){
        return (char)(fileIndex + 'a');
    }

    public int getRank(){
        return rankIndex + 1;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + fileIndex;
        result = prime * result + rankIndex;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (this.getClass() != obj.getClass())
            return false;
        Location other = (Location) obj;
        if (this.fileIndex != other.fileIndex)
            return false;
        if (this.rankIndex != other.rankIndex)
            return false;
        return true;
    }

    @Override
    public String toString(){
        return "" + getFile() + getRank();
    }
}
