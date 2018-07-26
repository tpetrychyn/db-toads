package Nodes;

import org.dreambot.api.methods.Calculations;
import org.dreambot.api.methods.map.Area;
import org.dreambot.api.methods.map.Tile;

import toadslegs.Main;
import toadslegs.Node;

public class WalkNode extends Node {
	
	Area frogArea = new Area(new Tile(2406, 3520), new Tile(2406, 3506), new Tile(2431, 3505), new Tile(2432, 3519));
	Area innerArea = new Area(new Tile(2418, 3511), new Tile(2421, 3511), new Tile(2424, 3506), new Tile(2419, 3506));
	
	public WalkNode(Main main) {
        super(main);
    }

    @Override
    public boolean validate() {
        return !frogArea.contains(main.getLocalPlayer())
        		&& !Areas.gnomeGateArea.contains(main.getLocalPlayer())
        		&& main.getLocalPlayer().getZ() == 0
        		&& !Areas.treeMain.contains(main.getLocalPlayer());
    }

    @Override
    public int execute() {
        main.getWalking().walk(innerArea.getRandomTile());
        return Calculations.random(1201, 6402);
    }
}