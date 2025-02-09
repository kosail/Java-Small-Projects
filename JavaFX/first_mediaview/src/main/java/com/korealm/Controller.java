package com.korealm;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

public class Controller {

    @FXML MediaView mediaView;
    @FXML Button playButton, stopButton, resetButton, forwardButton;

    private Media media;
    private MediaPlayer mediaPlayer;

    @FXML
    public void initialize() {        
        media = new Media(getClass().getResource("hw.mp4").toString());
        mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);
    }

    public void play() { mediaPlayer.play(); }

    public void stop() { mediaPlayer.pause(); }

    public void reset() { mediaPlayer.stop(); }

    public void error() {
        System.err.println("An error has occurred and the video cannot be played!");
    }

    public void forward() {
        mediaPlayer.seek(mediaPlayer.getCurrentTime().add(Duration.seconds(10)));
    }
}
