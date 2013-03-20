package unit.ActionMap;

/**
 * Stores data recorded by action map.
 * 
 * @author tdvornik
 *
 */
public class ActionMapTestData {
	private static String data;
	
	
	public static void add(String newData) {
		if (data.equals("")) 
			data = newData;
		else 
			data = data + " " + newData;
	}
	
	public static void clear() {
		data = "";
	}
	
	public static String getData() {
		return data;
	}
	
}
