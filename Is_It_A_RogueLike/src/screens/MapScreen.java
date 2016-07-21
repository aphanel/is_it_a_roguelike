package screens;

import java.awt.event.KeyEvent;

import asciiPanel.AsciiPanel;
import bestiary.Creature;
import bestiary.CreatureFactory;
import graphics.World;
import graphics.WorldBuilder;

public class MapScreen implements Screen {
	
	private World world;
	private CreatureFactory creatureFactory;
	private Creature player;
    private int screenWidth;
    private int screenHeight;

	public MapScreen(){
        screenWidth = 80;
        screenHeight = 21;
        createWorld();
        creatureFactory = new CreatureFactory(getWorld());
        player = creatureFactory.newPlayer();
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
        terminal.write(player.getGlyph(), player.getX() - left, player.getY() - top, player.getColor());
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
	
	public int getScrollX() {
	    return Math.max(0, Math.min(player.getX() - screenWidth / 2, world.getWidth() - screenWidth));
	}
	
	public int getScrollY() {
	    return Math.max(0, Math.min(player.getY() - screenHeight / 2, world.getHeight() - screenHeight));
	}
	
	private void displayTiles(AsciiPanel terminal, int left, int top) {
	    for (int x = 0; x < screenWidth; x++){
	        for (int y = 0; y < screenHeight; y++){
	            int wx = x + left;
	            int wy = y + top;

	            terminal.write(world.glyph(wx, wy), x, y, world.color(wx, wy));
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
