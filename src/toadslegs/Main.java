package toadslegs;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import org.dreambot.api.script.AbstractScript;
import Nodes.BankNode;
import Nodes.ClickToads;
import Nodes.GatherNode;
import Nodes.QuestNode;
import Nodes.ReturnFromBank;
import Nodes.TravelNode;
import Nodes.WalkNode;

import org.dreambot.api.script.Category;
import org.dreambot.api.script.ScriptManifest;
import org.dreambot.api.utilities.Timer;
import org.dreambot.api.wrappers.widgets.message.Message;
 
@ScriptManifest(category = Category.MONEYMAKING, name = "Toads Legs", author = "Taylor", version = 1)
public class Main extends AbstractScript {
    private Node[] nodes;
    private Timer timer;
    private int legs;

    @Override
    public void onMessage(Message message) {
    	if (message.getMessage().contains("You pull")) {
    		legs++;
    	}
    }
    
    @Override
    public void onStart() {
        nodes = new Node[] {
        		new TravelNode(this),
        		new QuestNode(this),
        		new ClickToads(this),
                new BankNode(this),
                new ReturnFromBank(this),
                new WalkNode(this),
                new GatherNode(this)
        };
        timer = new Timer();
    }

    @Override
    public int onLoop() {
        for (Node node : nodes) {
            if(node.validate()){
                return node.execute();
            }
        }

        //log("No Node Valid");
        return 300;
    }
    
    @Override
    public void onPaint(Graphics2D g) {
        g.setColor(Color.BLACK);
        Font font = new Font("Arial", Font.BOLD, 18);
        g.setFont(font);
        g.drawString("Toad's Legs 1.0", 10, 275);
        g.drawString("Runtime: " + timer.formatTime().toString(), 10, 295);
        g.drawString("Total Legs: " + legs, 10, 315);
        g.drawString("Per hour: " + legs * Math.floor(3600000L / timer.elapsed()) , 10, 335);
    }
    
}
