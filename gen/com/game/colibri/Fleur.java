/**
 * 
 */

/**
 * @author Mariam
 *
 */
public class Fleur extends Elements{
	private boolean visible;
	
	public Fleur( Coordonnee coordonnee) {
		super(coordonnee);
		this.visible = true;
	}
	/**
	 * @return the visible
	 */
	public boolean isVisible() {
		return visible;
	}

	/**
	 * @param visible the visible to set
	 */
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
	

}
