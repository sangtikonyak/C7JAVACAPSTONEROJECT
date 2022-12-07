package com.jukebox.dao;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SongDAOTest {
     SongDAO songDAO;
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        songDAO=new SongDAO();
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        songDAO=null;
    }
    @Test
    public void listOfSong()
    {
        String exp="Eminem";
        String actual=songDAO.listOfSong().get(1).getArtist();
        assertEquals(exp,actual);
    }
}