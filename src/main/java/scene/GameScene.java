package scene;

import dungeon.Dungeon;
import dungeon.DungeonFloor;
import dungeon.DungeonGenerator;
import view.util.Subject;

public class GameScene extends Subject {

    private Dungeon dungeon;

    private Player player;

    private int currentFloor;

    private int currentRoom;
    
    public GameScene(){
        this.dungeon = DungeonGenerator.create();
        this.player = new Player();
        this.currentFloor = 0;
        this.currentRoom = 0;
    }

    public DungeonFloor getCurrentFloor() {
        return dungeon.getFloor(currentFloor);
    }

    public Player getPlayer() {
        return player;
    }

    public void start(){
        print();
        notifyObservers();
    }

    public void print(){
        dungeon.print();
    }
}
