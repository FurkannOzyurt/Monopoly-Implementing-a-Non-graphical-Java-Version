import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Chance extends Action {
	public static ArrayList<String> chance_list = new ArrayList<String>();
	public static int chance_item_no = 0;
	
	public Chance(int id) {
		super(id);
	}
	// message for one tour
	public void message(Player player, int index, BufferedWriter writer) throws IOException {
		writer.write(player.getId() + "\t" + String.valueOf(player.getDice()) + "\t" + player.getPosition() + "\t" + Player.Player_dict.get("Player 1").getMoney() + "\t" + Player.Player_dict.get("Player 2").getMoney() + "\t" + player.getId() + " draw " + chance_list.get(index));
        writer.newLine();	
	}
	// message for more than one tour
	public void second_message(Player player, int index, BufferedWriter writer) throws IOException {
		writer.write(player.getId() + "\t" + String.valueOf(player.getDice()) + "\t" + player.getPosition() + "\t" + Player.Player_dict.get("Player 1").getMoney() + "\t" + Player.Player_dict.get("Player 2").getMoney() + "\t" + player.getId() + " draw " + chance_list.get(index) + " ");
	}
	// unique item actions
	@Override
	void item_action(Player player, Banker banker, BufferedWriter writer) throws IOException 
	{
		int index = chance_item_no;
		if (index % 6 == 0) 
		{
			player.setSum_of_position(player.getSum_of_position() + (41 - this.getId()));
			player.setPosition(1);
			player.setCard_activity(true);
			Square.Square_dict.get(1).unique_main_func(player, banker, writer);
			this.message(player, index, writer);
			player.setCard_activity(false);
		}
		else if (index % 6 == 1) 
		{
			if (this.getId() < 27) 
			{
				player.setSum_of_position(player.getSum_of_position() + (27-this.getId()));
				player.setPosition(27);
				player.setCard_activity(true);
				this.second_message(player, index, writer);
				Square.Square_dict.get(player.getPosition()).unique_main_func(player, banker, writer);
				player.setCard_activity(false);
			} 
			else 
			{
				player.setSum_of_position(player.getSum_of_position() - (this.getId() - 27));
				player.setPosition(27);
				player.setCard_activity(true);
				this.second_message(player, index, writer);
				Square.Square_dict.get(player.getPosition()).unique_main_func(player, banker, writer);
				player.setCard_activity(false);
			}
		}
		else if (index % 6 == 2) 
		{
			player.setSum_of_position(player.getSum_of_position() - 3);
			player.setPosition(player.getPosition() - 3);
			player.setCard_activity(true);
			this.second_message(player, index, writer);
			Square.Square_dict.get(player.getPosition()).unique_main_func(player, banker, writer);
			player.setCard_activity(false);
		}
		else if (index % 6 == 3) 
		{
			player.setMoney(player.getMoney() - 15);
			banker.setMoney(banker.getMoney() + 15);
			this.message(player, index, writer);
		}
		else if (index % 6 == 4) 
		{
			player.setMoney(player.getMoney() + 150);
			banker.setMoney(banker.getMoney() - 150);
			this.message(player, index, writer);
		}
		else 
		{
			player.setMoney(player.getMoney() + 100);
			banker.setMoney(banker.getMoney() - 100);
			this.message(player, index, writer);
		}
		chance_item_no += 1;
	}
}
