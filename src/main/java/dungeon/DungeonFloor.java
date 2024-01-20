package dungeon;

public class DungeonFloor {

    private static final int MINIMAL_ROOM_NUMBER = 3;

    private static final int MAXIMAL_ROOM_NUMBER = 8;

    private Theme theme;

    private DungeonRoom[] rooms;

    protected DungeonFloor(Theme theme){
        this.theme = theme;
        generateRooms();
    }
    
    public DungeonRoom[] getRooms() {
        return rooms;
    }

    private void generateRooms(){
        int roomNumber = random(MINIMAL_ROOM_NUMBER, MAXIMAL_ROOM_NUMBER);
        rooms = new DungeonRoom[roomNumber];
        
        for (int i = 0; i < rooms.length; i++) {
            if(i == 0){
                rooms[i] = new DungeonRoom(Vec, null);
            }
        }
    }

    private Vector2 randomNeighbors(Vector2 position){
        return new Vector2(Math.random(-1, 1));
    }

    private int randomBetween(int a, int b){

    }

    private int random(int min, int max){
        return (int)(Math.random() * (max - min + 1) + min);
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
