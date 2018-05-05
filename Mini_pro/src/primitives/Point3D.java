package primitives;


/**
 * Class for 3D points in out 3D graphics model
 * 
 * @author Asher Weinberg
 *
 */
public class Point3D extends Point2D {

	private Coordinate _z;

	/********** Constructors ***********/
	public Point3D(double x, double y, double z) {
		super(x, y);
		_z = new Coordinate(z);
	}

	public Point3D(Point3D other) {
		super(other);
		_z = new Coordinate(other._z);
	}

	/************** Getters/Setters *******/
	public Coordinate getZ() {
		return _z;
	}

	/*************** Admin *****************/
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Point3D))
			return false;
		Point3D oth = (Point3D) obj;
		return super.equals(oth) && _z.equals(oth._z);
	}

	@Override
	public String toString() {
		return "(" + getX() + "," + getY() + "," + _z + ")";
	}

	public static Point3D ZERO = new Point3D(Coordinate.ZERO.getCoord(), Coordinate.ZERO.getCoord(), Coordinate.ZERO.getCoord());

	/************** Operations ***************/

	public Vector VectorSubtraction(Point3D p1) {
		return new Vector(sub(p1));
	}

	public Point3D addVector(Vector v) {
		return this.add(v.getHead());
	}

	public double distance(Point3D p1) {
		return Math.sqrt(Math.pow(getX().getCoord() - p1.getX().getCoord(), 2) + Math.pow(getY().getCoord() - p1.getY().getCoord(), 2)
				+ Math.pow(getZ().getCoord() - p1.getZ().getCoord(), 2));
	}

	public Point3D add(Point3D p1) {
		return new Point3D(getX().add(p1.getX()).getCoord(), getY().add(p1.getY()).getCoord(), getZ().add(p1.getZ()).getCoord());
	}

	public Point3D sub(Point3D p1) {
		return new Point3D(getX().subtract(p1.getX()).getCoord(), getY().subtract(p1.getY()).getCoord(),
				getZ().subtract(p1.getZ()).getCoord());
	}
}
