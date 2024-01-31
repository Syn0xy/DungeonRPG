package view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import dungeon.DungeonFloor;
import dungeon.DungeonRoom;
import dungeon.RoomType;
import dungeon.Vector2;
import scene.GameScene;
import scene.Player;

public class GameCanvas extends JPanel {

    private static final Color BACKGROUND_COLOR = Color.BLACK;

    private static final Color DUNGEON_ADVICE_COLOR = Color.YELLOW;

    private static final Color DUNGEON_ENEMY_COLOR = Color.RED;

    private static final Color DUNGEON_BOSS_COLOR = Color.MAGENTA;

    private static final Color PLAYER_COLOR = Color.BLUE;

    private GameScene gameScene;
    
    public GameCanvas(GameScene gameScene){
        this.gameScene = gameScene;
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
        drawFloor(g, gameScene.getCurrentFloor());
        drawPlayer(g, gameScene.getPlayer());
    }

    private void drawFloor(Graphics g, DungeonFloor floor){
        DungeonRoom[] rooms = floor.getRooms();

        for (int i = 0; i < rooms.length; i++) {
            drawRoom(g, rooms[i]);
        }
    }

    private void drawRoom(Graphics g, DungeonRoom room){
        Vector2 vec2 = room.getPosition();
        int width = getWidth();
        int height = getHeight();
        int sx = width / 8;
        int sy = height / 8;
        int px = (int)(sx * 1.25) * vec2.x + (width - sx) / 2;
        int py = (int)(sy * 1.25) * vec2.y + (height - sy) / 2;

        Color crntColor = Color.BLACK;

        switch (room.getType()) {
            case ADVICE:
                crntColor = DUNGEON_ADVICE_COLOR;
                break;
            
            case ENEMY:
                crntColor = DUNGEON_ENEMY_COLOR;
                break;
            
            case BOSS:
                crntColor = DUNGEON_BOSS_COLOR;
                break;
        
            default:
                break;
        }

        g.setColor(crntColor);
        g.fillRect(px, py, sx, sy);
    }

    private void drawPlayer(Graphics g, Player p){
        Vector2 vec2 = p.getPosition();
        
        int width = getWidth();
        int height = getHeight();
        int sx = width / 16;
        int sy = height / 16;
        int px = (int)(sx * 1.25) * vec2.x + (width - sx) / 2;
        int py = (int)(sy * 1.25) * vec2.y + (height - sy) / 2;

        g.setColor(PLAYER_COLOR);
        g.fillRect(px, py, sx, sy);
    }

}
