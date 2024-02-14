import java.util.HashMap;

public class Railroad extends Property {
	public static HashMap<Integer, Property> Railroads_dict = new HashMap<Integer, Property>();
	
	public Railroad(int id, String name, int cost) {
		super(id, name, cost);
	}

	@Override
	public void get_a_lease(Player player) 
	{
		int other_owned_railroads = 0;
		int rent;
		if (player.getId() == "Player 1") 
		{
			// finding railroads the other player has
			for (Object station : Player.Player_dict.get("Player 2").getProperty_list())
			{
			  if (station instanceof Railroad)
			  {
			    other_owned_railroads ++;
			  }
			}
			rent = 25 * other_owned_railroads;
			Player.Player_dict.get("Player 1").setMoney(Player.Player_dict.get("Player 1").getMoney() - rent);
			Player.Player_dict.get("Player 2").setMoney(Player.Player_dict.get("Player 2").getMoney() + rent);
		} 
		else 
		{
			// finding railroads the other player has
			for (Object station : Player.Player_dict.get("Player 1").getProperty_list())
			{
			  if (station instanceof Railroad)
			  {
			    other_owned_railroads ++;
			  }
			}
			rent = 25 * other_owned_railroads;
			Player.Player_dict.get("Player 2").setMoney(Player.Player_dict.get("Player 1").getMoney() - rent);
			Player.Player_dict.get("Player 1").setMoney(Player.Player_dict.get("Player 2").getMoney() + rent);
		}
	}
}
