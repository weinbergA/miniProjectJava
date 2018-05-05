package geometries;

import primitives.Color;
import primitives.Coordinate;

public abstract class RadialGeometry extends Geometry {

	protected double _radius;

	/********** Constructors ***********/
	public RadialGeometry(double radius, Color color) {
		super(color);
		Coordinate coordinate = new Coordinate(radius);
		if (coordinate.equals(Coordinate.ZERO))
			throw new IllegalArgumentException();
		_radius = radius;
	}

	public RadialGeometry(RadialGeometry radialGeometry) {
		super(radialGeometry._emmission);
		_radius = radialGeometry._radius;
	}

	/************** Getters/Setters *******/
	public double getRadius() {
		return _radius;
	}

}
