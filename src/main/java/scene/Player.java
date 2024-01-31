package scene;
import dungeon.Vector2;

public class Player {

    private Vector2 position;

    public Player(){
        this.position = new Vector2();
    }

    public Vector2 getPosition() {
        return position;
    }

}
