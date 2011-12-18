import java.lang.Math;

public class distance
{
	
	private static double dis;
	
	public distance()
	{
		
	}
	static double find_distance (point a, point b)
	{	
		double x;
		double y;
		
		x=Math.pow((b.getX()-a.getX()),2);
		y=Math.pow((b.getY()-a.getY()),2);
		dis=Math.sqrt(x+y);
		return dis;
	}
	static void print()
	{
		System.out.println(dis);
	}
	
	
}
