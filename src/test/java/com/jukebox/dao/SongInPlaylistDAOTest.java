package com.jukebox.dao;

import com.jukebox.data.Song;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SongInPlaylistDAOTest {
    List<Song>list;
    SongDAO songDAO;
    @BeforeEach
    void setUp() {
        songDAO=new SongDAO();
        list=songDAO.listOfSong();
    }

    @AfterEach
    void tearDown() {
        songDAO=null;
        list=null;
    }

    @Test
    void getPlaylistSong() throws SQLException {
        String expected="Mocking bird";
        String actual=SongInPlaylistDAO.getPlaylistSong(1,list).get(0).getTitle();
        assertEquals(expected,actual);

    }
}