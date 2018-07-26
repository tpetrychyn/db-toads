package Nodes;

import org.dreambot.api.methods.Calculations;
import org.dreambot.api.methods.map.Area;
import org.dreambot.api.methods.map.Tile;

import toadslegs.Main;
import toadslegs.Node;

public class ClickToads extends Node {
	
	Area frogArea = new Area(new Tile(2430, 3506), new Tile(2430, 3519), new Tile(2407, 3519), new Tile(2407, 3506));
	Area innerArea = new Area(new Tile(2418, 3511), new Tile(2421, 3511), new Tile(2424, 3506), new Tile(2419, 3506));
	
	public ClickToads(Main main) {
        super(main);
    }

    @Override
    public boolean validate() {
        return main.getInventory().isFull() && main.getInventory().contains(2150);
    }

    @Override
    public int execute() {
		main.getInventory().slotInteract(27, "Remove-legs");
		return Calculations.random(2, 42);
    }
}
