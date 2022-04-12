package com.dagas.galaga.entities;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class PlayerShip {

	// Constant rows and columns of the sprite sheet
	private static final int FRAME_COLS = 1, FRAME_ROWS = 1;

	// Objects used
	Animation<TextureRegion> animation; // Must declare frame type (TextureRegion)
	Texture spriteTexture;
	SpriteBatch spriteBatch;

	// A variable for tracking elapsed time for the animation
	float stateTime;

	public PlayerShip() {

		// Load the sprite sheet as a Texture
		this.spriteTexture = new Texture(Gdx.files.internal("playerPlane.png"));

		// Use the split utility method to create a 2D array of TextureRegions. This is
		// possible because this sprite sheet contains frames of equal size and they are
		// all aligned.
		TextureRegion[][] tmp = TextureRegion.split(spriteTexture, spriteTexture.getWidth() / FRAME_COLS,
				spriteTexture.getHeight() / FRAME_ROWS);

		// Place the regions into a 1D array in the correct order, starting from the top
		// left, going across first. The Animation constructor requires a 1D array.
		TextureRegion[] frames = new TextureRegion[FRAME_COLS * FRAME_ROWS];
		int index = 0;
		for (int i = 0; i < FRAME_ROWS; i++) {
			for (int j = 0; j < FRAME_COLS; j++) {
				frames[index++] = tmp[i][j];
			}
		}

		// Initialize the Animation with the frame interval and array of frames
		animation = new Animation<TextureRegion>(0.25f, frames);

		// Instantiate a SpriteBatch for drawing and reset the elapsed animation
		// time to 0
		spriteBatch = new SpriteBatch();
		stateTime = 0f;
	}

	public void render(SpriteBatch spriteBatch) {
		// Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // Clear screen
		stateTime += Gdx.graphics.getDeltaTime(); // Accumulate elapsed animation time

		// Get current frame of animation for the current stateTime
		TextureRegion currentFrame = animation.getKeyFrame(stateTime, true);
		spriteBatch.draw(currentFrame, 50, 50); // Draw current frame at (50, 50)
	}

	public void dispose(SpriteBatch spriteBatch) { // SpriteBatches and Textures must always be disposed
		spriteBatch.dispose();
		spriteTexture.dispose();
	}

}
