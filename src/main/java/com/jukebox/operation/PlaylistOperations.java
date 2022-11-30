package com.jukebox.operation;

import com.jukebox.dao.PlaylistDAO;
import com.jukebox.dao.SongInPlaylistDAO;
import com.jukebox.data.Playlist;
import com.jukebox.data.Song;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class PlaylistOperations {

    List<Playlist> playlists;
    List<Song> list;
    Scanner scan;

    public PlaylistOperations(List<Playlist> playlists, List<Song> list, Scanner scan) {
        this.playlists = playlists;
        this.list = list;
        this.scan = scan;
    }

    public PlaylistOperations() {
    }

    public void createPlaylist(String playlistName, List<Song>playlistSongs) throws SQLException, UnsupportedAudioFileException, LineUnavailableException, IOException {

        boolean flag = true;
        if (playlists.isEmpty()) {
            int playlistId = PlaylistDAO.insertIntoPlaylist(playlistName);
            displayAddSongToPlaylist(playlistId);

        }
        if (!playlists.isEmpty()) {
            for (Playlist playlist1 : playlists) {
                if (playlistName.equals(playlist1.getPlaylistName())) {
                    System.out.println("playlist already exist");
                    flag = false;
                    break;
                }
            }

        }
        if (flag) {
            int playlistId = PlaylistDAO.insertIntoPlaylist(playlistName);

            displayAddSongToPlaylist(playlistId);
            }


    }
    public void addSongToPlaylist() throws SQLException {
        for (Playlist playlist1 : playlists) {
            System.out.println(playlist1.getPlaylistId()+" "+ playlist1.getPlaylistName());
        }
        System.out.println("Enter playlist Id ");
        int playlistId=scan.nextInt();
        displayAddSongToPlaylist(playlistId);
    }
    private void displayAddSongToPlaylist(int playlistId) throws SQLException {
        boolean flag=true;
        while (true)
        {
            System.out.println("1.to add song");
            System.out.println("2.exit");
            int choice=scan.nextInt();
            switch (choice)
            {
                case 1:
                    Jukebox.displayAllSong();
                    System.out.println("enter song id to add song");
                    int songId=scan.nextInt();
                    List<Song>playlist=SongInPlaylistDAO.getPlaylistSong(playlistId,list);
                    for (Song song : playlist) {
                        if (song.getId() == songId) {
                            flag = false;
                            break;
                        }

                    }
                    if (flag)
                    {
                        PlaylistDAO.addSongToPlaylist(playlistId,songId);
                    }
                    else
                    {
                        System.out.println("Song already exist in playlist");
                    }
                    break;
                case 2:
                    break;
            }

            if (choice==2)
            {
                break;
            }
        }

    }


}
