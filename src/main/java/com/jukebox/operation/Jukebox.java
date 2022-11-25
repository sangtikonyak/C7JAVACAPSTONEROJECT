package com.jukebox.operation;

import com.jukebox.data.Playlist;
import com.jukebox.data.Song;

import java.util.ArrayList;
import java.util.List;

public class Jukebox {
  private  List<Song> allSong;

    public Jukebox(List<Song> allSong) {
        this.allSong = allSong;
    }

    public Jukebox() {
    }

    public List<Song> getAllSong() {
        return allSong;
    }

    public void setAllSong(List<Song> allSong) {
        this.allSong = allSong;
    }

    public void displayAllSong()
    {
        int count=0;
        for (Song song : allSong) {
            System.out.println(count + " " +song.getTitle());
            count++;
        }
    }

    public List<Song> searchSongByArtist(String name)
    {
        List<Song> getSongByArtist=new ArrayList<>();
        for (Song song : allSong) {
            if(name.equals(song.getArtist()))
            {
                getSongByArtist.add(song);
            }
            else {
                System.out.println("Artist not found");
            }
        }
        return getSongByArtist;
    }

   public List<Song> searchSongByGenre(String genre)
   {
       List<Song> getSongByGenre=new ArrayList<>();
       for (Song song : allSong) {
           if(genre.equals(song.getGenre()))
           {
               getSongByGenre.add(song);
           }
           else {
               System.out.println("Genre not found");
           }
       }
       return getSongByGenre;
   }

   public String createPlaylist(String playlistName)
   {
           return playlistName;
       }
   }

