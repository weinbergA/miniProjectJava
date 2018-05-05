package geometries;

import java.util.List;
import java.util.Map;

import primitives.Color;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public abstract class Geometry {

	protected Color _emmission;

	/**
	 * @param _emmission
	 */
	public Geometry(Color _emmission) {
		this._emmission = _emmission;
	}

	public Geometry() {
	}

	
	public abstract Vector getNormal(Point3D point3d);

	public abstract Map<Geometry, List<Point3D>> findIntersections(Ray ray);

	public Color getColor() {
		return _emmission;
	}

}
