package com.dagas.core;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.ScreenUtils;
import com.dagas.galaga.entities.PlayerShip;

public abstract class DagasScreen implements Screen {

	public DagasGame game;
	public OrthographicCamera camera;
	public PlayerShip playerShip;

	/*
	 * Constructor
	 */
	public DagasScreen(DagasGame aGame) {
		this.game = aGame;

		// create the camera and the SpriteBatch
		this.camera = new OrthographicCamera();
		this.camera.setToOrtho(false, this.game.screenWidth, this.game.screenHeight);

		this.playerShip = new PlayerShip();

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

		ScreenUtils.clear(this.game.screenColor);

		this.game.batch.setProjectionMatrix(camera.combined);

		this.camera.update();
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
		// TODO Auto-generated method stub

	}

}
