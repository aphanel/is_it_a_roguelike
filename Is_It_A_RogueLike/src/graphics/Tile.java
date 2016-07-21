package graphics;

import java.awt.Color;

import asciiPanel.AsciiPanel;

public enum Tile {
    FLOOR((char)250, AsciiPanel.yellow),
    WALL((char)177, AsciiPanel.yellow),
    BOUNDS('x', AsciiPanel.brightBlack);

    private char glyph;
    private Color color;

    /**
     * A Tile object is the combination of an extended ASCII (IBM code 437) character and a color
     * 
     * @param glyph
     * @param color
     */
    Tile(char glyph, Color color){
        this.glyph = glyph;
        this.color = color;
    }
    
    
    /**
     * Check if the Tile is a diggable WALL
     * 
     * @return Boolean true if Tile is a WALL
     */
    public boolean isDiggable() {
        return this == Tile.WALL;
    }

    /**
     * Check if the Tile is ground
     * 
     * @return true if not WALL nor BOUNDS
     */
    public boolean isGround() {
        return this != WALL && this != BOUNDS;
    }
    
    public Color getColor() { 
    	return color; 
    }
    
    public char getGlyph() {
    	return glyph; 
    }
}
