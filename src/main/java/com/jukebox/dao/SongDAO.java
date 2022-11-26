package com.jukebox.dao;

import com.jukebox.data.Song;
import com.jukebox.util.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SongDAO {

    public List<Song> listOfSong()
    {
        List<Song> songList=new ArrayList<>();
        Connection connection= Database.getConnection();
        try {
            Statement statement = connection.createStatement();
            String query="SELECT * FROM SONG";
            ResultSet resultSet=statement.executeQuery(query);
            while(resultSet.next())
            {
                Song song=new Song();
                song.setId(resultSet.getInt(1));
                song.setTitle(resultSet.getString(2));
                song.setArtist(resultSet.getString(3));
                song.setGenre(resultSet.getString(4));
                song.setDuration(resultSet.getString(5));
                song.setFilepath(resultSet.getString(6));
                songList.add(song);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
       return songList;
    }

}
