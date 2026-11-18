package boardgames;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class BoardView extends Canvas {
    
    private Board model;

    public BoardView(Board board, double width, double height){
        super(width, height);
        model = board;
        board.addListener( (aBoard)->redraw() );
        redraw();
    }

    public void redraw(){
        for(int fileIndex = 0; fileIndex < model.size(); ++fileIndex){
            for(int rankIndex = 0; rankIndex < model.size(); ++rankIndex){
                Location aLoc = new Location(fileIndex, rankIndex);
                drawSquare(model.getSquare(aLoc), aLoc);
            }
        }
    }

    public void drawSquare(Square aSquare, Location aLocation){
        GraphicsContext gc = this.getGraphicsContext2D();
        double size = this.getWidth() / model.size();
        gc.setFill(aSquare.getColor());
        double x = aLocation.fileIndex * size;
        double y = (model.size() - aLocation.rankIndex - 1) * size;
        gc.fillRect(x, y, size, size);
        if(!aSquare.isEmpty()){
            Image image = aSquare.getPiece().getImage();
            gc.drawImage(image, x, y, size, size);
        }
    }
}
