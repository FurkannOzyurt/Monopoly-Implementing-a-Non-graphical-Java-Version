import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
	// Player creation	
	Player player_1 = new Player("Player 1",15000,1);
	Player player_2 = new Player("Player 2",15000,1);
	Player.Player_dict.put("Player 1", player_1);
	Player.Player_dict.put("Player 2", player_2);
	Banker banker = new Banker("Banker",100000);
	// Game table creation
	Game_Table.game_table_func();
	// File operations
	File file = new File(args[0]);
	Scanner reader = new Scanner(file);	
	BufferedWriter writer = new BufferedWriter(new FileWriter("monitoring.txt"));
	Command_Manager.command_manager_func(reader, player_1, player_2, writer, banker);
	reader.close();
	writer.close();
	}
}
