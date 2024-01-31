package dungeon;

import java.util.Stack;

public class DungeonGenerator {

    private static final Theme[] THEMES = Theme.values();

    private static final int MINIMAL_FLOOR_COUNT = 5;

    private static final int MAXIMAL_FLOOR_COUNT = 5;

    private static final int MINIMAL_ROOM_COUNT = 3;

    private static final int MAXIMAL_ROOM_COUNT = 8;

    public static Dungeon create(){
        return create(MINIMAL_FLOOR_COUNT, MAXIMAL_FLOOR_COUNT, MINIMAL_ROOM_COUNT, MAXIMAL_ROOM_COUNT);
    }

    public static Dungeon create(int minimalFloorCount, int maximalFoorCount, int minimalRoomCount, int maximalRoomCount){
        return new Dungeon(generateFloors(minimalFloorCount, maximalFoorCount, minimalRoomCount, maximalRoomCount));
    }

    private static DungeonFloor[] generateFloors(int minimalFloorCount, int maximalFoorCount, int minimalRoomCount, int maximalRoomCount){
        DungeonFloor[] floors = new DungeonFloor[THEMES.length];
        
        for (int i = 0; i < floors.length; i++) {
            floors[i] = new DungeonFloor(THEMES[i], generateRooms(minimalRoomCount, maximalRoomCount));
        }

        return floors;
    }

    private static DungeonRoom[] generateRooms(int minimalRoomCount, int maximalRoomCount){
        int roomNumber = random(minimalRoomCount, maximalRoomCount);
        DungeonRoom[] rooms = new DungeonRoom[roomNumber];

        Stack<Vector2> vectors = new Stack<>();
        
        Vector2 crntVec2;
        RoomType crntType;
        
        vectors.addLast(new Vector2(0, 0));

        for(int i = 0; i < roomNumber - 1; i++){
            do{
                crntVec2 = randomNeighbors(vectors.lastElement());
            }while(vectors.contains(crntVec2));
            
            vectors.addLast(crntVec2);
        }

        for(int i = 0; i < vectors.size(); i++){            
            if(i != rooms.length - 1){
                crntType = RoomType.ENEMY;
            }else{
                crntType = RoomType.BOSS;
            }

            rooms[i] = new DungeonRoom(vectors.get(i), crntType);
        }

        return rooms;
    }

    private static Vector2 randomNeighbors(Vector2 position){
        int offset = randomBetween(-1, 1);
        if(Math.random() < 0.5){
            return new Vector2(position.x, position.y + offset);
        }
        return new Vector2(position.x + offset, position.y);
    }

    private static int randomBetween(int a, int b){
        if(Math.random() < 0.5) return a;
        return b;
    }

    private static int random(int min, int max){
        return (int)(Math.random() * (max - min + 1) + min);
    }
}
