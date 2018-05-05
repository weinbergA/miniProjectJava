/**
 * 
 */
package primitives;

/**
 * @author Asher Weinberg
 *
 */
public class Vector {

	protected Point3D _head;

	/********** Constructors ***********/
	public Vector(Point3D head) {
		// zero vector
		if (head.getX().equals(Coordinate.ZERO) && head.getY().equals(Coordinate.ZERO)
				&& head.getZ().equals(Coordinate.ZERO))
			throw new IllegalArgumentException();
		_head = new Point3D(head.getX().getCoord(), head.getY().getCoord(), head.getZ().getCoord());
	}

	public Vector(double x, double y, double z) {

		Point3D p = new Point3D(x, y, z);
		if (p.getX().equals(Coordinate.ZERO) && p.getY().equals(Coordinate.ZERO) && p.getZ().equals(Coordinate.ZERO))
			throw new IllegalArgumentException();
		_head = p;
	}

	public Vector(Vector other) {
		_head = new Point3D(other._head);
	}

	/************** Getters/Setters *******/
	public Point3D getHead() {
		return _head;
	}

	public Vector getVector() {
		Vector vector = new Vector(_head);
		return vector;
	}

	/*************** Admin *****************/
	@Override
	public String toString() {
		return "{" + String.format("%.2f", _head.getX().getCoord()) + ","
				+ String.format("%.2f", _head.getY().getCoord()) + "," + String.format("%.2f", _head.getZ().getCoord())
				+ "}";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Vector))
			return false;
		Vector vector = (Vector) obj;
		return (_head.equals(vector._head));
	}

	/************** Operations ***************/
	public Vector add(Vector a) {
		Vector ab = new Vector(_head.getX().add(a._head.getX()).getCoord(), _head.getY().add(a._head.getY()).getCoord(),
				_head.getZ().add(a._head.getZ()).getCoord());
		return ab;
	}

	public Vector sub(Vector a) {
		Vector ab = new Vector(_head.getX().subtract(a._head.getX()).getCoord(),
				_head.getY().subtract(a._head.getY()).getCoord(), _head.getZ().subtract(a._head.getZ()).getCoord());
		return ab;
	}

	public double dotProduct(Vector b) {
		// go through coordinate class to round low values
		Coordinate coordinate = new Coordinate(_head.getX().getCoord() * b._head.getX().getCoord()
				+ _head.getY().getCoord() * b._head.getY().getCoord()
				+ _head.getZ().getCoord() * b._head.getZ().getCoord());
		return coordinate.getCoord();
	}

	public Vector scalarMultiplicat(double a) {
		return new Vector(_head.getX().getCoord() * a, _head.getY().getCoord() * a, _head.getZ().getCoord() * a);
	}

	public Vector normalize() {
		double size = Length();
		if (size == 0)
			throw new ArithmeticException();
		_head = new Point3D(_head.getX().getCoord() / size, _head.getY().getCoord() / size,
				_head.getZ().getCoord() / size);
		return this;
	}

	public Vector crossProduct(Vector v) {
		double x, y, z;
		x = _head.getY().getCoord() * v._head.getZ().getCoord() - (_head.getZ().getCoord() * v._head.getY().getCoord());
		y = (_head.getZ().getCoord() * v._head.getX().getCoord()
				- (_head.getX().getCoord() * v._head.getZ().getCoord()));
		z = _head.getX().getCoord() * v._head.getY().getCoord() - (_head.getY().getCoord() * v._head.getX().getCoord());

		Point3D point3d = new Point3D(x, y, z);
		Vector uVector = new Vector(point3d);
		return uVector;
	}

	public double Length() {
		return Math.sqrt(this.dotProduct(this));
	}

}
