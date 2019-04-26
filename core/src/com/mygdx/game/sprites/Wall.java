package com.mygdx.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class Wall {
    private static final int HEIGHT = 64;
    private int x;
    private int y;
    private Rectangle square;
    private Texture wall;

    public Wall (int x ,int y){
        wall=new Texture("wall.png");
        this.x=x;
        this.y=y;
        square = new Rectangle(x,y,HEIGHT,HEIGHT);
    }
    public Texture getTexture() {
        return wall;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public boolean collides(Rectangle player){
        return player.overlaps(square);
    }

    public void dispose() {
        wall.dispose();
    }
}
