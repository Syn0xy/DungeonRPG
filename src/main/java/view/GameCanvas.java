package view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import dungeon.Dungeon;
import scene.GameScene;

public class GameCanvas extends JPanel {

    private static final Color BACKGROUND_COLOR = Color.BLACK;

    private static final Color DUNGEON_COLOR = Color.BLUE;

    private GameScene gameScene;

    private Dungeon dungeon;
    
    public GameCanvas(GameScene gameScene){
        this.gameScene = gameScene;
        this.dungeon = gameScene.getDungeon();
    }
 
    @Override
    public void paint(Graphics g) {
        clearScreen(g);
        draw(g);
    }

    private void clearScreen(Graphics g){
        g.setColor(BACKGROUND_COLOR);
        g.fillRect(0, 0, getWidth(), getHeight());
    }

    private void draw(Graphics g){
        g.setColor(DUNGEON_COLOR);
        g.fillRect(getWidth() / 4, getHeight() / 4, getWidth() / 2, getHeight() / 2);
    }

}
