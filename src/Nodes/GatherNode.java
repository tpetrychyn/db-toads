package Nodes;

import org.dreambot.api.methods.Calculations;
import org.dreambot.api.methods.tabs.Tab;

import toadslegs.Main;
import toadslegs.Node;

public class GatherNode extends Node {

	public GatherNode(Main main) {
		super(main);
		// TODO Auto-generated constructor stub
	}

    @Override
    public boolean validate() {
        if (main.getLocalPlayer().isMoving()) {
            int n = Calculations.random(1, 200);
            if (n == 5) {
                main.getTabs().open(Tab.STATS);
                Main.sleep(Calculations.random(1560, 4909));
                main.getTabs().open(Tab.INVENTORY);
            }
            if (n == 6) {
                main.getTabs().open(Tab.QUEST);
                Main.sleep(Calculations.random(1560, 4909));
                main.getTabs().open(Tab.INVENTORY);
            }
            if (n == 7) {
            	main.getMouse().moveMouseOutsideScreen();
            	Main.sleep(Calculations.random(1234, 9543));
            }
            if (n == 8) {
            	Main.sleep(Calculations.random(2234, 5543));
            }
        }
            return !main.getLocalPlayer().isMoving();


    }

    @Override
    public int execute() {
    	int invCount = main.getInventory().fullSlotCount();
        main.getGroundItems().closest(2150).interact("Take");
        Main.sleepUntil(() -> main.getInventory().fullSlotCount() == invCount + 1, 3500);

        return Calculations.random(11, 444);
    }

}
