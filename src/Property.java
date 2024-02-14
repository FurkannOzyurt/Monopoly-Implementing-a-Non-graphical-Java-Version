import java.io.BufferedWriter;
import java.io.IOException;
import java.util.HashMap;

abstract class Property extends Square {
	private String name;
	private int cost;
	private String status = "not-owned";
	private String owner = "Banker";
	public static HashMap<Integer, Property> Property_dict = new HashMap<Integer, Property>() ;
	
	public Property(int id, String name, int cost) {
		super(id);
		this.name = name;
		this.cost = cost;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	public void purchased(Player player, Banker banker) {
		player.setMoney(player.getMoney() - this.cost);
		banker.setMoney(banker.getMoney() + this.cost);
		this.status = "owned";
		this.owner = player.getId();
		player.getProperty_list().add(this);
	}
	// every rent has different rule
	abstract void get_a_lease(Player player);
	
	@Override
	void unique_main_func(Player player, Banker banker, BufferedWriter writer) throws IOException 
	{
		if (this.status == "not-owned") 
		{
			if (player.getMoney() >= this.cost) 
			{
				this.purchased(player,banker);
				if (player.isCard_activity() == false) 
				{
					writer.write(player.getId() + "\t" + String.valueOf(player.getDice()) + "\t" + player.getPosition() + "\t" + Player.Player_dict.get("Player 1").getMoney() + "\t" + Player.Player_dict.get("Player 2").getMoney() + "\t" + player.getId() + " bought " + this.name);
				    writer.newLine();
				} 
				else 
				{
					writer.write(player.getId() + " bought " + this.name);
				    writer.newLine();
				}
			}
			else 
			{
				player.setMoney(player.getMoney() - this.cost);
			}
		}
		else 
		{
			if (this.owner != player.getId()) 
			{
				this.get_a_lease(player);
				if (player.isCard_activity() == false) 
				{
					writer.write(player.getId() + "\t" + String.valueOf(player.getDice()) + "\t" + player.getPosition() + "\t" + Player.Player_dict.get("Player 1").getMoney() + "\t" + Player.Player_dict.get("Player 2").getMoney() + "\t" + player.getId() + " paid rent for " + this.name);
					writer.newLine();
				} 
				else 
				{
					writer.write(player.getId() + " paid rent for " + this.name);
					writer.newLine();
				}
			}
			else 
			{
				if (player.isCard_activity() == false) 
				{
					writer.write(player.getId() + "\t" + String.valueOf(player.getDice()) + "\t" + player.getPosition() + "\t" + Player.Player_dict.get("Player 1").getMoney() + "\t" + Player.Player_dict.get("Player 2").getMoney() + "\t" + player.getId() + " has " + this.name);
					writer.newLine();
				} 
				else 
				{
					writer.write(player.getId() + " has " + this.name);
					writer.newLine();
				}
			}
		}	
	}
}
