import java.io.BufferedWriter;
import java.io.IOException;
import java.util.HashMap;

abstract class Action extends Square {
	
	public static HashMap<Integer, Action> Action_dict = new HashMap<Integer, Action>() ;

	public Action(int id) {
		super(id);
	}
	// unique item actions
	abstract void item_action(Player player, Banker banker,BufferedWriter writer) throws IOException;

	@Override
	void unique_main_func(Player player, Banker banker, BufferedWriter writer) throws IOException {
		this.item_action(player,banker,writer);
	}
}
