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
 * @author Weinberg
 *
 */
public class Geometries extends Geometry {

	private List<Geometry> geometriesList;

	/**
	 * @param geometriesList
	 */
	public Geometries(ArrayList<Geometry> geometriesList) {
		super();
		this.geometriesList = new ArrayList<Geometry>(geometriesList);
	}

	public Geometries(Geometries geometries) {
		super();
		this.geometriesList = new ArrayList<Geometry>(geometries.getGeometriesList());
	}

	public Geometries() {
		super();
		this.geometriesList = new ArrayList<Geometry>();
	}

	/**
	 * @return the geometriesList
	 */
	public List<Geometry> getGeometriesList() {
		return geometriesList;
	}

	public void addGeometry(Geometry g) {
		geometriesList.add(g);
	}

	@Override
	public Vector getNormal(Point3D point3d) {
		return null;
	}

	@Override
	public Map<Geometry, List<Point3D>> findIntersections(Ray ray) {
		ArrayList<Point3D> points = new ArrayList<Point3D>();
		Map<Geometry, List<Point3D>> map = new HashMap<Geometry, List<Point3D>>();

		for (Geometry geomtry : geometriesList)
			map.putAll(geomtry.findIntersections(ray));

		return map;
	}

}
