import java.io.BufferedWriter;
import java.io.IOException;

public class Jail extends Square {

	public Jail(int id) {
		super(id);
	}
	
	@Override
	void unique_main_func(Player player, Banker banker, BufferedWriter writer) throws IOException 
	{
		int count = player.getJail_counter();
		if (count == 0) 
		{
			player.setIn_jail(true); // player is now in jail
			writer.write(player.getId() + "\t" + String.valueOf(player.getDice()) + "\t" + player.getPosition() + "\t" + Player.Player_dict.get("Player 1").getMoney() + "\t" + Player.Player_dict.get("Player 2").getMoney() + "\t" + player.getId() + " went to jail");
			writer.newLine();
			player.setJail_counter(count+1);
		} 
		else if (count == 1 || count == 2) 
		{
			writer.write(player.getId() + "\t" + String.valueOf(player.getDice()) + "\t" + player.getPosition() + "\t" + Player.Player_dict.get("Player 1").getMoney() + "\t" + Player.Player_dict.get("Player 2").getMoney() + "\t" + player.getId() + " in jail" + " (count=" + count +")");
			writer.newLine();
			player.setJail_counter(count+1);		
		}
		else 
		{
			player.setIn_jail(false); // player is not in jail now
			writer.write(player.getId() + "\t" + String.valueOf(player.getDice()) + "\t" + player.getPosition() + "\t" + Player.Player_dict.get("Player 1").getMoney() + "\t" + Player.Player_dict.get("Player 2").getMoney() + "\t" + player.getId() + " in jail" + " (count=" + count +")");
			writer.newLine();
			player.setJail_counter(0);
		}
	}
}
