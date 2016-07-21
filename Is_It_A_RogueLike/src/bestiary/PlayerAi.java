package bestiary;

import graphics.Tile;

public class PlayerAi extends CreatureAi {

	public PlayerAi(Creature creature) {
		super(creature);
	}
	
	public void onEnter(int x, int y, Tile tile){
	    if (tile.isGround()){
	        creature.setX(x);
	        creature.setY(y);
	    } else if (tile.isDiggable()) {
	        creature.dig(x, y);
	    }
	}

}
