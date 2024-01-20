package dungeon;

public class Dungeon {

    private static final Theme[] THEMES = Theme.values();

    private DungeonFloor[] floors;

    public Dungeon(){
        generateFloors();
    }

    public DungeonFloor[] getFloors() {
        return floors;
    }

    private void generateFloors(){
        floors = new DungeonFloor[THEMES.length];
        
        for (int i = 0; i < floors.length; i++) {
            floors[i] = new DungeonFloor(THEMES[i]);
        }
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
