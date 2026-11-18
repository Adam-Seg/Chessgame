package boardgames;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javafx.scene.image.Image;

public class Piece {

    private Image image = null;
    
    public Image getImage(){
        if(image == null){
            try {
                loadImage();
            } catch(IOException ex){
                // default is to set image to null
                image = null;
            }
        }
        return image;
    }

    public void loadImage() throws IOException {
        InputStream input = null;
        try {
            input = new FileInputStream(fileName());
            image = new Image(input);
        } finally {
            if(input != null){
                input.close();
            }
        }
    }

    public String fileName(){
        return "./piece.png";
    }
    
    @Override
    public String toString(){
        return "piece";
    }
}
