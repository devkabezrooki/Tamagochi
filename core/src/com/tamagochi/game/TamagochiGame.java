package com.tamagochi.game;

import com.badlogic.gdx.Game;
import com.tamagochi.game.screens.GameScreen;

public class TamagochiGame extends Game {

	public void create() {
		setScreen(new GameScreen(this));
	}

	public void render() {
		super.render();
	}

	public void dispose() {
		super.dispose();
	}
}
