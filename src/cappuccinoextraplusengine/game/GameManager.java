package cappuccinoextraplusengine.game;

import cappuccinoextraplusengine.engine.AbstractGame;
import cappuccinoextraplusengine.engine.GamePanel;
import cappuccinoextraplusengine.engine.Renderer;

public class GameManager extends AbstractGame {
    
    public GameManager() {
        // Enter code.. 
    }

    @Override
    public void update(GamePanel gamePanel, float dt) {
        
    }

    @Override
    public void render(GamePanel gamePanel, Renderer renderer) {
        
    }
    
    public static void main(String[] args) {
        GamePanel gamePanel = new GamePanel(new GameManager());
        gamePanel.setWidth(350);
        gamePanel.setHeight(300);
        gamePanel.setScale(2f);
        gamePanel.startGame();
    }
}
