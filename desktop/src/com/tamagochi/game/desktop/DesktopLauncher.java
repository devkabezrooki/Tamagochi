package com.tamagochi.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.tamagochi.game.utils.Constants;
import com.tamagochi.game.TamagochiGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = Constants.TITLE;
		config.width = Constants.WIDTH;
		config.height = Constants.HEIGHT;
		new LwjglApplication(new TamagochiGame(), config);
	}
}
