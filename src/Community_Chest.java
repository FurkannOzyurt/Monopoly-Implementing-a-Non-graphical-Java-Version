import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Community_Chest extends Action{
	public static ArrayList<String> community_chest_list = new ArrayList<String>();
	public static int community_chest_item_no = 0;
	
	public Community_Chest(int id) {
		super(id);
	}

	public void message(Player player, int index,BufferedWriter writer) throws IOException {
		writer.write(player.getId() + "\t" + String.valueOf(player.getDice()) + "\t" + player.getPosition() + "\t" + Player.Player_dict.get("Player 1").getMoney() + "\t" + Player.Player_dict.get("Player 2").getMoney() + "\t" + player.getId() + " draw " + community_chest_list.get(index));
        writer.newLine();	
    }
	
	@Override
	void item_action(Player player, Banker banker, BufferedWriter writer) throws IOException 
	{
        int index = community_chest_item_no;
		
		if (index % 11 == 0) 
		{
			player.setSum_of_position(player.getSum_of_position() + (41 - this.getId()));
			player.setPosition(1);
			player.setCard_activity(true);
			Square.Square_dict.get(1).unique_main_func(player, banker,writer);
			this.message(player, index,writer);
			player.setCard_activity(false);
		}
		else if (index % 11 == 1) 
		{
			player.setMoney(player.getMoney() + 75);
			this.message(player, index,writer);
		}
		else if (index % 11 == 2) 
		{
			player.setMoney(player.getMoney() - 50);
			banker.setMoney(banker.getMoney() + 50);
			this.message(player, index,writer);
		}
		else if (index % 11 == 3) 
		{
			if (player.getId() == "Player 1") 
			{
				Player.Player_dict.get("Player 1").setMoney(player.getMoney() + 10);
				Player.Player_dict.get("Player 2").setMoney(player.getMoney() - 10);
				this.message(player, index,writer);
			} 
			else 
			{
				Player.Player_dict.get("Player 2").setMoney(player.getMoney() + 10);
				Player.Player_dict.get("Player 1").setMoney(player.getMoney() - 10);
				this.message(player, index,writer);
			}
		}
		else if (index % 11 == 4) 
		{
			if (player.getId() == "Player 1") 
			{
				Player.Player_dict.get("Player 1").setMoney(player.getMoney() + 50);
				Player.Player_dict.get("Player 2").setMoney(player.getMoney() - 50);
				this.message(player, index,writer);
			} 
			else 
			{
				Player.Player_dict.get("Player 2").setMoney(player.getMoney() + 50);
				Player.Player_dict.get("Player 1").setMoney(player.getMoney() - 50);
				this.message(player, index,writer);
			}
		}
		else if (index % 11 == 5) 
		{
			player.setMoney(player.getMoney() + 20);
			banker.setMoney(banker.getMoney() - 20);
			this.message(player, index,writer);
		}
		else if (index % 11 == 6) 
		{
			player.setMoney(player.getMoney() + 100);
			banker.setMoney(banker.getMoney() - 100);
			this.message(player, index,writer);
		}
		else if (index % 11 == 7) 
		{
			player.setMoney(player.getMoney() - 100);
			banker.setMoney(banker.getMoney() + 100);
			this.message(player, index,writer);
		}
		else if (index % 11 == 8) 
		{
			player.setMoney(player.getMoney() - 50);
			banker.setMoney(banker.getMoney() + 50);
			this.message(player, index,writer);
		}
		else if (index % 11 == 9) 
		{
			player.setMoney(player.getMoney() + 100);
			banker.setMoney(banker.getMoney() - 100);
			this.message(player, index,writer);
		}
		else 
		{
			player.setMoney(player.getMoney() + 50);
			banker.setMoney(banker.getMoney() - 50);
			this.message(player, index,writer);
		}
		
		community_chest_item_no += 1 ;
	}
}
