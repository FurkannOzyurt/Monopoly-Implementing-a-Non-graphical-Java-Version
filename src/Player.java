import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Player extends User {
	public static HashMap<String, Player> Player_dict = new HashMap<String, Player>() ;
	
	private int dice;
	private int position;
	private int sum_of_position = 1;
	private int complated_tours = 0;
	private boolean in_jail = false;
	private int jail_counter = 0;
	private boolean in_free_park = false;
	private int free_park_counter = 0;
	private boolean card_activity = false;
	private ArrayList<Property> property_list = new ArrayList<Property>();
	
	public Player(String id, int money, int position) {
		super(id, money);
		this.position = position;
	}
	
	public int getDice() {
		return dice;
	}

	public void setDice(int dice) {
		this.dice = dice;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public ArrayList<Property> getProperty_list() {
		return property_list;
	}

	public void setProperty_list(ArrayList<Property> property_list) {
		this.property_list = property_list;
	}
	
	public int getComplated_tours() {
		return complated_tours;
	}

	public void setComplated_tours(int complated_tours) {
		this.complated_tours = complated_tours;
	}
	
	public boolean isIn_jail() {
		return in_jail;
	}

	public void setIn_jail(boolean in_jail) {
		this.in_jail = in_jail;
	}
	
	public int getJail_counter() {
		return jail_counter;
	}

	public void setJail_counter(int jail_counter) {
		this.jail_counter = jail_counter;
	}
	
	public boolean isIn_free_park() {
		return in_free_park;
	}

	public void setIn_free_park(boolean in_free_park) {
		this.in_free_park = in_free_park;
	}

	public int getFree_park_counter() {
		return free_park_counter;
	}

	public void setFree_park_counter(int free_park_counter) {
		this.free_park_counter = free_park_counter;
	}
	
	public int getSum_of_position() {
		return sum_of_position;
	}

	public void setSum_of_position(int sum_of_position) {
		this.sum_of_position = sum_of_position;
	}
	
	public boolean isCard_activity() {
		return card_activity;
	}

	public void setCard_activity(boolean card_activity) {
		this.card_activity = card_activity;
	}
	// player moves according to jail and free park status
	public void move(int dice, boolean in_jail, boolean in_free_park) 
	{
		if (this.in_jail == false) 
		{
			this.sum_of_position += dice; // position is calculated according to total dice
			this.position = this.sum_of_position % 40;
			if (this.position == 0) {
				this.position = 40;
			}
		} 
	}

	public static void show(Player player1, Player player2, Banker banker, BufferedWriter writer) throws IOException {
		String player1_properties = "";
		for (Property property : player1.property_list) 
		{
			player1_properties += (property.getName() + ",") ;
		}
		player1_properties = player1_properties.substring(0, player1_properties.length());
		
		String player2_properties = "";
		for (Property property : player2.property_list) 
		{
			player2_properties += (property.getName() + ",") ;
		}
		player2_properties = player2_properties.substring(0, player2_properties.length());
		
		writer.write("-----------------------------------------------------------------------------------------------------------");
		writer.newLine();
		writer.write(player1.getId() + "\t" + player1.getMoney() + "\t" + "have: " + player1_properties);
		writer.newLine();
		writer.write(player2.getId() + "\t" + player2.getMoney() + "\t" + "have: " + player2_properties);
		writer.newLine();
		writer.write("Banker  " + banker.getMoney());
		writer.newLine();
		// Determine the winner
		if (player1.getMoney() > player2.getMoney()) 
		{
			writer.write("Winner  " + player1.getId());
			writer.newLine();
		} 
		else 
		{
			writer.write("Winner  " + player2.getId());
			writer.newLine();
		}
		writer.write("-----------------------------------------------------------------------------------------------------------");
		writer.newLine();
	}		
}
	
	
	
	
	
	