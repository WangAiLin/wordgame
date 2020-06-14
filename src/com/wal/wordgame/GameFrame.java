package com.wal.wordgame;

import javax.swing.*;

public class GameFrame extends JFrame{

    public GameFrame(){
        this.setTitle("打字游戏");
        this.setSize(500,800);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
       GameFrame gf = new GameFrame();
       GamePanel gp = new GamePanel();
        gp.action();
        gf.add(gp);
        //设置窗体可见
        gf.setVisible(true);
        //面板聚焦
        gp.requestFocus();
        MySound sound = new MySound("/musics/weiwei.mp3");
        sound.loop();
    }


}
