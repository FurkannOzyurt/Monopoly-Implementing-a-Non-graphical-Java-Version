import java.util.HashMap;

public class Company extends Property{
	public static HashMap<Integer, Property> Company_dict = new HashMap<Integer, Property>() ;
	
	public Company(int id, String name, int cost) {
		super(id, name, cost);
	}

	@Override
	public void get_a_lease(Player player) 
	{
		int rent;
		if (player.getId() == "Player 1") 
		{
			rent = 4 * player.getDice();
			Player.Player_dict.get("Player 1").setMoney(Player.Player_dict.get("Player 1").getMoney() - rent);
			Player.Player_dict.get("Player 2").setMoney(Player.Player_dict.get("Player 2").getMoney() + rent);
		} 
		else 
		{
			rent = 4 * player.getDice();
			Player.Player_dict.get("Player 2").setMoney(Player.Player_dict.get("Player 1").getMoney() - rent);
			Player.Player_dict.get("Player 1").setMoney(Player.Player_dict.get("Player 2").getMoney() + rent);
		}
	}
}
