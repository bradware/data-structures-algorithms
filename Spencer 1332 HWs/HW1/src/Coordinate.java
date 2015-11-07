
public class Coordinate implements Comparable<Coordinate> {

	/**
	 * Compares the z coordinates of two Coordinates
	 * 
	 * @param that 
	 * 			
	 * @return positive number if this < that, 0 if this = that, and negative number if this > that
	 */
	public int compareTo(Coordinate that) {
		if(this.z < that.z)
			return -1;
		if(this.z > that.z)
			return 1;
		return 0;
	}
	
	/* Do NOT modify code below this line */
	
	private static int count = 0;
	public int id, x, y, z;
	
	public Coordinate(int x, int y, int z) {
		this.id = Coordinate.count++;
		this.x = x;
		this.y = y;
		this.z = z;
	}
}
