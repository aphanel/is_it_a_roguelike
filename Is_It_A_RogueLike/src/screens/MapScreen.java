package screens;

import java.awt.event.KeyEvent;

import asciiPanel.AsciiPanel;

public class MapScreen implements Screen {

	public MapScreen() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void displayOutput(AsciiPanel terminal) {
        terminal.write("You are having fun.", 1, 1);
        terminal.writeCenter("-- press [escape] to lose or [enter] to win --", 22);

	}

	@Override
	public Screen respondToUserInput(KeyEvent key) {
        switch (key.getKeyCode()){
        case KeyEvent.VK_ESCAPE: return new GameOverScreen();
        case KeyEvent.VK_ENTER: return new EndScreen();
        }
    
        return this;
	}

}
