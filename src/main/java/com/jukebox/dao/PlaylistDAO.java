package com.jukebox.dao;

import com.jukebox.data.Playlist;
import com.jukebox.util.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PlaylistDAO {
    public static int insertIntoPlaylist(String playlistName) throws SQLException {
        Connection connection= Database.getConnection();
        int response=0;
        int playlistId=0;
        String query="INSERT INTO PLAYLIST(playlist_name) VALUES("+"'"+playlistName+"')";
        Statement statement=connection.createStatement();
        response =statement.executeUpdate(query);
        if (response!=0)
        {
            System.out.println("Playlist added successfully");
        }
        ResultSet set= statement.executeQuery("SELECT PLAYLIST_ID FROM PLAYLIST");
        while(set.next())
        {

            playlistId= set.getInt(1);
        }
        return playlistId;
    }
    public static void addSongToPlaylist(int playlistId, int songId) throws SQLException {
        int response=0;
       Connection connection=Database.getConnection();
       Statement statement= connection.createStatement();
       String query="INSERT INTO SONGINPLAYLIST VALUES("+playlistId+"," + songId+")";
       response= statement.executeUpdate(query);
       if (response!=0)
       {
           System.out.println("song added in playlist successfully");
       }
    }
    public static List<Playlist> listOfPlaylist() throws SQLException {
        List<Playlist> playlists=new ArrayList<>();
        Connection connection=Database.getConnection();
        String query="SELECT * FROM PLAYLIST";
        Statement statement=connection.createStatement();
        ResultSet resultSet=statement.executeQuery(query);
        while(resultSet.next())
        {
            Playlist playlist=new Playlist();
            playlist.setPlaylistName(resultSet.getString(1));
            playlist.setPlaylistId(resultSet.getInt(2));
            playlists.add(playlist);
        }
        return playlists;
    }


}
