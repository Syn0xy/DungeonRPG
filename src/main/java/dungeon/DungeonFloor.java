package dungeon;

public class DungeonFloor {

    private Theme theme;

    private DungeonRoom[] rooms;

    protected DungeonFloor(Theme theme, DungeonRoom[] rooms){
        this.theme = theme;
        this.rooms = rooms;
    }

    public Theme getTheme() {
        return theme;
    }
    
    public DungeonRoom[] getRooms() {
        return rooms;
    }

    protected void print(){
        System.out.println("\t" + this);
        for (int i = 0; i < rooms.length; i++) {
            rooms[i].print();
        }
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "[theme:" + theme + ", roomsCount:" + rooms.length + "]";
    }
}
