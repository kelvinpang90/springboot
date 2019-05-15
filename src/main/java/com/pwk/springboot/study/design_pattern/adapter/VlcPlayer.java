package com.pwk.springboot.study.design_pattern.adapter;

public class VlcPlayer implements AdvancedMediaPlayer {
    @Override
    public void playMp4(String fileName) {
        //do nothing
    }

    @Override
    public void playVlc(String fileName) {
        System.out.println("playing Vlc:"+fileName);
    }
}
