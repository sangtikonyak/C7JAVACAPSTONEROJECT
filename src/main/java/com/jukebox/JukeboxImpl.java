package com.jukebox;

import com.jukebox.data.Song;
import com.jukebox.operation.Jukebox;

import java.util.Arrays;
import java.util.List;

public class JukeboxImpl {
    public static void main(String[] args) {
        List<Song> songs= Arrays.asList(new Song("mockingbird","eminem","rap","2:30",0),
                new Song("lie","nf","rap","3:20",1));
        Jukebox jukebox=new Jukebox(songs);
        jukebox.displayAllSong();
        List<Song> getListByArtist=jukebox.searchSongByArtist("eminem");
        System.out.println("getListByArtist = " + getListByArtist);
    }
}
