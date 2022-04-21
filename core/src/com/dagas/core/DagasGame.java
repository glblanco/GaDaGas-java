package com.dagas.core;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class DagasGame extends Game {

	public SpriteBatch batch;
	public BitmapFont font;
	public Color screenColor;

	@Override
	public void create() {
		this.batch = new SpriteBatch();
		this.font = new BitmapFont(); // use libGDX's default Arial font
		this.screenColor = Color.BLACK; // default
	}

	@Override
	public void render() {
		// TODO Auto-generated method stub
		super.render();
	}

	@Override
	public void dispose() {
		super.dispose();
		batch.dispose();
		font.dispose();
	}
}
