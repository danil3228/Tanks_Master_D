package com.mygdx.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.TanksDemo;

public class Tank {
    private static final int HEIGHT = 64;

    protected int x;
    protected int y;
    private Rectangle square;
    private Texture tankRight;
    private Texture tankLeft;
    private Texture tankUp;
    private Texture tankDown;

    public Tank (int x ,int y){
        tankRight=new Texture("tankright.png");
        tankLeft = new Texture("tankleft.png");
        tankDown = new Texture("tankdown.png");
        tankUp = new Texture("tankup.jpg");
        this.x=x;
        this.y=y;
        square = new Rectangle(x,y,HEIGHT,HEIGHT);
    }

    public Texture getTankRight() {return tankRight; }
    public Texture getTankLeft() {return  tankLeft; }
    public Texture getTankUp() {return tankUp; }
    public Texture getTankDown() {return tankDown; }

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

    public Rectangle getSquare(){return square;}

    public void update(double time){
        if (x < 0)
            x = 0;
        if (x > (TanksDemo.WIDTH - 50))
            x = TanksDemo.WIDTH -50;
        if (y < 0)
            y = 0;
        if (y > (TanksDemo.HEIGHT -50))
            y = TanksDemo.HEIGHT -50;
        square.setPosition(x,y);
    }
    public void dispose() {
        tankRight.dispose();
        tankUp.dispose();
        tankLeft.dispose();
        tankDown.dispose();
    }
}

