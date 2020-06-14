package com.wal.wordgame;

import java.awt.*;
import java.util.Random;

public class Word {
    private char content;
    private int x;
    private int y;
    //颜色
    private Color color;

    //char类型范围:0-65535
    //A:65 Z:90
    //a:97 b:98
    public Word(){
        Random r = new Random();
        //[,)
        content = (char)(r.nextInt(26)+65);
        x = r.nextInt(500);
        y=0;
        color = new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255));
    }

    public char getContent() {
        return content;
    }

    public void setContent(char content) {
        this.content = content;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
