package com.mygdx.game.states;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

//Шаблон окна, наследуя его будем делать остальные окна
public abstract class State {
    protected OrthographicCamera camera;
    protected Vector3 mouse;
    protected GameStateManager gms; //управлет окнами, тот стек про кот я гооворил

    public State (GameStateManager gsm){
        this.gms = gsm;
        mouse = new Vector3();
        camera = new OrthographicCamera();
    }

    protected abstract void HandleInput(); //Обработка нажатий
    protected abstract void update(float interval); //Обновление экрана каждые interval времени
    protected abstract void render(SpriteBatch sb); //Рисование
    protected abstract void dispose();

}
