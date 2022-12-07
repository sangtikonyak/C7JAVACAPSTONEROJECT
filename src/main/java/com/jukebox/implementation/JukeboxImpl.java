package com.jukebox.implementation;

import com.jukebox.dao.PlaylistDAO;
import com.jukebox.dao.SongDAO;
import com.jukebox.dao.SongInPlaylistDAO;
import com.jukebox.data.Playlist;
import com.jukebox.data.Song;
import com.jukebox.operation.Jukebox;
import com.jukebox.operation.PlaylistOperations;
import com.jukebox.operation.SongInPlaylistOperations;
import com.jukebox.operation.SongOperations;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
public class JukeboxImpl {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        SongDAO songDAO = new SongDAO();
        List<Song> songList = songDAO.listOfSong();
        Jukebox jukebox = new Jukebox(songList);
        SongOperations songOperations = new SongOperations(scan);
        Jukebox.displayAllSong();
        List<Song> getSearchSong;
        List<Playlist> playlists;
        List<Song> songsInPlaylist;
        SongInPlaylistOperations inPlaylistOperations;
        String songName;
        int number;
        boolean flag=true;
        while (flag) {
            jukebox.displayFunctions();
            int userChoice = scan.nextInt();
            switch (userChoice) {
                case 1:
                    System.out.println("Enter song name");
                    scan.nextLine();
                    songName = scan.nextLine();
                    songName = songName.substring(0, 1).toUpperCase() + songName.substring(1);
                    try {
                        songOperations.playMusic(songName,songList);

                    } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 2:
                    Jukebox.displayAllSong();
                    System.out.println("Enter song number to start playing songs");
                    number = scan.nextInt();
                    try {
                        songOperations.play(number,songList);
                    } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 3:

                    scan.nextLine();
                    System.out.println("Enter playlist name ");
                    String playlistName=scan.nextLine();
                    try {
                         playlists= PlaylistDAO.listOfPlaylist();
                         PlaylistOperations playlistOperations=new PlaylistOperations(playlists,songList,scan);
                        int playlistId=playlistOperations.createPlaylist(playlistName);
                        System.out.println("Enter 1 to play a song\nEnter 2 to exit");
                        int playPlaylist=scan.nextInt();
                        switch (playPlaylist)
                        {
                            case 1:
                                songsInPlaylist= SongInPlaylistDAO.getPlaylistSong(playlistId,songList);
                                inPlaylistOperations=new SongInPlaylistOperations(songsInPlaylist);

                                if(!songsInPlaylist.isEmpty()) {
                                    inPlaylistOperations.playPlaylist(playlistId);
                                    System.out.println("Enter song no to play song");
                                    int num = scan.nextInt();
                                    songOperations.play(num, songsInPlaylist);
                                }
                                else {
                                    System.out.println("No song Available");
                                }
                                break;
                            case 2:
                                break;
                            default:
                                System.err.println("Invalid choice");
                        }

                    }catch(SQLException e)
                    {
                        e.printStackTrace();
                    } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 4:
                    scan.nextLine();
                    System.out.println("Search song by Artist/genre/title");
                    String getName = scan.nextLine();
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
                                songOperations.playMusic(songName,getSearchSong);
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
                case 5:
                    try {
                        while(true) {
                            playlists = PlaylistDAO.listOfPlaylist();
                            PlaylistOperations playlistOperations = new PlaylistOperations(playlists, songList, scan);
                            playlistOperations.displayPlaylist();
                            System.out.println("Enter 1 to play song\nEnter 2 to exit");
                            int choice= scan.nextInt();
                            if(choice==2)
                            {
                                break;
                            }
                            else {
                                System.out.println("Enter playlist Id");
                                int playlistId = scan.nextInt();
                                songsInPlaylist = SongInPlaylistDAO.getPlaylistSong(playlistId, songList);
                                inPlaylistOperations = new SongInPlaylistOperations(songsInPlaylist);
                                inPlaylistOperations.playPlaylist(playlistId);
                                System.out.println("enter song number");
                                int songNumber = scan.nextInt();
                                songOperations.play(songNumber, songsInPlaylist);
                            }

                        }
                    } catch (SQLException | UnsupportedAudioFileException | LineUnavailableException | IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 6:
                    try {
                        playlists=PlaylistDAO.listOfPlaylist();
                        PlaylistOperations playlistOperations=new PlaylistOperations(playlists,songList,scan);
                        playlistOperations.addSongToPlaylist();

                    }catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 7:
                    flag=false;
                    break;
                default:
                    System.err.println("Invalid choice");
                    break;
            }

        }

    }
}
