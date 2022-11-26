package com.jukebox.operation;

import com.jukebox.data.Playlist;
import com.jukebox.data.Song;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        System.out.println("Id\t\t Title\t\t Artist\t\t Genre\t\t Duration");
        for (Song song : allSong) {
            System.out.println(song.getId()+" "+song.getTitle()+" "+song.getArtist()+" "+
                    song.getGenre()+" "+ song.getDuration());
        }
    }
    public void displayFunctions()
    {
        System.out.println("1.playMusic");
        System.out.println("2.Create playlist");
        System.out.println("3.Search For Song");
        System.out.println("4.Show Existing Playlist");
        System.out.println("5.Add Song To Playlist");
        System.out.println("5.Exit");
    }
    

    public List<Song> searchSongByArtist(String name)
    {
        List<Song> list=new ArrayList<>();
        for (Song song : allSong) {
            if(name.equals(song.getArtist()))
            {
                list.add(song);
            }
        }
          return list;
    }


   public void searchSongByGenre(String genre)
   {
      String getGenre="";
      int count=0;
       for (Song song : allSong) {
           if(genre.equals(song.getGenre()))
           {
               System.out.println(count+" "+song.getTitle());
           }

       }

   }

   public String createPlaylist(String playlistName)
   {
           return playlistName;
       }
       public void searchSong()
       {
           Scanner scan=new Scanner(System.in);
           String name=scan.next();
           for (Song song : allSong) {
               
           }
       }

   }

