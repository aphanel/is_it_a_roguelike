package screens;

import java.awt.event.KeyEvent;

import asciiPanel.AsciiPanel;

	public interface Screen {

    /**
     * method taking an AsciiPanel object as parameter and used to handle the different outputs on the screens
     * 
     * @param terminal
     */
    public abstract void displayOutput(AsciiPanel terminal);

    /**
     * handles the different inputs of the user
     * 
     * @param key
     * @return Screen object. Either a new type of screen or the same 
     */
    public abstract Screen respondToUserInput(KeyEvent key);
    
}
