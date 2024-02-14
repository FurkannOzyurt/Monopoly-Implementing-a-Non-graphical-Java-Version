import java.io.BufferedWriter;
import java.io.IOException;

public class Go_To_Jail extends Square{

	public Go_To_Jail(int id) {
		super(id);
	}

	@Override
	void unique_main_func(Player player, Banker banker, BufferedWriter writer) throws IOException 
	{
		player.setSum_of_position(player.getSum_of_position() - 20);
		player.setPosition(11);
		Square.Square_dict.get(11).unique_main_func(player, banker, writer);
	}
}
