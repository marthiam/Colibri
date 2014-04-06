/**
 * 
 */

/**
 * @author Mariam
 *
 */
public class Coordonnee {
	int x;
	int y;
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Cordonnee [x=" + x + ", y=" + y + "]";
	}
	public Coordonnee(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}
	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	} 

	

}
