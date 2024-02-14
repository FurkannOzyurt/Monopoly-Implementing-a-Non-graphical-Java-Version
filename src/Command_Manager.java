import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
// command operations
public class Command_Manager {
	static void command_manager_func(Scanner reader,Player player_1,Player player_2,BufferedWriter writer,Banker banker) throws IOException {
		while (reader.hasNext()) 
		{
			if (player_1.getMoney() > 0 && player_2.getMoney() > 0) 
			{
				ArrayList<String> line = new ArrayList<String>(Arrays.asList(reader.nextLine().split(";")));
				if (line.size() == 2) 
				{
					String player_str = line.get(0);
					Player player = Player.Player_dict.get(player_str); // player selection
					int dice = Integer.parseInt(line.get(1));
					
					player.setDice(dice);
					player.move(player.getDice(),player.isIn_jail(), player.isIn_free_park());
					// condition : if player pass go square
					if (player.getSum_of_position() > ((40 * (player.getComplated_tours() + 1))) + 1) {
						Square.Square_dict.get(1).unique_main_func(player, banker, writer);	
					}
					// square operations
					Square.Square_dict.get(player.getPosition()).unique_main_func(player, banker,writer);
					// condition : if player bankrupts
					if (player_1.getMoney() < 0 || player_2.getMoney() < 0) {
						Square.bankrupt_player(player, writer);
					}
				} 
				else 
				{
					Player.show(player_1, player_2, banker, writer);
				}
			} 
			else 
			{
				Player.show(player_1, player_2, banker, writer);
				break;
			}	
		}
	}
}