package com.dagas.galaga.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.dagas.core.DagasGame;
import com.dagas.core.DagasScreen;
import com.dagas.galaga.entities.AlienShipPurple;
import com.dagas.galaga.entities.Platoon;
import com.dagas.galaga.entities.PlayerShip;

public class GameScreen extends DagasScreen {

	public String debugTitle;
	public Music galagaNewGameSong;

	// actors
	public PlayerShip playerShip;
	public Platoon platoon;

	public GameScreen(DagasGame game) {
		super(game, Color.BLACK);
		this.galagaNewGameSong = Gdx.audio.newMusic(Gdx.files.internal("galagaNewGameSong.mp3"));
		this.playerShip = new PlayerShip(50, 50);
		this.platoon = new Platoon();
		this.debugTitle = "Game Screen";
	}

	@Override
	public void render(float delta) {
		super.render(delta);
		this.debugTitle = "Delta : " + delta;

		this.game.batch.begin();

		this.playerShip.render(this.game, this.screenTimeCounter, delta);
		this.platoon.render(this.game, this.screenTimeCounter, delta);

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
		this.playerShip.dispose();
		this.platoon.dispose();
	}

}