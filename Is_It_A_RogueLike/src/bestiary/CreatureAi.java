package bestiary;

import graphics.Tile;

public abstract class CreatureAi {

    protected Creature creature;

    public CreatureAi(Creature creature){
        this.creature = creature;
        this.creature.setAi(this);
    }

    /**
     * Evaluates the tile encountered and select an appropriate behaviour
     * 
     * @param x of the first 2D Array
     * @param y of the second 2D Array
     * @param tile encountered on enter
     */
    public abstract void onEnter(int x, int y, Tile tile);
}
