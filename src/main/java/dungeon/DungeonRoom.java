package dungeon;

public class DungeonRoom {
    
    protected Vector2 position;
    protected RoomType type;

    protected DungeonRoom(Vector2 position, RoomType type){
        this.position = position;
        this.type = type;
    }

    protected void print(){
        System.out.println("\t\t" + this);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "[position:" + position + ", type:" + type + "]";
    }
}
