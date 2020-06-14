package com.wal.wordgame;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class GamePanel extends JPanel {

    //存放字母的集合 方便add 和 remove
    List<Word> listWords = new ArrayList<Word>();
    //播放音乐的类
    Clip clip;
    //音乐开关
    boolean isMusic;
    public GamePanel(){
        //设置面板的背景颜色
        this.setBackground(Color.BLACK);

        //不能播放.mp3格式的音乐
       /* try {
            clip = AudioSystem.getClip();
            //以流的形式获取资源
            AudioInputStream ais = AudioSystem.getAudioInputStream(
                    GamePanel.class.getResource(""));
            //打开音乐资源
            clip.open(ais);
            //开始播放只会播放一遍
            //clip.start();
            //循环播放
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }

    //开始
    public void action(){

        //按键适配器
        KeyAdapter keyAdapter = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                //获取键盘输入的字母
                char word = e.getKeyChar();
                //获取按键的数值
                int k = e.getKeyCode();
                //进行判断是否是空格
                if(k == KeyEvent.VK_SPACE){
                    //按空格时音乐播放着
                   /*if(isMusic){
                        isMusic= false;
                        //停止音乐
                        clip.stop();
                    }else{
                        isMusic= true;
                        clip.loop(Clip.LOOP_CONTINUOUSLY);
                    }*/
                }
                for(int i = 0;i<listWords.size(); i++){
                    //b:98 B:66 c:99 C67 进行大小写字母判断
                    if(word == listWords.get(i).getContent() || (word-32) == listWords.get(i).getContent()){
                            listWords.remove(i);
                            break;
                    }
                }

            }
        };

        //把适配器作为监听内容,为面板加按键监听
        this.addKeyListener(keyAdapter);

        new Thread(){
            @Override
            public void run() {
                while (true){
                    //出现字母
                    showWord();
                    //进行移动
                    removeWord();
                    try {
                        sleep(50);
                        //调用repaint会在进行调用paint
                        repaint();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }.start();
    }

    int index = 0;
    //创建字母
    public void showWord(){
        index++;
        //控制出现字母的速率
        if(index % 5==0){
            Word word = new Word();
            listWords.add(word);
        }
    }

    //移动字母
    public void removeWord(){
        for (int i=0;i<listWords.size();i++){
            int y = listWords.get(i).getY();
            y += 10;
            listWords.get(i).setY(y);
        }
    }


    //为每个字母进行装饰 调用一次 线程中使用repaint可以在调用
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for(int i = 0; i<listWords.size();i++) {
            Word word = listWords.get(i);
            //设置画笔
            g.setColor(word.getColor());
            g.setFont(new Font("楷体", Font.BOLD, 30));
            //画字母
            g.drawString(word.getContent()+"",word.getX(),word.getY());
        }
    }
}
