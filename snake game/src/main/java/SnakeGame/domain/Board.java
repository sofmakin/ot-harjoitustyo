/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SnakeGame.domain;

/**
 *
 * @author admin
 */
public class Board {
   public static int height;
   public static int width;
   public static int cornersize;

    public Board() {
    }

    public Board(int height, int width, int cornersize) {
        this.height = height;
        this.width = width;
        this.cornersize = cornersize;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = 20;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = 20;
    }

    public int getCornersize() {
        return cornersize;
    }

    public void setCornersize(int cornersize) {
        this.cornersize = 25;
    }
    
}
