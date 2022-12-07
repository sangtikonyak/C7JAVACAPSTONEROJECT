package com.jukebox.operation;

import com.jukebox.dao.SongDAO;
import com.jukebox.data.Song;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JukeboxTest {
    Jukebox jukebox;
    SongDAO songDAO;
    List<Song> list;
    @BeforeEach
    void setUp()
    {
        songDAO=new SongDAO();
        list=songDAO.listOfSong();
       jukebox=new Jukebox(list);
    }
    @AfterEach
    void tearDown()
    {
     jukebox=null;
    }
    @Test
    void searchSong() {
        String expected="Venom";
        String actual=jukebox.searchSong("venom").get(0).getTitle();
        assertEquals(expected,actual);
    }
}