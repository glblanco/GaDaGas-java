package com.dagas.galaga.game;

import com.badlogic.gdx.graphics.Color;
import com.dagas.core.DagasGame;
import com.dagas.galaga.screens.MainMenuScreen;

public class GalagaGame extends DagasGame {

	@Override
	public void create() {
		super.create();
		this.screenWidth = 800; // for this game
		this.screenHeight = 480; // for this game
		this.screenColor = Color.WHITE; // for this game
		
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
