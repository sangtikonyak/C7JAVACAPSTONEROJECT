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
public static List<Integer> getSongId() throws SQLException {
    List<Integer> integerList=new ArrayList<>();
    Connection connection= Database.getConnection();
    Statement statement=connection.createStatement();
    String query="SELECT SONG_ID FROM SONGINPLAYLIST";
    ResultSet resultSet= statement.executeQuery(query);
    while (resultSet.next())
    {
        integerList.add(resultSet.getInt(1));
    }
    return integerList;
}
public List<Song> getPlaylistSong(int playlistId)
{
    List<Song> getPlaylistSong=new ArrayList<>();

    return getPlaylistSong;
}
}
