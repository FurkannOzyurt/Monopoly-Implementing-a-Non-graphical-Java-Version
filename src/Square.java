import java.io.BufferedWriter;
import java.io.IOException;
import java.util.HashMap;

abstract class Square {
	private int id;
	public static HashMap<Integer, Square> Square_dict = new HashMap<Integer, Square>() ;

	public Square(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	// every square does different functions
	abstract void unique_main_func(Player player, Banker banker,BufferedWriter writer) throws IOException;

	public void message(Player player, BufferedWriter writer) throws IOException {
		writer.write(player.getId() + "\t" + String.valueOf(player.getDice()) + "\t" + player.getPosition() + "\t" + Player.Player_dict.get("Player 1").getMoney() + "\t" + Player.Player_dict.get("Player 2").getMoney() + "\t");
	}
	
	public static void bankrupt_player(Player player, BufferedWriter writer) throws IOException {
		player.setMoney(0);
		if (player.isCard_activity() == false) 
		{
			writer.write(player.getId() + "\t" + String.valueOf(player.getDice()) + "\t" + player.getPosition() + "\t" + Player.Player_dict.get("Player 1").getMoney() + "\t" + Player.Player_dict.get("Player 2").getMoney() + "\t" + player.getId() + " goes bankrupt ");
		    writer.newLine();
		} 
		else 
		{
			writer.write(player.getId() + " goes bankrupt ");
		    writer.newLine();
		}
	}
}
