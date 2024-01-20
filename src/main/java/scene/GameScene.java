package scene;

import dungeon.Dungeon;

public class GameScene {

    private Dungeon dungeon;
    
    public GameScene(){
        this.dungeon = new Dungeon();
    }

    public Dungeon getDungeon() {
        return dungeon;
    }

    public void start(){
        print();
    }

    public void print(){
        dungeon.print();
    }
}
