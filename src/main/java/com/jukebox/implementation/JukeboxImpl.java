package com.jukebox.implementation;

import com.jukebox.dao.SongDAO;
import com.jukebox.data.Song;
import com.jukebox.operation.Jukebox;
import com.jukebox.operation.SongOperations;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
public class JukeboxImpl {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        SongDAO songDAO = new SongDAO();
        List<Song> songList = songDAO.listOfSong();
        Jukebox jukebox = new Jukebox(songList);
        SongOperations songOperations = new SongOperations(songList, scan);
        jukebox.displayAllSong();
        List<Song> getSearchSong;
        String songName;
        int number;
        boolean flag=true;
        while (flag) {
            jukebox.displayFunctions();
            int userChoice = scan.nextInt();
            switch (userChoice) {
                case 1:
                    System.out.println("Enter song name");
                    ;
                    scan.nextLine();
                    songName = scan.nextLine();
                    songName = songName.substring(0, 1).toUpperCase() + songName.substring(1);
                    try {
                        songOperations.playMusic(songName);
                        songOperations.musicFunctions();


                    } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 2:
                    jukebox.displayAllSong();
                    System.out.println("Enter song number to start playing songs");
                    number = scan.nextInt();
                    try {
                        songOperations.play(number);
                    } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 4:
                    System.out.println("Search song by Artist/genre/title");
                    String getName = scan.next();
                     getSearchSong = jukebox.searchSong(getName);
                    if (!getSearchSong.isEmpty()) {
                        System.out.println("Enter 1 to play a song\nEnter 2 to play all song");
                        int choice = scan.nextInt();
                        if (choice == 1) {
                            System.out.println("Enter song name");
                            scan.nextLine();
                            songName = scan.nextLine();
                            songName = songName.substring(0, 1).toUpperCase() + songName.substring(1);
                            try {
                                songOperations.playMusic(songName);
                                songOperations.musicFunctions();


                            } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
                                throw new RuntimeException(e);
                            }
                        } else {

                            System.out.println("Enter song number to start playing songs");
                            number = scan.nextInt();
                            try {
                                songOperations.play(number,getSearchSong);
                            } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    } else {
                        System.out.println("Song not found");
                    }
                    break;
                case 7:
                    flag=false;
            }

        }

    }
}
