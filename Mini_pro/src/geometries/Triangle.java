package geometries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import primitives.Color;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

/**
 * class for triangle geometry
 * 
 * @author Weinberg
 *
 */
public class Triangle extends Plane {

	private Point3D _p1;
	private Point3D _p2;
	private Point3D _p3;

	/********** Constructors ***********/
	/**
	 * main constructor
	 * @param a 1st point
	 * @param b 2nd point
	 * @param c 3rd point
	 * @param color color of the triangle
	 */
	public Triangle(Point3D a, Point3D b, Point3D c, Color color) {
		super(a, b, c, color);
		_p1 = new Point3D(a);
		_p2 = new Point3D(b);
		_p3 = new Point3D(c);
	}

	/************** Getters/Setters *******/
	/** get 1st point
	 * @return the _p1
	 */
	public Point3D getP1() {
		return _p1;
	}

	/**
	 * get 2nd point
	 * @return the _p2
	 */
	public Point3D getP2() {
		return _p2;
	}

	/**
	 * get 3rd point
	 * @return the _p3
	 */
	public Point3D getP3() {
		return _p3;
	}

	/************** Admin **********/
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
		List<Point3D> points = new ArrayList<Point3D>(super.findIntersections(ray).get(this));
		Map<Geometry, List<Point3D>> map = new HashMap<Geometry, List<Point3D>>();

		if (points.size() == 0)
			return map;

		Vector v1 = new Vector(_p1.sub(ray.getP00()));
		Vector v2 = new Vector(_p2.sub(ray.getP00()));
		Vector v3 = new Vector(_p3.sub(ray.getP00()));

		Vector N1 = v1.crossProduct(v2).normalize();
		Vector N2 = v2.crossProduct(v3).normalize();
		Vector N3 = v3.crossProduct(v1).normalize();

		Vector v = new Vector(points.get(0).sub(ray.getP00()));

		if ((N1.dotProduct(v) > 0 && N2.dotProduct(v) > 0 && N3.dotProduct(v) > 0)
				|| (v.dotProduct(N1) < 0 && v.dotProduct(N2) < 0 && v.dotProduct(N3) < 0))
			map.put(this, new ArrayList<>(points));

		return map;

	}

}
