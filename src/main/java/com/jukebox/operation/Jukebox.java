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
        int count=0;
        System.out.println("Song No \t Id \t Title");
        for (Song song : allSong) {
            System.out.println("\t "+count+"\t\t "+song.getId()+"\t\t "+song.getTitle());
            count++;
        }
    }
    public void displayFunctions()
    {
        System.out.println("1.Play a song");
        System.out.println("2.play all song");
        System.out.println("3.Create playlist");
        System.out.println("4.Search For Song");
        System.out.println("5.Show Existing Playlist");
        System.out.println("6Add Song To Playlist");
        System.out.println("7.Exit");
    }
   public String createPlaylist(String playlistName)
   {
           return playlistName;
       }
       public List<Song> searchSong(String name)
       {
           List<Song> searchSong=new ArrayList<>();
           int count=0;
           name=name.substring(0,1).toUpperCase() + name.substring(1);
           System.out.println("id\t\tTitle");
           for (Song song : allSong) {
               if (name.equals(song.getGenre()) || name.equals(song.getArtist()) ||
                       name.equals(song.getTitle())){
                   System.out.println(count+" " + song.getId()+" "+song.getTitle());
                   searchSong.add(song);
                   count++;
               }
           }
           return searchSong;
       }

   }

