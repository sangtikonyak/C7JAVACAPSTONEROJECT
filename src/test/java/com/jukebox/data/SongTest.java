package com.jukebox.data;

import com.jukebox.operation.Jukebox;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SongTest {

    List<Song> list;
    Jukebox jukebox;
    @BeforeEach
    void setUp() {
        list= Arrays.asList(new Song("mockingbird","eminem","rap","2:30",0),
                new Song("lie","nf","rap","3:20",1));
        jukebox=new Jukebox(list);
    }

    @AfterEach
    void tearDown() {
        jukebox=null;
        list=null;
    }
    @Test
    public void returnAllSongListByArtist()
    {
        String equals="[Song{title='mockingbird', artist='eminem', genre='rap', duration=2:30, id=0}]";
        List<Song>list1=jukebox.searchSongByArtist("eminem");
        assertEquals(equals,list1);

    }

}