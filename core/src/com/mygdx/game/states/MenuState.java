package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.TanksDemo;

public class MenuState extends State {
    private Texture playBtn;

    public MenuState(GameStateManager gsm) {
        super(gsm);
        camera.setToOrtho(false,TanksDemo.WIDTH/2,TanksDemo.HEIGHT/2);
        playBtn = new Texture("playbtn.png");
    }

    @Override
    protected void HandleInput() {
        if (Gdx.input.isTouched(0)){
            mouse.set(Gdx.input.getX(),Gdx.input.getY(),0);
            if (mouse.x < (TanksDemo.WIDTH/2+playBtn.getWidth()) && mouse.x > (TanksDemo.WIDTH/2-playBtn.getWidth()) &&
                mouse.y < (TanksDemo.HEIGHT/2 + playBtn.getHeight()) && mouse.y >(TanksDemo.HEIGHT/2 - playBtn.getHeight()))
                gms.set(new GameplayState(gms));
        }
    }

    @Override
    protected void update(float interval) {
        HandleInput();
    }

    @Override
    protected void render(SpriteBatch sb) {
        sb.setProjectionMatrix(camera.combined);
        sb.begin();
        sb.draw(playBtn, camera.position.x - playBtn.getWidth() / 2, camera.position.y);
        sb.end();
    }

    @Override
    protected void dispose() {
        playBtn.dispose();
    }
}
