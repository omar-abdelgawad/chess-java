package utils;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class MoveSoundPlayer {
    private static MoveSoundPlayer instance = null;
    private static final String audioPath = "res/sounds/Move.wav";
    private AudioInputStream audioStream;
    private Clip clip;

    private MoveSoundPlayer() {
        File audioFile = new File(audioPath);
        try {
            audioStream = AudioSystem.getAudioInputStream(audioFile);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public static MoveSoundPlayer getInstance() {
        if (instance == null) {
            instance = new MoveSoundPlayer();
        }
        return instance;
    }

    // play the sound
    public void play() {
        try {
            clip.start();
            // Thread.sleep(clip.getMicrosecondLength() / 1000); // probably don't need this
            clip.setFramePosition(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Destroy the clip and audio stream
    public void close() {
        clip.close();
        try {
            audioStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
