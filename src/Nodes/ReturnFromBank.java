package Nodes;

import org.dreambot.api.methods.Calculations;
import org.dreambot.api.methods.map.Tile;

import toadslegs.Main;
import toadslegs.Node;

public class ReturnFromBank extends Node {
	
	Tile ladderTile = new Tile(2466, 3495, 1);
	
	public ReturnFromBank(Main main) {
        super(main);
    }

    @Override
    public boolean validate() {
    	return !main.getInventory().isFull() 
    			&& (Areas.treeMain.contains(main.getLocalPlayer())
    					|| main.getLocalPlayer().getZ() > 0);
    }

    @Override
    public int execute() {
    	if (main.getLocalPlayer().getZ() > 0) {
    		if (Areas.treeMain.getCenter().distance(main.getLocalPlayer()) > 12) {
    			main.getWalking().walk(Areas.treeMain.getRandomTile());
    			return Calculations.random(2142, 3343);
    		}
    		
			main.getGameObjects().getTopObjectOnTile(ladderTile).interact("Climb-down");
    		Main.sleepUntil(() -> main.getLocalPlayer().getZ() == 0, 4500);
    	} else {
    		main.getGameObjects().closest("Tree Door").interact("Open");
    		Main.sleepUntil(() -> Areas.treeEntrance.contains(main.getLocalPlayer()), 4500);
    	}
    	
    	return 1000;
    }
}
