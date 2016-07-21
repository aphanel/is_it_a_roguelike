package bestiary;

import asciiPanel.AsciiPanel;
import graphics.World;

public class CreatureFactory {
	private World world;

	public CreatureFactory(World world) {
		super();
		this.world = world;
	}
	
	/**
	 * new Player factory method used to build a new player character
	 * 
	 * @return player
	 */
	public Creature newPlayer(){
	    Creature player = new Creature(world, '@', AsciiPanel.brightWhite);
	    world.addAtEmptyLocation(player);
	    new PlayerAi(player);
	    return player;
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}	
	
}
