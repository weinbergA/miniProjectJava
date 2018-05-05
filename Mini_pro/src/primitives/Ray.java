/**
 * 
 */
package primitives;

/**
 * @author Asher Weinberg
 *
 */
public class Ray {
	private Point3D _poo;
	private Vector _direction;
	
	/**
	 * @param _poo
	 * @param _direction
	 */
	public Ray(Point3D p0, Vector direction) {
		this._poo = p0;
		this._direction = direction.normalize();
	}

	/**
	 * @return the _poo
	 */
	public Point3D getP00() {
		return _poo;
	}

	/**
	 * @return the _direction
	 */
	public Vector getDirection() {
		return _direction;
	}
	
	/************Admin**********/
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Ray))
			return false;
		Ray oth = (Ray) obj;
		return _direction.equals(oth._direction) && _poo.equals(oth._poo);
	}
}
