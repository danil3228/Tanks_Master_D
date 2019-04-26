package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.TanksDemo;
import com.mygdx.game.sprites.Tank;
import com.mygdx.game.sprites.Wall;

public class GameplayState extends State {
    private Tank mainTank;
    private Wall testWall;
    private Texture arrowLeft;
    private Texture arrowRight;
    private Texture arrowUp;
    private Texture arrowDown;
    private char direction = 'U';

    public GameplayState(GameStateManager gsm) {
        super(gsm);
        mainTank = new Tank(200,200);
        testWall = new Wall(300,300);
        arrowLeft =new Texture("arrowleft.png");
        arrowDown = new Texture("arrowdown.png");
        arrowRight = new Texture("arrowright.png");
        arrowUp = new Texture("arrowup.png");
        camera.setToOrtho(false, TanksDemo.WIDTH, TanksDemo.HEIGHT);
    }

    @Override
    protected void HandleInput() {
        if (Gdx.input.isTouched(0)) {
            mouse.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            if (mouse.x < arrowLeft.getWidth() && mouse.y > (TanksDemo.HEIGHT-arrowLeft.getHeight())) {
                mainTank.setX(mainTank.getX() - 2);
                direction = 'L';
            }
            if (mouse.x < 256 && mouse.x > 128 && mouse.y > (TanksDemo.HEIGHT-arrowLeft.getHeight())) {
                mainTank.setX(mainTank.getX() + 2);
                direction = 'R';
            }
            if ((mouse.x > TanksDemo.WIDTH - 128) && (mouse.y > 256) && (mouse.y < 384)) {
                mainTank.setY(mainTank.getY() + 2);
                direction = 'U';
            }
            if ((mouse.x > TanksDemo.WIDTH - 128) && (mouse.y > (TanksDemo.HEIGHT - 128))) {
                mainTank.setY(mainTank.getY() - 2);
                direction = 'D';
            }
        }
    }

    @Override
    protected void update(float interval) {
        HandleInput();
        mainTank.update(interval);
        if (testWall.collides(mainTank.getSquare())){
            if (direction == 'R')
                mainTank.setX(mainTank.getX()-2);
            if (direction == 'L')
                mainTank.setX(mainTank.getX()+2);
            if (direction == 'U')
                mainTank.setY(mainTank.getY()-2);
            if (direction == 'D')
                mainTank.setY(mainTank.getY()+2);
        }
    }

    @Override
    protected void render(SpriteBatch sb) {
        sb.setProjectionMatrix(camera.combined);
        sb.begin();
        TankDraw(direction,sb);
        sb.draw(testWall.getTexture(),testWall.getX(),testWall.getY());
        sb.draw(arrowLeft, 0, 0);
        sb.draw(arrowRight, 128, 2);
        sb.draw(arrowDown, 800 - 128, 0);
        sb.draw(arrowUp, 800 - 128, 128);
        sb.end();
    }
    public void TankDraw(char direction , SpriteBatch batch){
        switch (direction) {
            case 'U':
                batch.draw(mainTank.getTankUp(), mainTank.getX(), mainTank.getY());
                break;
            case 'D':
                batch.draw(mainTank.getTankDown(), mainTank.getX(), mainTank.getY());
                break;
            case 'L':
                batch.draw(mainTank.getTankLeft(), mainTank.getX(), mainTank.getY());
                break;
            case 'R':
                batch.draw(mainTank.getTankRight(), mainTank.getX(), mainTank.getY());
                break;
        }
    }



    @Override
    protected void dispose() {
        arrowDown.dispose();
        arrowLeft.dispose();
        arrowRight.dispose();
        arrowUp.dispose();
        mainTank.dispose();
        testWall.dispose();
    }
}
