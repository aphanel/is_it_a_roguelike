package graphics;

import java.awt.Color;

public class World {
	
    private Tile[][] tiles;
    private int width;
    private int height;

    public World(Tile[][] tiles){
        this.tiles = tiles;
        this.width = tiles.length;
        this.height = tiles[0].length;
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

}