package view;

import java.awt.Point;

import scene.GameScene;
import view.util.Subject;

public class GameView extends View {

    private static final int WIDTH = (int)(SCREEN_WIDTH * (2.0 / 3.0));

    private static final int HEIGHT = (int)(SCREEN_HEIGHT * (2.0 / 3.0));

    private static final String TITLE = "Dungeon Bizarre Adventure";
    
    private GameScene gameScene;

    public GameView(GameScene gameScene){
        this.gameScene = gameScene;
        gameScene.attach(this);
        init(WIDTH, HEIGHT);
    }

    @Override
    public String title() {
        return TITLE;
    }

    @Override
    public Point position() {
        return center();
    }

    @Override
    public void view() {
        add(new GameCanvas(gameScene));
    }

    @Override
    public void update(Subject subj) {
        refreshFrames();
    }

    @Override
    public void update(Subject subj, Object data) {
        // TODO Auto-generated method stub
        
    }
    
}
