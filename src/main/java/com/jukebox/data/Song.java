package com.jukebox.data;

public class Song {
    private String title;
    private String artist;
    private String genre;
    private int duration;
    private int id;

    public Song(String title, String artist, String genre, int duration, int id) {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.duration = duration;
        this.id = id;
    }
}
