package screens;

import java.awt.event.KeyEvent;

import asciiPanel.AsciiPanel;

public class GameOverScreen implements Screen {

	public GameOverScreen() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void displayOutput(AsciiPanel terminal) {
        terminal.write("You lost.", 1, 1);
        terminal.writeCenter("-- press [enter] to restart --", 22);
	}

	@Override
	public Screen respondToUserInput(KeyEvent key) {
        return key.getKeyCode() == KeyEvent.VK_ENTER ? new MapScreen() : this;
	}

}
