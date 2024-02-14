import java.util.HashMap;

public class Land extends Property {
	public static HashMap<Integer, Property> Land_dict = new HashMap<Integer, Property>();

	public Land(int id, String name, int cost) {
		super(id, name, cost);
	}

	@Override
	public void get_a_lease(Player player) 
	{
		int land_rent;
		
		if (player.getId() == "Player 1") 
		{
			if (this.getCost() <= 2000) 
			{
				land_rent = (int) (this.getCost() * 0.4);
			}
			else if (this.getCost() <= 3000) 
			{
				land_rent = (int) (this.getCost() * 0.3);
			}
			else 
			{
				land_rent = (int) (this.getCost() * 0.35);
			}
			
			if (player.getMoney() >= land_rent) 
			{
				Player.Player_dict.get("Player 1").setMoney(Player.Player_dict.get("Player 1").getMoney() - land_rent);
				Player.Player_dict.get("Player 2").setMoney(Player.Player_dict.get("Player 2").getMoney() + land_rent);
			} 
			else 
			{
				Player.Player_dict.get("Player 1").setMoney(Player.Player_dict.get("Player 1").getMoney() - land_rent);
			}
		} 
		else 
		{
			if (this.getCost() <= 2000) 
			{
				land_rent = (int) (this.getCost() * 0.4);
			}
			else if (this.getCost() <= 3000) 
			{
				land_rent = (int) (this.getCost() * 0.3);
			}
			else 
			{
				land_rent = (int) (this.getCost() * 0.35);
			}
			
			if (player.getMoney() >= land_rent) 
			{
				Player.Player_dict.get("Player 2").setMoney(Player.Player_dict.get("Player 2").getMoney() - land_rent);
				Player.Player_dict.get("Player 1").setMoney(Player.Player_dict.get("Player 1").getMoney() + land_rent);
			} 
			else 
			{
				Player.Player_dict.get("Player 2").setMoney(Player.Player_dict.get("Player 2").getMoney() - land_rent);
			}
		}
	}
}
