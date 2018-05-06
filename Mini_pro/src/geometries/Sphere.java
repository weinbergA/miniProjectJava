/**
 * 
 */
package geometries;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

import primitives.Color;
import primitives.Coordinate;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

/**
 * class of sphere geometry
 * 
 * @author Weinberg
 *
 */
public class Sphere extends RadialGeometry {

	private Point3D _center;

	/********** Constructors ***********/
	/**
	 * main contractor
	 * @param _centre centre of the sphere
	 * @param radius radius of the sphere
	 * @param color color of the sphere
	 */
	public Sphere(Point3D _centre, double radius, Color color) {
		super(radius, color);
		this._center = new Point3D(_centre);
	}

	/************** Getters/Setters *******/
	/**
	 * get centre
	 * @return centre point
	 */
	public Point3D getCenter() {
		return _center;
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
		Vector N = new Vector(_center.sub(point3d));
		N.normalize();
		return N;
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

		List<Point3D> point = new ArrayList<Point3D>();
		Vector u = new Vector(this.getCenter().sub(ray.getP00()));
		double Tm = ray.getDirection().dotProduct(u);
		double d = Math.sqrt((u.Length() * u.Length()) - (Tm * Tm));/* pitagoras */
		Map<Geometry, List<Point3D>> map = new HashMap<Geometry, List<Point3D>>();

		/* d>radius ,the meaning is thare are no points at all */
		if (d > this.getRadius()) {
			map.put(this, point);
			return map;
		}
		double Th = Math.sqrt((this.getRadius() * this.getRadius()) - (d * d));
		double t1 = Tm + Th;
		double t2 = Tm - Th;
		Coordinate t1Coordinate = new Coordinate(t1);
		Coordinate t2Coordinate = new Coordinate(t2);

		if (t1Coordinate.equals(t2Coordinate) && !t1Coordinate.equals(Coordinate.ZERO)) {
			point.add(ray.getP00().add(ray.getDirection().scalarMultiplicat(t1).getHead()));
			map.put(this, point);
			return map;
		}
		if (t1 > 0) {
			point.add(ray.getP00().add(ray.getDirection().scalarMultiplicat(t1).getHead()));
		}
		if (t2 > 0)
			point.add(ray.getP00().add(ray.getDirection().scalarMultiplicat(t2).getHead()));

		map.put(this, new ArrayList<Point3D>(point));
		return map;

	}

}
