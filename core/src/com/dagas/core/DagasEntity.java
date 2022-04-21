package com.dagas.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public abstract class DagasEntity {

	// Enum used for the actor status
	public enum Status {
		FIXED, ANIMATED
	}

	// all the animation frames for this actor
	// so far, it is just 1 animation per actor
	// when i need more, will need to add something else here

	// all the definitions of how to show each frame
	public int x;
	public int y;
	public int originX;
	public int originY;
	public int height;
	public int width;
	public float scaleX;
	public float scaleY;
	public float rotation;
	public Color color;
	public Status status;

	// Used for Rendering images
	public Animation<TextureRegion> animation; // Must declare frame type (TextureRegion)
	public Texture spriteTexture;
	public int textureFrameCols;
	public int textureFrameRows;
	public float stateTime;

	/**
	 * Constructor for actors
	 * 
	 * @param aTextureFileName
	 */
	public DagasEntity(String aTextureFileName, int aTextureFrameCols, int aTextureFrameRows, int aX, int aY,
			int anOriginX, int anOriginY, int aWidth, int aHeight, float aScaleX, float aScaleY, float aRotation,
			Color aColor, Status aStatus, float aFrameDuration) {

		this.textureFrameCols = aTextureFrameCols;
		this.textureFrameRows = aTextureFrameRows;
		this.x = aX;
		this.y = aY;
		this.originX = anOriginX;
		this.originY = anOriginY;
		this.width = aWidth;
		this.height = aHeight;
		this.scaleX = aScaleX;
		this.scaleY = aScaleY;
		this.rotation = aRotation;
		this.color = aColor;
		this.status = aStatus;

		if (aTextureFileName != null) {
			this.spriteTexture = new Texture(Gdx.files.internal(aTextureFileName));

			// Use the split utility method to create a 2D array of TextureRegions. This is
			// possible because this sprite sheet contains frames of equal size and they are
			// all aligned.
			TextureRegion[][] tmp = TextureRegion.split(spriteTexture, spriteTexture.getWidth() / this.textureFrameCols,
					spriteTexture.getHeight() / this.textureFrameRows);

			// Place the regions into a 1D array in the correct order, starting from the top
			// left, going across first. The Animation constructor requires a 1D array.
			TextureRegion[] frames = new TextureRegion[this.textureFrameCols * this.textureFrameRows];
			int index = 0;
			for (int i = 0; i < this.textureFrameRows; i++) {
				for (int j = 0; j < this.textureFrameCols; j++) {
					frames[index++] = tmp[i][j];
				}
			}

			// Initialize the Animation with the frame interval and array of frames
			this.animation = new Animation<TextureRegion>(aFrameDuration, frames);
		}
		// Instantiate a SpriteBatch for drawing and reset the elapsed animation
		// time to 0
		this.stateTime = 0f;

	}

	public DagasEntity(String aTextureFileName, int aTextureFrameCols, int aTextureFrameRows,
			float aFrameIntervalForAnimation) {
		this(aTextureFileName, aTextureFrameCols, aTextureFrameRows, 0, 0, 0, 0, 0, 0, 1, 1, 0, Color.WHITE,
				Status.FIXED, aFrameIntervalForAnimation);
	}

	public DagasEntity() {
		this(null, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, Color.WHITE, Status.FIXED, 0);
	}

	public abstract void render(DagasGame game, float screenTimeCounter, float delta);

	public void dispose() {
		if (this.spriteTexture != null)
			this.spriteTexture.dispose();
	}
}
