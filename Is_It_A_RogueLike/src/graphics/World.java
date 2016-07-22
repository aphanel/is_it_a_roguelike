package graphics;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import bestiary.Creature;

public class World {
	
    private Tile[][] tiles;
    private int width;
    private int height;
    private List<Creature> creatures = null;

    public World(Tile[][] tiles){
        this.tiles = tiles;
        this.width = tiles.length;
        this.height = tiles[0].length;
        this.creatures = new ArrayList<Creature>();
    }
    
    /**
     * get a tile object in the 2D Tile object Array given its indexes x and y 
     * 
     * @param x The index of the first Array
     * @param y The index of the second Array
     * @return Tile object
     */
    public Tile tile(int x, int y){
        if (x < 0 || x >= width || y < 0 || y >= height)
            return Tile.BOUNDS;
        else
            return tiles[x][y];
    }
    
    /**
     * get the glyph of a given tile in the 2D Array
     * 
     * @param x The index of the first Array
     * @param y The index of the second Array
     * @return char glyph of the Tile object
     */
    public char glyph(int x, int y){
        return tile(x, y).getGlyph();
    }

    /**
     * get the color of a given tile in the 2D Array
     * 
     * @param x The index of the first Array
     * @param y The index of the second Array
     * @return color of the Tile object
     */
    public Color color(int x, int y){
        return tile(x, y).getColor();
    }
        
    /**
     * Transform the given Tile of the 2D Array into a FLOOR tile
     * 
     * @param x The index of the first Array
     * @param y The index of the second Array
     */
    public void dig(int x, int y) {
        if (tile(x,y).isDiggable())
            tiles[x][y] = Tile.FLOOR;
    }

	/**
	 * Loop over the world map coordinates randomly until a GROUND tile is found
	 * then place the given Creature there.
	 * 
	 * @param creature
	 */
	public void addAtEmptyLocation(Creature creature){
	    int x;
	    int y;

	    do {
	        x = (int)(Math.random() * width);
	        y = (int)(Math.random() * height);
	    }
	    while (!tile(x,y).isGround()|| creature(x,y) != null);

	    creature.setX(x);
	    creature.setY(y);
	    creatures.add(creature);
	}
	
	/**
	 * Loop over the creatures List and check if one of these is at the location (x, y)
	 * 
	 * @param x The index of the first Array
	 * @param y The index of the second Array
	 * @return Creature object or null if not found
	 */
	public Creature creature(int x, int y){
	    for (Creature c : creatures){
	        if (c.getX() == x && c.getY() == y)
	            return c;
	    }
	    return null;
	}
	
	/**
	 * Remove a creature from the creatures List object
	 * 
	 * @param other A creature object
	 */
	public void remove(Creature other) {
	    creatures.remove(other);
	}

	public Tile[][] getTiles() {
		return tiles;
	}

	public void setTiles(Tile[][] tiles) {
		this.tiles = tiles;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public List<Creature> getCreatures() {
		return creatures;
	}

	public void setCreatures(List<Creature> creatures) {
		this.creatures = creatures;
	}

}
