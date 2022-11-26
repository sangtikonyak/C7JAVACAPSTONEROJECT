package com.jukebox.implementation;

import com.jukebox.data.Song;
import com.jukebox.operation.Jukebox;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class JukeboxImpl {
    public static void main(String[] args) {
        List<Song> songs= Arrays.asList(new Song("mockingbird","eminem","rap","2:30",0),
                new Song("lie","nf","rap","3:20",1));
        Scanner scan=new Scanner(System.in);
        Jukebox jukebox=new Jukebox(songs);
        jukebox.displayAllSong();
        System.out.println("Search song by Artist/genre/title");
        String getName=scan.next();
        jukebox.searchSong(getName);
    }
}
