package com.jukebox.data;

import java.util.List;

public class Playlist {
    private String playlistName;
    private int playlistId;
    private List<Song>songList;

    public Playlist(String playlistName, int playlistId, List<Song> songList) {
        this.playlistName = playlistName;
        this.playlistId = playlistId;
        this.songList = songList;
    }

    public Playlist() {
    }
}
