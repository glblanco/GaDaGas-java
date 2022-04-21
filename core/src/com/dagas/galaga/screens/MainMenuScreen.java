package com.dagas.galaga.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.dagas.core.DagasGame;
import com.dagas.core.DagasScreen;

public class MainMenuScreen extends DagasScreen {

	public MainMenuScreen(DagasGame aGame) {
		super(aGame, Color.BLACK);

	}

	@Override
	public void render(float delta) {
		super.render(delta);
		game.batch.begin();
		game.font.draw(game.batch, "Welcome to Galaga!!! ", 100, 150);
		game.font.draw(game.batch, "Tap anywhere to begin!", 100, 100);
		game.batch.end();

		if (Gdx.input.isTouched()) {
			game.setScreen(new GameScreen(game));
			dispose();
		}
	}

	// ...Rest of class omitted for succinctness.
	@Override
	public void hide() {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}