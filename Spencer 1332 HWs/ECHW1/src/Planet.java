public class Planet implements Comparable<Planet> {
	/**
	 * This class represents a Planet object
	 * @author Spencer Powell
	 * @version 1.0
	 */
	public String name;
	public int population;
	public int klingonWarbirds;
	public double distance;
	public boolean inhabitable;
	
	public Planet(String name, int population, int klingonWarbirds,	double distance, boolean inhabitable) {
		this.name = name;
		this.population = population;
		this.klingonWarbirds = klingonWarbirds;
		this.distance = distance;
		this.inhabitable = inhabitable;
	}

	/**
	 * Compares to another planet class and returns a value depending on the comparison of their ranks.
	 */
	public int compareTo(Planet planet) {
		int rank1 = (int)(Math.max(((long)1/((long)population + (long)1000000 * (long)klingonWarbirds - distance/ (long)1000000000 + (long)1000000000 * (inhabitable? (long)1:((long)-1)))),(long)0));
		int rank2 = (int)(Math.max(((long)1/((long)planet.population + (long)1000000 * (long)planet.klingonWarbirds - planet.distance/ (long)1000000000 + (long)1000000000 * (planet.inhabitable? (long)1:((long)-1)))),(long)0));
		return rank1 - rank2;
	}
}