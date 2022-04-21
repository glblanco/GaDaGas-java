package com.dagas.galaga.entities;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.CatmullRomSpline;
import com.badlogic.gdx.math.Vector2;
import com.dagas.core.DagasEntity;
import com.dagas.core.DagasGame;

public class AlienShipPurple extends AlienShip {

	// Constant rows and columns of the sprite sheet
	private static final int FRAME_COLS = 2, FRAME_ROWS = 1;
	private static final String SPRITE_FILE_NAME = "alienPurple.png";

	// used for flight demo
	private CatmullRomSpline<Vector2> path;
	private Vector2[] pathPoints;
	private ShapeRenderer shapeRenderer;
	float positionTimer;

	public AlienShipPurple(int aX, int aY) {
		super(SPRITE_FILE_NAME, FRAME_COLS, FRAME_ROWS, 0.25f);
		this.x = aX;
		this.y = aY;
		this.height = 40;
		this.width = 40;
		this.originX = this.width / 2;
		this.originY = this.height / 2;
		this.scaleX = 1;
		this.scaleY = 1;
		this.rotation = 0;
		this.color = Color.WHITE;
		this.status = DagasEntity.Status.FIXED;
		this.positionTimer = 0;

	}

	public void render(DagasGame game, float screenTimeCounter, float delta) {
		TextureRegion currentFrame = null;

		if (this.status == DagasEntity.Status.FIXED) {
			currentFrame = this.animation.getKeyFrames()[0];
		} else { // (this.status == DagasActor.Status.ANIMATED)
			currentFrame = this.animation.getKeyFrame(screenTimeCounter, true);
			game.batch.draw(currentFrame, (float) this.x, (float) this.y, (float) this.originX, (float) this.originY,
					(float) this.width, (float) this.height, this.scaleX, this.scaleY, this.rotation);
		}
	}

	@Override
	public void dispose() {
		super.dispose();
	}

	// storing code that helped me draw curves

	public void renderOld(DagasGame game, float screenTimeCounter, float delta) {

		// waypoints for the test path
		int waypointsCount = 9;
		Vector2[] waypoints = new Vector2[waypointsCount];
		waypoints[0] = new Vector2(0, 800);
		waypoints[1] = new Vector2(0, 800);
		waypoints[2] = new Vector2(200, 700);
		waypoints[3] = new Vector2(300, 600);
		waypoints[4] = new Vector2(250, 500);
		waypoints[5] = new Vector2(150, 500);
		waypoints[6] = new Vector2(100, 600);
		waypoints[7] = new Vector2(100, 700);
		waypoints[8] = new Vector2(100, 700);

		this.path = new CatmullRomSpline<Vector2>(waypoints, false);
		int k = 100; // increase k for more fidelity to the spline
		this.pathPoints = new Vector2[100];
		for (int i = 0; i < k; ++i) {
			this.pathPoints[i] = new Vector2();
			this.path.valueAt(this.pathPoints[i], ((float) i) / ((float) k - 1));
		}

		// this.positionTimer += delta;

		TextureRegion currentFrame = null;

		if (this.status == DagasEntity.Status.FIXED)
			currentFrame = this.animation.getKeyFrames()[0];
		else // (this.status == DagasActor.Status.ANIMATED)
			currentFrame = this.animation.getKeyFrame(screenTimeCounter, true);

		game.font.draw(game.batch, "Position Timer :" + positionTimer, 0, 800);

		if ((positionTimer / 10) <= 1) {
			this.status = DagasEntity.Status.FIXED;

			// Calculate next point based on timer
			Vector2 position = new Vector2();
			path.valueAt(position, positionTimer / 10);

			// Calculate orientation for the previous point
			Vector2 orientation = new Vector2();
			path.derivativeAt(orientation, positionTimer / 10);
			this.rotation = orientation.angle() - 90;

			// Calculate position normalizing by speed
			float speed = 1000;
			float positionTimerDelta = (delta * speed / path.spanCount) / orientation.len(); // formula copied from
																								// libgdx tutorial for
																								// curves
			this.positionTimer += positionTimerDelta;

			// draw the entity in the desired position and orientation
			game.batch.draw(currentFrame, (float) position.x, (float) position.y, (float) this.originX,
					(float) this.originY, (float) this.width, (float) this.height, this.scaleX, this.scaleY,
					this.rotation);

		} else if ((positionTimer / 10) > 1) {
			// entity in position
			this.status = DagasEntity.Status.ANIMATED;
			this.rotation = 0;

			Vector2 position = new Vector2();
			path.valueAt(position, 1);
			game.batch.draw(currentFrame, (float) position.x, (float) position.y, (float) this.originX,
					(float) this.originY, (float) this.width, (float) this.height, this.scaleX, this.scaleY,
					this.rotation);

		}

//		// draw path
//		shapeRenderer = new ShapeRenderer();
//		// shapeRenderer.setAutoShapeType(true);
//		int k = 100;
//		/* render() */
//		shapeRenderer.begin(ShapeType.Line);
//		for (int i = 0; i < k - 1; ++i) {
//			shapeRenderer.line(this.pathPoints[i], this.pathPoints[i + 1]);
//		}
//		shapeRenderer.end();

	}
}
