package com.dagas.galaga.entities;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.dagas.core.DagasEntity;
import com.dagas.core.DagasGame;

public class PlayerShip extends DagasEntity {

	// Constants to be used in all ships
	private static final int FRAME_COLS = 1, FRAME_ROWS = 1;
	private static final int SHIP_WIDTH = 30;
	private static final int SHIP_HEIGHT = 30;

	public PlayerShip(int aX, int aY) {
		super("playerPlane.png", FRAME_COLS, FRAME_ROWS, 0.25f);
		this.x = aX;
		this.y = aY;

		this.width = SHIP_WIDTH;
		this.height = SHIP_HEIGHT;

		this.originX = this.width / 2;
		this.originY = this.height / 2;

		this.scaleX = 1;
		this.scaleY = 1;

		this.rotation = 0;
		this.color = Color.WHITE;
		this.status = DagasEntity.Status.FIXED;

	}

	public void render(DagasGame game, float screenTimeCounter, float delta) {

		// always showing the first frame. in the case of ship, it is the only frame
		TextureRegion currentFrame = this.animation.getKeyFrames()[0];

		game.batch.draw(currentFrame, (float) this.x, (float) this.y, (float) this.originX, (float) this.originY,
				(float) this.width, (float) this.height, this.scaleX, this.scaleY, this.rotation);
	}

}
