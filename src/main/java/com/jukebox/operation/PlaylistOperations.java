package com.jukebox.operation;

import com.jukebox.dao.PlaylistDAO;
import com.jukebox.dao.SongInPlaylistDAO;
import com.jukebox.data.Playlist;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class PlaylistOperations {

    Playlist playlist;
    List<Playlist> playlists;
    Scanner scan;
    public PlaylistOperations(List<Playlist> list,Scanner scan)
    {
        this.playlists=list;
        playlist=new Playlist();
        this.scan=scan;
    }

    public PlaylistOperations() {
    }

    public void createPlaylist(String playlistName) throws SQLException {
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
                    int songId=scan.nextInt();
                     List<Integer> songIdList= SongInPlaylistDAO.getSongId();
                    if (songIdList.contains(songId))
                    {
                        flag=false;
                    }
                    if (flag) {
                        PlaylistDAO.addSongToPlaylist(playlistId, songId);
                    }
                    else {
                        System.out.println("song already added");
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
