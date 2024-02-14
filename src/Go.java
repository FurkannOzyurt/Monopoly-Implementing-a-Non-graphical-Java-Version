import java.io.BufferedWriter;
import java.io.IOException;

public class Go extends Square{
	private static final int toll = 200;

	public Go(int id) {
		super(id);
	}

	public int getToll() {
		return toll;
	}

	@Override
	void unique_main_func(Player player, Banker banker, BufferedWriter writer) throws IOException {
		player.setMoney(player.getMoney() + toll);
		banker.setMoney(banker.getMoney() - toll);
		player.setComplated_tours(player.getComplated_tours() + 1);
		if (player.getPosition() == 1 && player.isCard_activity() == false) {
			writer.write(player.getId() + "\t" + String.valueOf(player.getDice()) + "\t" + player.getPosition() + "\t" + Player.Player_dict.get("Player 1").getMoney() + "\t" + Player.Player_dict.get("Player 2").getMoney() + "\t" + player.getId() + " is in GO square");
			writer.newLine();
		}
	}
}
