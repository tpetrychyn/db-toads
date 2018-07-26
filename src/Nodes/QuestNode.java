package Nodes;

import org.dreambot.api.methods.Calculations;
import toadslegs.Main;
import toadslegs.Node;

public class QuestNode extends Node {
	
	
    public QuestNode(Main main) {
        super(main);
    }

    @Override
    public boolean validate() {
    	return Areas.gnomeGateArea.contains(main.getLocalPlayer());
    }

    @Override
    public int execute() {
    	Main.log("Quest");
    	main.getGameObjects().closest("Gate").interact("Open");
    	Main.sleepUntil(() -> main.getDialogues().inDialogue(), 4500);
    	if (main.getDialogues().inDialogue()) {
    		Main.sleep(Calculations.random(1101, 3202));
            main.getDialogues().spaceToContinue();
            Main.sleep(Calculations.random(1401, 4202));
            main.getDialogues().spaceToContinue();
            Main.sleep(Calculations.random(1301, 6402));
            main.getDialogues().spaceToContinue();
            Main.sleep(Calculations.random(1001, 5302));
            main.getDialogues().chooseOption(2);
            Main.sleep(Calculations.random(1201, 4402));
            main.getDialogues().spaceToContinue();
            Main.sleep(Calculations.random(1601, 3552));
            main.getDialogues().spaceToContinue();
            
            Main.sleep(10000); // lift box timeout
            
            Main.sleep(Calculations.random(1601, 3552));
            main.getDialogues().spaceToContinue();
        }
        return 600;
    }
}