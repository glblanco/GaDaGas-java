package com.dagas.galaga.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.dagas.core.DagasGame;
import com.dagas.core.DagasScreen;
import com.dagas.galaga.entities.PlayerShip;

public class GameScreen extends DagasScreen {

	public Music galagaNewGameSong;
	public PlayerShip playerShip;

	public GameScreen(DagasGame game) {
		super(game);
		this.game.screenColor = Color.BLUE;
		this.galagaNewGameSong = Gdx.audio.newMusic(Gdx.files.internal("galagaNewGameSong.mp3"));
		this.playerShip = new PlayerShip();
	}

	@Override
	public void render(float delta) {
		super.render(delta);
		this.game.batch.begin();
		this.game.font.draw(game.batch, "GAME SCREEN", 0, 480);
		this.playerShip.render(this.game.batch);
		this.game.batch.end();
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void show() {
		this.galagaNewGameSong.play();
	}

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
	public void dispose() {
		super.dispose();
		this.playerShip.dispose(this.game.batch);
	}

}