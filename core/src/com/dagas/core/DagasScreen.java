package com.dagas.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.ScreenUtils;

public abstract class DagasScreen implements Screen {

	public DagasGame game;
	public OrthographicCamera camera;
	
	public float screenTimeCounter;
	public Color screenColor;

	/*
	 * Constructor
	 */
	public DagasScreen(DagasGame aGame, Color aScreenColor) {
		this.game = aGame;

		// create the camera and the SpriteBatch
		this.camera = new OrthographicCamera();
		this.camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		this.screenTimeCounter = 0;
		this.screenColor = aScreenColor;
	}

	/*
	 * SCREEN INTERFACE METHODS
	 */

	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(float delta) {
		// In my pixelbook go , delta is around 0.01 and 0.02
		this.game.batch.setProjectionMatrix(camera.combined);
		this.camera.update();
		this.screenTimeCounter += delta;
		ScreenUtils.clear(this.screenColor);
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		this.game.batch.dispose();
	}

}
