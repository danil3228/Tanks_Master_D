package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.TanksDemo;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = TanksDemo.WIDTH;
		config.height = TanksDemo.HEIGHT;
		config.title = TanksDemo.TITLE;
		new LwjglApplication(new TanksDemo(), config);
	}
}
