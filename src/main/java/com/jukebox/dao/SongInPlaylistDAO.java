package com.jukebox.dao;



import com.jukebox.data.Song;
import com.jukebox.util.Database;

import javax.management.Query;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SongInPlaylistDAO {
public static List<Song> getPlaylistSong(int playlistId,List<Song>songs) throws SQLException {
    List<Song> getPlaylistSong=new ArrayList<>();
    Connection connection=Database.getConnection();
    Statement statement= connection.createStatement();
    String query="SELECT SONG_ID FROM SONGINPLAYLIST WHERE PLAYLIST_ID="+playlistId+"";
    ResultSet resultSet=statement.executeQuery(query);
    while(resultSet.next())
    {
        for (Song song : songs) {
          if(resultSet.getInt(1)==song.getId())
          {
              getPlaylistSong.add(song);
          }
        }
    }

    return getPlaylistSong;
}


}
