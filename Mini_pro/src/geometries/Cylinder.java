package geometries;

import java.util.List;
import java.util.Map;

import primitives.Color;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

/**
 * class of cylinder object hhh
 * 
 * @author Weinberg
 *
 */
public class Cylinder extends RadialGeometry {

	private Point3D _axisPoint;
	private Vector _axisDirection;

	/********** Constructors ***********/
	/**
	 * general contractor
	 * 
	 * @param _axisDirection
	 *            axis direction
	 * @param _axisPoint
	 *            point on the the axis direction
	 * @param radius
	 *            radius of the cylinder
	 * @param color
	 *            color of the object
	 */
	public Cylinder(Point3D _axisPoint, Vector _axisDirection, double radius, Color color) {
		super(radius, color);
		this._axisPoint = new Point3D(_axisPoint);
		this._axisDirection = _axisDirection.getVector();
	}

	/************** Getters/Setters *******/
	/**
	 * get axis point
	 * 
	 * @return axis point
	 */
	public Point3D getAxisPoint() {
		return _axisPoint;
	}

	/**
	 * get axis direction
	 * 
	 * @return axis direction
	 */
	public Vector getAxisDirection() {
		return _axisDirection;
	}

	/*************** Admin *****************/

	/**
	 * get normal vector from ray to geometry in point
	 * 
	 * @param point3d
	 *            point to get normal
	 * 
	 * @return the normal vector
	 */
	@Override
	public Vector getNormal(Point3D point3d) {
		Vector u = new Vector(point3d.sub(_axisPoint));
		double t = u.dotProduct(_axisDirection) / _axisDirection.dotProduct(_axisDirection);
		Point3D p = point3d.add(_axisDirection.scalarMultiplicat(t).getHead());
		return new Vector(point3d.sub(p)).normalize();
	}

	/**
	 * get intersections points from ray to geometry
	 * 
	 * @param ray
	 *            the ray to calculate from
	 * 
	 * @return map of geometry and list of the intersections points
	 */
	@Override
	public Map<Geometry, List<Point3D>> findIntersections(Ray ray) {
		return null;
	}

}
