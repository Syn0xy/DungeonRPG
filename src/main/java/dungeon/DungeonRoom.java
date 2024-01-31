package dungeon;

public class DungeonRoom {
    
    private Vector2 position;

    private RoomType type;

    protected DungeonRoom(Vector2 position, RoomType type){
        this.position = position;
        this.type = type;
    }
    
    public Vector2 getPosition() {
        return position;
    }

    public RoomType getType() {
        return type;
    }

    protected void print(){
        System.out.println("\t\t" + this);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "[position:" + position + ", type:" + type + "]";
    }
}
