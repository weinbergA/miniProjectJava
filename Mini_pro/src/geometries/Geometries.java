/**
 * 
 */
package geometries;

import java.util.List;
import java.util.Map;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class for ambient light of each object
 * 
 * @author Weinberg
 */
public class Geometries extends Geometry {

	private List<Geometry> geometriesList;

	/**
	 * general contractor
	 * 
	 * @param geometriesList
	 *            getting list of geometries
	 */
	public Geometries(ArrayList<Geometry> geometriesList) {
		super();
		this.geometriesList = new ArrayList<Geometry>(geometriesList);
	}

	/**
	 * copy contractor
	 * 
	 * @param geometries
	 *            getting another Geometry object
	 */
	public Geometries(Geometries geometries) {
		super();
		this.geometriesList = new ArrayList<Geometry>(geometries.getGeometriesList());
	}

	/**
	 * empty contractor
	 */
	public Geometries() {
		super();
		this.geometriesList = new ArrayList<Geometry>();
	}

	/**
	 * getting the list of geometries
	 * 
	 * @return the geometriesList the list of all geometries
	 */
	public List<Geometry> getGeometriesList() {
		return geometriesList;
	}

	/**
	 * adding geometry to the list
	 * 
	 * @param g
	 *            geometry to add
	 */
	public void addGeometry(Geometry g) {
		geometriesList.add(g);
	}

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
		return null;
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

		Map<Geometry, List<Point3D>> map = new HashMap<Geometry, List<Point3D>>();

		for (Geometry geomtry : geometriesList)
			map.putAll(geomtry.findIntersections(ray));

		return map;
	}

}
