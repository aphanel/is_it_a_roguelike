package bestiary;

import java.awt.Color;

import graphics.World;

public class Creature {

    private World world;
    private int x;
    private int y;
    private char glyph;
    private Color color;
    private CreatureAi ai;
    
	public Creature(World world, char glyph, Color color) {
		super();
		this.world = world;
		this.glyph = glyph;
		this.color = color;
	}
	
	
	/**
	 * Access the world.dig method and transform a WALL into a FLOOR tile
	 * 
	 * @param wx of the first Array
	 * @param wy of the second Array
	 */
	public void dig(int wx, int wy) {
		world.dig(wx, wy);
	}

	/**
	 * Handles the creature's movements and check if should attack or not
	 * 
	 * @param mx movement on the x axis
	 * @param my movement on the y axis
	 */
	public void moveBy(int mx, int my){
		Creature other = world.creature(x+mx, y+my);
		  
	    if (other == null)
	        ai.onEnter(x+mx, y+my, world.tile(x+mx, y+my));
	    else
	        attack(other);
	}
	
	public void attack(Creature other){
	    world.remove(other);
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public char getGlyph() {
		return glyph;
	}

	public void setGlyph(char glyph) {
		this.glyph = glyph;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public CreatureAi getAi() {
		return ai;
	}

	public void setAi(CreatureAi ai) {
		this.ai = ai;
	}
	
}
