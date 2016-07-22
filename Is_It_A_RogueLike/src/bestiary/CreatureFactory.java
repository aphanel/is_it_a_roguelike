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
	
	/**
	 * new Kobold factory method used to build a new kobold monster
	 * 
	 * @return kobold
	 */
	public Creature newKobold(){
	    Creature kobold = new Creature(world, 'k', AsciiPanel.brightGreen);
	    world.addAtEmptyLocation(kobold);
	    new KoboldAi(kobold);
	    return kobold;
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}	
	
}
