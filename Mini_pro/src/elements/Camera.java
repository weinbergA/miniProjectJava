/**
 * 
 */
package elements;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

/**
 * @author Asher Weinberg @
 */
public class Camera {

	private Point3D _p0;
	private Vector _vUp;
	private Vector _vTo;
	private Vector _vRight;

	/********** Constructors ***********/
	public Camera(Point3D p0, Vector vUp, Vector vTo) {
		_p0 = new Point3D(p0);
		_vTo = new Vector(vTo).normalize();
		_vUp = new Vector(vUp).normalize();

		// the vectors are not orthogonal
		if (_vTo.dotProduct(vUp) != 0)
			throw new IllegalArgumentException();
		_vRight = vUp.crossProduct(vTo).normalize();
	}

	public Camera(Camera c) {
		this(c._p0, c._vUp, c._vTo);
	}

	public Camera() {
		this(Point3D.ZERO, new Vector(0, -1, 0), new Vector(0, 0, -1));
	}

	/********** Admin ***********/
	public Ray constructRayThroughPixel(int Nx, int Ny, int x, int y, double screenDistance, double screenWidth,
			double screenHights) {

		Point3D pc = new Point3D(_p0);
		Vector vector = new Vector(_vTo);
		vector = vector.scalarMultiplicat(screenDistance);
		pc = pc.add(vector.getHead());

		double Rx = screenWidth / Nx;

		double Ry = screenHights / Ny;

		double Yj = (y - (Ny / 2.0)) * Ry - (Ry / 2.0);

		double Xi = (x - (Nx / 2.0)) * Rx - (Rx / 2.0);

		Point3D Pij = new Point3D(pc);

		if (Xi != 0)
			Pij = Pij.add(_vRight.scalarMultiplicat(Xi).getHead());
		if (Yj != 0)
			Pij = Pij.sub(_vUp.scalarMultiplicat(Yj).getHead());
		// }

		Vector v = new Vector(Pij.sub(_p0)).normalize();

		return new Ray(_p0, v);
	}

	/**
	 * @return the _p0
	 */
	public Point3D getP0() {
		return _p0;
	}

	/**
	 * @return the _vUp
	 */
	public Vector getVUp() {
		return _vUp;
	}

	/**
	 * @return the _vTo
	 */
	public Vector getVTo() {
		return _vTo;
	}

	/**
	 * @return the _vRight
	 */
	public Vector get_vRight() {
		return _vRight;
	}

	@Override
	public String toString() {
		return "Vto: " + _vTo + "\n" + "Vup: " + _vUp + "\n" + "Vright:" + _vRight + ".";
	}

}
