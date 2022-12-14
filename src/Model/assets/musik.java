
package Model.assets;

import javafx.application.Application;
import javafx.stage.Stage;
import java.io.File;  
  
import javafx.application.Application;  
import javafx.scene.Group;  
import javafx.scene.media.Media;  
import javafx.scene.media.MediaPlayer;  
import javafx.scene.media.MediaView;  
import javafx.stage.Stage;  


public class musik extends Application 
{

    @Override
    public void start(Stage stage) throws Exception
    {
         String path ="D:\\One\\Desktop\\pong\\PONGSPIEL\\src\\Model\\assets\\JoshWoodward-BetterDays.mp3";
         Media media = new Media(new File(path).toURI().toString());  
    }
    
}
