package com.jukebox.operation;

import com.jukebox.data.Song;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class SongOperations {
  long currentFrame;
  Clip cLip;
  AudioInputStream audioInputStream;
  String status;
  List<Song> songList;

    public SongOperations(List<Song> songList) {
        this.songList = songList;
    }

    public void playMusic(String name) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        for (Song song : songList) {
            if (name.equals(song.getTitle()))
            {
                audioInputStream= AudioSystem.getAudioInputStream(new File(song.getFilepath()));
                cLip=AudioSystem.getClip();
                cLip.open(audioInputStream);
                cLip.start();
                status="play";
            }
        }
    }

}
