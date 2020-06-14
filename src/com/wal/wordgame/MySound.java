package com.wal.wordgame;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 * 音乐播放类
 */
public class MySound extends Thread {
    //音乐播放的对象
    Player player;
    //音乐的地址
    String musicPath;

    public MySound(String musicPath){
        this.musicPath = musicPath;
    }
    public MySound(){
    }

    public void paly(){
        try {
            //获取音乐文件
            player = new Player(MySound.class.getResourceAsStream(musicPath));
            player.play();
        } catch (JavaLayerException e) {
            e.printStackTrace();
        }
    }

    public void run(){
        while(true){
            paly();
        }
    }

    public void loop(){
        //调用start()方法启动线程，会调用run()里边的内容，进行循环播放
        start();
    }
}
