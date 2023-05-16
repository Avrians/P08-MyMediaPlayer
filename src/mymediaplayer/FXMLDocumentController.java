package mymediaplayer;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogEvent;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import javafx.util.Pair;

public class FXMLDocumentController implements Initializable {
    private MediaPlayer mediaPlayer;

    @FXML
    private MediaView mediaView;

    @FXML
    private StackPane sPane;

    @FXML
    private Button playPause;

    @FXML
    private Slider volume;

    @FXML
    private Slider seek;

    @FXML
    private BorderPane bPane;

    List<String> playlist = new ArrayList<>();
    List<String> sourceName = new ArrayList<>();
    static int INDEX, PLAY = 0;

    @FXML
    private void openFiles(ActionEvent event) {
        FileChooser fc = new FileChooser();
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("" + "Media File", "*.mp3", "*.mp4");
        fc.getExtensionFilters().add(filter);
        List<File> f = fc.showOpenMultipleDialog(null);
        if (!f.isEmpty()) {
            if (!playlist.isEmpty()) {
                playlist.clear();
                sourceName.clear();
            }
            for (int i = 0; i < f.size(); i++) {
                playlist.add(f.get(i).toURI().toString());
                sourceName.add(f.get(i).getName());
            }
            INDEX = 0;
            playMedia(INDEX);
        }
    }

    private void playMedia(int index) {
        String source = playlist.get(index);
        Media media = new Media(source);
        if (mediaPlayer != null && mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING) {
            mediaPlayer.stop();
        }
        mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);
        mediaView.autosize();

        DoubleProperty width = mediaView.fitWidthProperty();
        DoubleProperty height = mediaView.fitHeightProperty();
        width.bind(Bindings.selectDouble(mediaView.sceneProperty(), "width"));
        height.bind(Bindings.selectDouble(mediaView.sceneProperty(), "height"));
        mediaView.setPreserveRatio(true);
        
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
