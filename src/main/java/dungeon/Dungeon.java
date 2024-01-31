package dungeon;

public class Dungeon {

    private DungeonFloor[] floors;

    protected Dungeon(DungeonFloor[] floors){
        this.floors = floors;
    }

    public DungeonFloor getFloor(int floor) {
        return floors[floor];
    }

    public void print(){
        System.out.println(this);
        for (int i = 0; i < floors.length; i++) {
            floors[i].print();
        }
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "[floorsCount:" + floors.length + "]";
    }
}
