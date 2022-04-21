package com.dagas.galaga.entities;

import com.badlogic.gdx.Gdx;
import com.dagas.core.DagasEntity;
import com.dagas.core.DagasGame;

public class Platoon extends DagasEntity {
	public AlienShip[] platoonRow0;
	public AlienShip[] platoonRow1;
	public AlienShip[] platoonRow2;
	public AlienShip[] platoonRow3;
	public AlienShip[][] platoon;

	public Platoon() {
		super();
		this.initializePlatoon();
	}

	public void initializePlatoon() {
		// assuming ships size 40x40 plus 10 pixels between each ship
		// platton will hoover from 35 left to 375 right

		int i = 0;
		int j = 0;

		for (i = 0; i < 7; i++) {
			for (j = 0; j < 4; j++) {
				platoon[i][j] = new AlienShipPurple(i * 50, Gdx.graphics.getHeight() - (j * 50));
				platoon[i][j].status = DagasEntity.Status.ANIMATED;
			}
		}
	}

	@Override
	public void render(DagasGame game, float screenTimeCounter, float delta) {
		int i = 0;
		int j = 0;
		for (i = 0; i < 7; i++) {
			for (j = 0; j < 4; j++) {
				platoon[i][j].render(game, screenTimeCounter, delta);
			}
		}
	}

	@Override
	public void dispose() {
		super.dispose();
		int i = 0;
		int j = 0;
		for (i = 0; i < 7; i++) {
			for (j = 0; j < 4; j++) {
				platoon[i][j].dispose();
			}
		}
	}

}
