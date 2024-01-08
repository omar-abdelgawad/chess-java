package utils;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class MoveSoundPlayer {
    public enum SoundType {
        MOVE, CAPTURE;
    }

    private static MoveSoundPlayer instance = null;
    private static final String audioPath = "res/sounds/Move.wav";
    private static final String capturePath = "res/sounds/Capture.wav";
    private AudioInputStream audioStream;
    private AudioInputStream audioStream2;
    private Clip clipMove;
    private Clip clipCapture;

    private MoveSoundPlayer() {
        File audioFile1 = new File(audioPath);
        File audioFile2 = new File(capturePath);
        try {
            audioStream = AudioSystem.getAudioInputStream(audioFile1);
            audioStream2 = AudioSystem.getAudioInputStream(audioFile2);
            clipMove = AudioSystem.getClip();
            clipCapture = AudioSystem.getClip();
            clipMove.open(audioStream);
            clipCapture.open(audioStream2);
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

    public void play(SoundType soundType) {
        if (SoundType.MOVE == soundType) {
            clipMove.start();
            clipMove.setFramePosition(0);
        } else {
            clipCapture.start();
            clipCapture.setFramePosition(0);
        }
    }

    public void close() {
        clipMove.close();
        clipCapture.close();
        try {
            audioStream.close();
            audioStream2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
