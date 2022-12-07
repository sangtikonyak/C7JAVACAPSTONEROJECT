package com.jukebox.dao;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class PlaylistDAOTest {

     int count;
    @BeforeEach
    void setUp() throws SQLException {

  count=PlaylistDAO.listOfPlaylist().size();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void insertIntoPlaylist() throws SQLException {
     int expected=8;
     int actual=PlaylistDAO.insertIntoPlaylist("test");
     count=actual;
     assertEquals(expected,actual);
    }

    @Test
    void addSongToPlaylist() {

    }

    @Test
    void listOfPlaylist() throws SQLException {
        int expected=count;
        int actual= PlaylistDAO.listOfPlaylist().size();
        assertEquals(expected,actual);
    }
}