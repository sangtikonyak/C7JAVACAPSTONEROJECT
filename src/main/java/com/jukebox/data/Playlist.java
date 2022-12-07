package com.jukebox.data;



import java.util.List;

public class Playlist {
    private String playlistName;
    private int playlistId;
    private List<Song>songList;

    public Playlist(String playlistName, int playlistId, List<Song> songList) {
        this.playlistName = playlistName;
       // this.playlistId = playlistId;
        this.songList = songList;
    }

    public Playlist() {
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

    public int getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(int playlistId) {
        this.playlistId = playlistId;
    }

    public List<Song> getSongList() {
        return songList;
    }

    public void setSongList(List<Song> songList) {
        this.songList = songList;
    }


    @Override
    public String toString() {
        return "Playlist{" +
                "playlistName='" + playlistName + '\'' +
                ", playlistId=" + playlistId +
                ", songList=" + songList +
                '}';
    }
}
