import java.io.BufferedWriter;
import java.io.IOException;

public class Tax extends Square{
	private static final int tax = 100;

	public Tax(int id) {
		super(id);
	}

	public int getTax() {
		return tax;
	}

	@Override
	void unique_main_func(Player player, Banker banker, BufferedWriter writer) throws IOException {
		player.setMoney(player.getMoney() - tax);
		banker.setMoney(banker.getMoney() + tax);
		this.message(player, writer);
	}

	@Override
	public void message(Player player, BufferedWriter writer) throws IOException {
		if (player.isCard_activity() == false) 
		{
			writer.write(player.getId() + "\t" + String.valueOf(player.getDice()) + "\t" + player.getPosition() + "\t" + Player.Player_dict.get("Player 1").getMoney() + "\t" + Player.Player_dict.get("Player 2").getMoney() + "\t" + player.getId() + " paid Tax");
	        writer.newLine();
		} 
		else 
		{
			writer.write(player.getId() + " paid Tax");
	        writer.newLine();
		}
	}
}
