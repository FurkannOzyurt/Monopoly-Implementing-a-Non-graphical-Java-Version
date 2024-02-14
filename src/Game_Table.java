
public class Game_Table {
	public static void game_table_func() {
		new PropertyJsonReader();
		new ListJsonReader();
		
		Square.Square_dict.put(1, new Go(1));
		Square.Square_dict.put(5, new Tax(5));
		Square.Square_dict.put(11, new Jail(11));
		Square.Square_dict.put(21, new Free_Parking(21));
		Square.Square_dict.put(31, new Go_To_Jail(31));
		Square.Square_dict.put(39, new Tax(39));
		Square.Square_dict.put(3, new Community_Chest(3)); 
	    Square.Square_dict.put(18, new Community_Chest(18));
	    Square.Square_dict.put(34, new Community_Chest(34));
	    Square.Square_dict.put(8, new Chance(8));
	    Square.Square_dict.put(23, new Chance(23));
	    Square.Square_dict.put(37, new Chance(37));
	}
}
