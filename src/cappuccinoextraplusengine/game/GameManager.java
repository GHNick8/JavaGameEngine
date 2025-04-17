package cappuccinoextraplusengine.game;

import cappuccinoextraplusengine.engine.AbstractGame;
import cappuccinoextraplusengine.engine.GamePanel;
import cappuccinoextraplusengine.engine.Renderer;
import cappuccinoextraplusengine.engine.audio.SoundClip;
import cappuccinoextraplusengine.engine.gfx.Image;
import cappuccinoextraplusengine.engine.gfx.ImageTile;
import java.awt.event.KeyEvent;

public class GameManager extends AbstractGame {
    private final ImageTile image;
    private final Image image2;
    private final SoundClip clip;
    
    public GameManager() {
        image = new ImageTile("/res/test.png", 16, 16);
        image2 = new Image("/res/test2.png");
        image2.setAlpha(true);
        clip = new SoundClip("/res/audio/laser.wav");
        // Set volume 
        clip.setVolume(-20);
    }

    public void reset() {

    }

    @Override
    public void update(GamePanel gamePanel, float dt) {
        if (gamePanel.getInput().isKeyDown(KeyEvent.VK_A)){
            // System.out.println("A was pressed!");
            clip.play();
        }

        temp += dt * 20;

        if (temp > 3) {
            temp = 0;
        }
    }

    float temp = 0;

    @Override
    public void render(GamePanel gamePanel, Renderer renderer) {
        renderer.drawImageTile(image, gamePanel.getInput().getMouseX() - 32, gamePanel.getInput().getMouseY() - 32, (int)temp, 0);
        renderer.drawImage(image2, 10, 10);
        // renderer.setzDepth(Integer.MAX_VALUE);
        // renderer.drawFillRect(gamePanel.getInput().getMouseX() - 16, gamePanel.getInput().getMouseY() - 16, 32, 32, 0xffffccff);
    }
    
    public static void main(String[] args) {
        GamePanel gamePanel = new GamePanel(new GameManager());
        gamePanel.setWidth(200);
        gamePanel.setHeight(200);
        gamePanel.setScale(2f);
        gamePanel.startGame();
    }
}
