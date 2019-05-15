package com.pwk.springboot.study.design_pattern.adapter;

public class MediaAdapter implements OldMediaPlayer {
    private AdvancedMediaPlayer advancedMediaPlayer;

    public MediaAdapter(String audioType) {
        if(audioType.equalsIgnoreCase("mp4"))
            advancedMediaPlayer = new Mp4Player();
        if(audioType.equalsIgnoreCase("Vlc"))
            advancedMediaPlayer = new VlcPlayer();
    }

    @Override
    public void play(String audioType, String fileName) {
        if(audioType.equalsIgnoreCase("mp4"))
            advancedMediaPlayer.playMp4(fileName);
        if(audioType.equalsIgnoreCase("vlc"))
            advancedMediaPlayer.playVlc(fileName);
    }
}
