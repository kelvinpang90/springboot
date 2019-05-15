package com.pwk.springboot.study.design_pattern.adapter;

public class AudioPlayer implements OldMediaPlayer {
    private MediaAdapter mediaAdapter;
    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("mp3"))
            System.out.println("playing mp3:"+fileName);
        else if(audioType.equalsIgnoreCase("mp4")||audioType.equalsIgnoreCase("vlc")) {
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType, fileName);
        }else
            System.out.println("Invalid audioType");
    }
}
