package geometries;

import java.util.List;
import java.util.Map;

import primitives.Color;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class Cylinder extends RadialGeometry {

	private Point3D _axisPoint;
	private Vector _axisDirection;

	/********** Constructors ***********/
	public Cylinder(Point3D _axisPoint, Vector _axisDirection, double radius, Color color) {
		super(radius, color);
		this._axisPoint = new Point3D(_axisPoint);
		this._axisDirection = _axisDirection.getVector();
	}

	/************** Getters/Setters *******/
	public Point3D getAxisPoint() {
		return _axisPoint;
	}

	public Vector getAxisDirection() {
		return _axisDirection;
	}

	/*************** Admin *****************/
	@Override
	public Vector getNormal(Point3D point3d) {
		Vector u = new Vector(point3d.sub(_axisPoint));
		double t = u.dotProduct(_axisDirection) / _axisDirection.dotProduct(_axisDirection);
		Point3D p = point3d.add(_axisDirection.scalarMultiplicat(t).getHead());
		return new Vector(point3d.sub(p)).normalize();
	}

	@Override
	public Map<Geometry, List<Point3D>> findIntersections(Ray ray) {
		return null;
	}

}
