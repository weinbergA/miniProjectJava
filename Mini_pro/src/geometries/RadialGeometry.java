package geometries;

import primitives.Color;
import primitives.Coordinate;

/**
 * class for geometry objects with radius
 * 
 * @author Weinberg
 *
 */
public abstract class RadialGeometry extends Geometry {

	protected double _radius;

	/********** Constructors ***********/
	/**
	 * main contractor
	 * 
	 * @param radius
	 *            radius length
	 * @param color
	 *            color of the object
	 */
	public RadialGeometry(double radius, Color color) {
		super(color);
		Coordinate coordinate = new Coordinate(radius);
		if (coordinate.equals(Coordinate.ZERO))
			throw new IllegalArgumentException();
		_radius = radius;
	}

	/**
	 * copy contractor
	 * @param radialGeometry other object to copy from
	 */
	public RadialGeometry(RadialGeometry radialGeometry) {
		super(radialGeometry._emmission);
		_radius = radialGeometry._radius;
	}

	/************** Getters/Setters *******/
	/**
	 * get radius
	 * @return radius
	 */
	public double getRadius() {
		return _radius;
	}

}
