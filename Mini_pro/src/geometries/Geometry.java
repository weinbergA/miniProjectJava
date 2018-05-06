package geometries;

import java.util.List;
import java.util.Map;

import primitives.Color;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

/**
 * abstract class for all geometries
 * 
 * @author Weinberg
 *
 */
public abstract class Geometry {

	protected Color _emmission;

	/**
	 * color contractor
	 * 
	 * @param _emmission
	 *            color of object emmission
	 */
	public Geometry(Color _emmission ) {
		this._emmission = _emmission;
	}

	public Geometry() {
	}

	/**
	 * get normal vector from ray to geometry in point
	 * 
	 * @param point3d
	 *            point to get normal
	 * 
	 * @return the normal vector
	 */
	public abstract Vector getNormal(Point3D point3d);

	public abstract Map<Geometry, List<Point3D>> findIntersections(Ray ray);

	/**
	 * get color
	 * 
	 * @return color
	 */
	public Color getColor() {
		return _emmission;
	}

}
