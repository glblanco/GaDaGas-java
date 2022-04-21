package com.dagas.galaga.game;

import com.badlogic.gdx.graphics.Color;
import com.dagas.core.DagasGame;
import com.dagas.galaga.screens.MainMenuScreen;

public class GalagaGame extends DagasGame {

	@Override
	public void create() {
		super.create();
		this.screenColor = Color.BLACK; // for this game
		this.setScreen(new MainMenuScreen(this));
	}

	@Override
	public void render() {
		super.render(); // important!

	}

	@Override
	public void dispose() {
		super.dispose();
	}

	/* OTHER FUNCTIONS */

	/* GETTERS AND SETTERS */

}
