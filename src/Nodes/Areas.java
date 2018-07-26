package Nodes;

import org.dreambot.api.methods.map.Area;
import org.dreambot.api.methods.map.Tile;

public class Areas {
	static Area gnomeGateArea = new Area(new Tile(2465, 3382), new Tile(2457, 3382), new Tile(2460, 3377), new Tile(2465, 3377));

    static Area treeEntrance = new Area(new Tile(2463, 3491), new Tile(2463, 3487), new Tile(2468, 3487), new Tile(2468, 3491));
    static Area treeMain = new Area(new Tile(2464, 3497), new Tile(2464, 3493), new Tile(2467, 3493), new Tile(2467, 3497));
    static Area bankArea = new Area(new Tile(2449, 3484, 1), new Tile(2449, 3482, 1));
}
