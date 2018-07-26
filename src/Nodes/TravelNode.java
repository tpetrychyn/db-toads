package Nodes;

import org.dreambot.api.methods.Calculations;
import toadslegs.Main;
import toadslegs.Node;

public class TravelNode extends Node {

	public TravelNode(Main main) {
        super(main);
    }

    @Override
    public boolean validate() {
        return main.getLocalPlayer().getY() < 3380 
        		&& !Areas.gnomeGateArea.contains(main.getLocalPlayer());
    }

    @Override
    public int execute() {
    	Main.log("travel");
        main.getWalking().walk(Areas.gnomeGateArea.getRandomTile());
        return Calculations.random(861, 6402);
    }
}