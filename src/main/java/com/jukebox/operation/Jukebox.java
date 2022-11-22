package com.jukebox.operation;

import com.jukebox.data.Song;

import java.util.List;

public class Jukebox {
  private List<Song> allSong;

    public Jukebox(List<Song> allSong) {
        this.allSong = allSong;
    }

    public Jukebox() {
    }
}
