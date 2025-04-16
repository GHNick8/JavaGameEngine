package cappuccinoextraplusengine.game;

import cappuccinoextraplusengine.engine.AbstractGame;
import cappuccinoextraplusengine.engine.GamePanel;
import cappuccinoextraplusengine.engine.Renderer;
import cappuccinoextraplusengine.engine.gfx.ImageTile;
import java.awt.event.KeyEvent;

public class GameManager extends AbstractGame {
    private ImageTile image;
    
    public GameManager() {
        image = new ImageTile("/res/threeformsPrev.png", 16, 16);
    }

    @Override
    public void update(GamePanel gamePanel, float dt) {
        if (gamePanel.getInput().isKeyDown(KeyEvent.VK_A)){
            // System.out.println("A was pressed!");
        }

        temp += dt * 20;

        if (temp > 3) {
            temp = 0;
        }
    }

    float temp = 0;

    @Override
    public void render(GamePanel gamePanel, Renderer renderer) {
        renderer.drawImageTile(image, gamePanel.getInput().getMouseX(), gamePanel.getInput().getMouseY(), (int)temp, 0);
    }
    
    public static void main(String[] args) {
        GamePanel gamePanel = new GamePanel(new GameManager());
        gamePanel.startGame();
    }
}
