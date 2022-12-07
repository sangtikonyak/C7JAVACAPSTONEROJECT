package com.jukebox.operation;

import com.jukebox.dao.PlaylistDAO;
import com.jukebox.dao.SongDAO;
import com.jukebox.data.Playlist;
import com.jukebox.data.Song;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class PlaylistOperationsTest {
    PlaylistOperations playlistOperations;
    Scanner scan;
    SongDAO songDAO;
    List<Song> list;
    List<Playlist> playlists;
    @BeforeEach
    void setUp() throws SQLException {
        songDAO=new SongDAO();
        scan=new Scanner(System.in);
        list=songDAO.listOfSong();
        playlists= PlaylistDAO.listOfPlaylist();
        playlistOperations=new PlaylistOperations(playlists,list,scan);
    }

    @AfterEach
    void tearDown() {
        songDAO=null;
        scan=null;
        list=null;
        playlists=null;
        playlistOperations=null;
    }

    @Test
    void createPlaylist() throws UnsupportedAudioFileException, SQLException, LineUnavailableException, IOException {
        int expected=11;
        int actual=playlistOperations.createPlaylist("happy");
        assertEquals(expected,actual);
    }

    @Test
    void addSongToPlaylist() {
    }

    @Test
    void displayPlaylist() {
    }
}