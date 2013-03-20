package unit.GameState;

public class TestMonitor
{
	private static StringBuilder builder = new StringBuilder();
	
	public TestMonitor()
	{
	}
	
	public static void clear()
	{
		builder = new StringBuilder();
	}
	
	public static void add(String s)
	{
		builder.append(s + ",");
	}
	
	public static String dump()
	{
		return builder.toString();
	}
	
}
