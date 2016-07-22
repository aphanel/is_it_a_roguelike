package screens;

import java.awt.event.KeyEvent;

import asciiPanel.AsciiPanel;
import bestiary.Creature;
import bestiary.CreatureFactory;
import graphics.World;
import graphics.WorldBuilder;

public class MapScreen implements Screen {
	
	private World world = null;
	private CreatureFactory creatureFactory;
	private Creature player;
    private int screenWidth;
    private int screenHeight;

	public MapScreen(){
        screenWidth = 80;
        screenHeight = 21;
        createWorld();
        creatureFactory = new CreatureFactory(getWorld());
        createCreatures(creatureFactory);
	}
	
	/**
	 * Initialize the world member of the MapScreen instance using the WorldBuilder methods
	 * 
	 */
	private void createWorld(){
        world = new WorldBuilder(90, 31)
              .makeCaves()
              .build();
    }

	@Override
	public void displayOutput(AsciiPanel terminal) {
		int left = getScrollX();
        int top = getScrollY();   
        displayTiles(terminal, left, top);
        terminal.writeCenter("-- press [escape] to lose or [enter] to win --", 22);

	}

	@Override
	public Screen respondToUserInput(KeyEvent key) {
        switch (key.getKeyCode()){
        case KeyEvent.VK_ESCAPE: return new GameOverScreen();
        case KeyEvent.VK_ENTER: return new EndScreen();       
        case KeyEvent.VK_LEFT:
        case KeyEvent.VK_H: player.moveBy(-1, 0); break;
        case KeyEvent.VK_RIGHT:
        case KeyEvent.VK_L: player.moveBy( 1, 0); break;
        case KeyEvent.VK_UP:
        case KeyEvent.VK_K: player.moveBy( 0,-1); break;
        case KeyEvent.VK_DOWN:
        case KeyEvent.VK_J: player.moveBy( 0, 1); break;
        case KeyEvent.VK_Y: player.moveBy(-1,-1); break;
        case KeyEvent.VK_U: player.moveBy( 1,-1); break;
        case KeyEvent.VK_B: player.moveBy(-1, 1); break;
        case KeyEvent.VK_N: player.moveBy( 1, 1); break;

        }
    
        return this;
	}
	
	/**
	 * Handles all the creatures creation
	 * 
	 * @param creatureFactory
	 */
	private void createCreatures(CreatureFactory creatureFactory){
	    player = creatureFactory.newPlayer();
	  
	    for (int i = 0; i < 8; i++){
	        creatureFactory.newKobold();
	    }
	}
	
	public int getScrollX() {
	    return Math.max(0, Math.min(player.getX() - screenWidth / 2, world.getWidth() - screenWidth));
	}
	
	public int getScrollY() {
	    return Math.max(0, Math.min(player.getY() - screenHeight / 2, world.getHeight() - screenHeight));
	}
	
	/**
	 * Handles the tiles output on the terminal. First, it loops over the 2D Array and outputs the world tiles.
	 * Then, it loops over all the creatures and outputs them. Complexity roughly O(n2+k)
	 * 
	 * @param terminal
	 * @param left integer calculated by getScrollX method
	 * @param top integer calculated by getScrollY method
	 */
	private void displayTiles(AsciiPanel terminal, int left, int top) {
	    for (int x = 0; x < screenWidth; x++){
	        for (int y = 0; y < screenHeight; y++){
	            int wx = x + left;
	            int wy = y + top;
	            terminal.write(world.glyph(wx, wy), x, y, world.color(wx, wy));
	        }
	    }
	    for (Creature c : world.getCreatures()) {
	    	if(c.getX()<left+screenWidth && c.getX()>=left && c.getY()<top+screenHeight && c.getY()>=top && c != null){
	                terminal.write(c.getGlyph(), c.getX() - left, c.getY() - top, c.getColor());	    		
	    	}
	    }
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}	

	public CreatureFactory getCreatureFactory() {
		return creatureFactory;
	}

	public void setCreatureFactory(CreatureFactory creatureFactory) {
		this.creatureFactory = creatureFactory;
	}

	public Creature getPlayer() {
		return player;
	}

	public void setPlayer(Creature player) {
		this.player = player;
	}

	public int getScreenWidth() {
		return screenWidth;
	}

	public void setScreenWidth(int screenWidth) {
		this.screenWidth = screenWidth;
	}

	public int getScreenHeight() {
		return screenHeight;
	}

	public void setScreenHeight(int screenHeight) {
		this.screenHeight = screenHeight;
	}

}
