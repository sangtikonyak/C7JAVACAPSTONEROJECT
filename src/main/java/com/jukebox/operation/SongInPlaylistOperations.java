package com.jukebox.operation;

import com.jukebox.dao.SongInPlaylistDAO;
import com.jukebox.data.Song;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class SongInPlaylistOperations {
    private List<Song>playlist;
    public SongInPlaylistOperations(List<Song>playlist)
    {
        this.playlist=playlist;
    }
    public  void playPlaylist(int playlistId) throws SQLException, UnsupportedAudioFileException, LineUnavailableException, IOException {
        int count=0;
        List<Song>list=SongInPlaylistDAO.getPlaylistSong(playlistId,playlist);
        System.out.println("Song No \t Id \t Title");
        for (Song song : list) {
            System.out.println("\t "+count+"\t\t "+song.getId()+"\t\t "+song.getTitle());
            count++;
        }

    }

    public List<Song> getPlaylist() {
        return playlist;
    }

    public void setPlaylist(List<Song> playlist) {
        this.playlist = playlist;
    }
}
