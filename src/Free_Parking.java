import java.io.BufferedWriter;
import java.io.IOException;

public class Free_Parking extends Square {

	public Free_Parking(int id) {
		super(id);
	}

	@Override
	void unique_main_func(Player player, Banker banker, BufferedWriter writer) throws IOException 
	{
		int count = player.getFree_park_counter();
		if (count == 0) 
		{
			player.setIn_free_park(true);
			writer.write(player.getId() + "\t" + String.valueOf(player.getDice()) + "\t" + player.getPosition() + "\t" + Player.Player_dict.get("Player 1").getMoney() + "\t" + Player.Player_dict.get("Player 2").getMoney() + "\t" + player.getId() + " went to free parking");
			writer.newLine();
		} 
		else 
		{
			player.setIn_jail(false);
			System.out.println(player.getId() + "\t" + String.valueOf(player.getDice()) + "\t" + player.getPosition() + "\t" + Player.Player_dict.get("Player 1").getMoney() + "\t" + Player.Player_dict.get("Player 2").getMoney() + "\t" + player.getId() + " in free parking " + " (count=" + count +")");
		}
	}
}
