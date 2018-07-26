package Nodes;

import org.dreambot.api.methods.Calculations;
import org.dreambot.api.methods.map.Tile;

import toadslegs.Main;
import toadslegs.Node;

public class BankNode extends Node {
	Tile bankTile = new Tile(2449, 3482, 1);
    public BankNode(Main main) {
        super(main);
    }

    @Override
    public boolean validate() {
        return main.getInventory().isFull();
    }

    @Override
    public int execute() {
    	if (main.getLocalPlayer().getZ() == 0) {
    		if (!Areas.treeMain.contains(main.getLocalPlayer())) {
    			if (Areas.treeEntrance.getCenter().distance(main.getLocalPlayer()) > 7) {
    				main.getWalking().walk(Areas.treeEntrance.getRandomTile());
    			} else {
    				main.getGameObjects().closest("Tree Door").interact("Open");
    				Main.sleepUntil(() -> Areas.treeMain.contains(main.getLocalPlayer()) , 3500);
    			}
    		} else {
    			main.getGameObjects().closest("Ladder").interact("Climb-up");
    			Main.sleepUntil(() -> main.getLocalPlayer().getZ() == 1, 4500);
    		}
    	} else if (main.getLocalPlayer().getZ() == 1) {
    		if (bankTile.distance(main.getLocalPlayer()) > 12) {
    			main.getWalking().walk(bankTile);
    			return Calculations.random(2142, 3343);
    		}
    		
    		main.getBank().open();
			Main.sleepUntil(() -> main.getBank().isOpen(), 4500);
            main.getBank().depositAllItems();
            Main.sleepUntil(() -> main.getInventory().isEmpty(), 1500);
    	}
        return Calculations.random(842, 1343);
    }
}
