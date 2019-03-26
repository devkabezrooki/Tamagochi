package com.tamagochi.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class Tamagochi extends ApplicationAdapter {
	OrthographicCamera camera;
	SpriteBatch batch;
	Texture tamagochiImage;
	Texture backgroundImage;
	Music backgroundMusic;
	Sound mewSound;
	Rectangle tamagochi;
	Vector3 touchPos;

	@Override
	public void create () {
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480);
		batch = new SpriteBatch();

		tamagochiImage= new Texture("TamagochiCat.png");
		backgroundImage = new Texture( "BackgroundHouse.jpg" );

		mewSound = Gdx.audio.newSound(Gdx.files.internal("mew.wav"));
		backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("BackgroundMusic.mp3"));
		backgroundMusic.setLooping(true);
		backgroundMusic.play();

		tamagochi = new Rectangle();
		tamagochi.x = 800 / 2-220/2;
		tamagochi.y = 80;
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		camera.update();

		batch.setProjectionMatrix(camera.combined);

		batch.begin();
		batch.draw(backgroundImage, 0, 0);
		batch.draw(tamagochiImage , tamagochi.x, tamagochi.y);
		batch.end();

		if(Gdx.input.justTouched()){
			touchPos = new Vector3();
			touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			camera.unproject(touchPos);
			if(touchPos.x>tamagochi.x&&touchPos.x<tamagochi.x+220&&touchPos.y>tamagochi.y&&touchPos.x<tamagochi.y+220){
				mewSound.play();
			}
		}
	}

	public void pause() {
	}

	public void resume() {
	}

	@Override
	public void dispose () {
		batch.dispose();
		backgroundImage.dispose();
		tamagochiImage.dispose();
		backgroundMusic.dispose();
	}
}
