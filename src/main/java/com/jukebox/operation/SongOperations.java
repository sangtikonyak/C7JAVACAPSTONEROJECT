package com.jukebox.operation;

import com.jukebox.data.Song;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class SongOperations {
  long currentFrame;
  Clip clip;
  AudioInputStream audioInputStream;
  String status;
  static String filePath;

   Scanner scan;

    public SongOperations(Scanner scan) {

        this.scan=scan;
    }



    public int musicFunctions() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        int c;
        while (true) {
            System.out.println("1. pause");
            System.out.println("2. resume");
            System.out.println("3. restart");
            System.out.println("4. next");
            System.out.println("5. prev");
            System.out.println("6. stop");
             c= scan.nextInt();
            switch (c) {
                case 1:
                    pause();
                    break;
                case 2:
                   resumeAudio();
                    break;
                case 3:
                    restart();
                    break;
                case 4:
                    next();
                    break;
                case 5:
                    prev();
                    break;
                case 6:
                    stop();
                    break;
                default:
                    System.err.println("Invalid choice");
                    break;
            }
            if (c==5||c==4||c==6)
            {
                break;
            }
        }
   return c;
    }

    public void playMusic(String name,List<Song>songList) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        String getName="";
        for (Song song : songList) {
            if (name.equals(song.getTitle()))
            {
                getName=song.getTitle();
                filePath=song.getFilepath();
                audioInputStream= AudioSystem.getAudioInputStream(new File(filePath));
                clip =AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
                status="play";
                int num=musicFunctions();
                if (num==4||num==5)
                {
                    System.out.println("cant play song again");
                }
                break;
            }
        }
        if (!name.equals(getName))
        {
            System.out.println("No song found");
        }
    }
    public void play(int number,List<Song>songList) throws UnsupportedAudioFileException, IOException, LineUnavailableException
    {
          for (int i = number; i < songList.size(); i++)
          {
              filePath=songList.get(i).getFilepath();
              audioInputStream=AudioSystem.getAudioInputStream(new File(filePath));
              clip=AudioSystem.getClip();
              clip.open(audioInputStream);
              clip.start();
              int num=this.musicFunctions();
              if (i== songList.size()-1 && num==4)
              {
                  throw new Error("No more Song Available");
              }
              if (num==4)
              {
                  continue;
              }
              if (num==5)
              {
                  i=i-2;
                  continue;
              }
              if(num==6)
              {
                  break;
              }

        }
    }
    public void play()
    {
        clip.start();
    }
    public void pause()
    {
        this.currentFrame=this.clip.getMicrosecondPosition();
        clip.stop();

    }
    public void resumeAudio() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        clip.close();
        resetAudioStream();
        clip.setMicrosecondPosition(currentFrame);
        this.play();
    }
    public void restart() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
     clip.start();
     clip.close();
     resetAudioStream();
     currentFrame=0L;
     clip.setMicrosecondPosition(0);
     this.play();
    }
    public void stop()
    {
    currentFrame=0L;
        clip.stop();
        clip.close();
    }
    public void next()
    {
        currentFrame=0L;

        clip.close();
    }
    public void prev()
    {
        currentFrame=0L;
        clip.stop();
        clip.close();
    }
public void resetAudioStream() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
    audioInputStream=AudioSystem.getAudioInputStream(new File(filePath));
    clip.open(audioInputStream);
}

}
