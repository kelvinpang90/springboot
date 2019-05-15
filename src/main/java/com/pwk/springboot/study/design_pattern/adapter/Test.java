package com.pwk.springboot.study.design_pattern.adapter;

public class Test {
    public static void main(String[] args){
        OldMediaPlayer player = new AudioPlayer();
        player.play("mp4","beyond the horizon");

        MediaAdapter adapter = new MediaAdapter("mp4");

    }
}
