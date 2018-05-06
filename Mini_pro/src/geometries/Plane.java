/**
 * 
 */
package geometries;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

import primitives.Color;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

/**
 * class for plane geometry
 * 
 * @author Weinberg
 *
 */
public class Plane extends Geometry {

	private Point3D _p;
	private Vector planeNormal;

	/********** Constructors ***********/
	/**
	 * main contractor
	 * 
	 * @param a
	 *            some point in the plane
	 * @param normal
	 *            normal vector for the plane
	 * @param color
	 *            color of the plane
	 */
	public Plane(Point3D a, Vector normal, Color color) {
		super(color);
		this._p = new Point3D(a);
		planeNormal = normal.normalize();
	}

	/**
	 * 3 points contractor
	 * 
	 * @param a
	 *            1st point
	 * @param b
	 *            2nd point
	 * @param c
	 *            3rd point
	 * @param color
	 *            color of the plane
	 */
	public Plane(Point3D a, Point3D b, Point3D c, Color color) {
		super(color);
		this._p = new Point3D(a);
		// if it is same points it will thrown by zero vector
		Vector vectorAb = new Vector(b.sub(a));
		Vector vectorAc = new Vector(c.sub(a));
		Vector vectorBc = new Vector(c.sub(b));

		// if all of the points are on the same line it will thrown by zero
		// vector
		planeNormal = vectorAb.crossProduct(vectorAc);
		planeNormal.normalize();

	}

	/************** Getters/Setters *******/
	/**
	 * get point on the plane
	 * 
	 * @return point
	 */
	public Point3D getP() {
		return _p;
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
		return planeNormal;
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

		ArrayList<Point3D> arrayList = new ArrayList<Point3D>();

		double t = (planeNormal.dotProduct(new Vector(_p.sub(ray.getP00()))))
				/ planeNormal.dotProduct(ray.getDirection());
		if (t > 0) {
			Point3D P = new Point3D(ray.getP00().add(ray.getDirection().scalarMultiplicat(t).getHead()));
			arrayList.add(P);
		}
		if (t == 0) {
			Point3D p = new Point3D(ray.getP00());
			arrayList.add(p);
		}
		Map<Geometry, List<Point3D>> map = new HashMap<Geometry, List<Point3D>>();
		map.put(this, new ArrayList<Point3D>(arrayList));
		return map;
	}

}
