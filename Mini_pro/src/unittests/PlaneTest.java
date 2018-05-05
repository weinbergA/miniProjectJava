/**
 * 
 */
package unittests;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Test;

import elements.Camera;
import geometries.Plane;
import primitives.Color;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

/**
 * @author Weinberg testing plane geometry
 */
public class PlaneTest {

	Point3D a = new Point3D(1, 1, 1);
	Point3D b = new Point3D(1, 1, 1);
	Point3D c = new Point3D(1, 2, 3);
	Point3D d = new Point3D(2, 2, 2);
	Point3D e = new Point3D(3, 3, 3);

	@Test
	public void planeConstractor() {
		try {
			Plane p1 = new Plane(a, b, c, new Color());
			fail("same points");
		} catch (IllegalArgumentException e) {
			assertTrue(true);
		}

		try {
			Plane p1 = new Plane(a, d, e);
			fail("all of the points are on the same line");
		} catch (IllegalArgumentException e) {
			assertTrue(true);
		}
	}

	@Test
	public void planeIntersectionsTest() {

		final int WIDTH = 3;
		final int HIGHT = 3;
		Ray[][] rays = new Ray[WIDTH][HIGHT];

		Camera camera = new Camera(Point3D.ZERO, new Vector(0, -1, 0), new Vector(0, 0, -1));

		Plane plane = new Plane(new Point3D(0.0, 0.0, -3.0), new Vector(0.0, 0.0, -1.0));

		// 45 degrees to the view plane
		Plane plane1 = new Plane(new Point3D(0.0, 0.0, -3.0), new Vector(0.0, 0.25, -1.0));

		ArrayList<Point3D> planeIntersections = new ArrayList<>();
		ArrayList<Point3D> plane1Intersections = new ArrayList<>();

		for (int i = 0; i < HIGHT; i++)
			for (int j = 0; j < WIDTH; j++) {
				rays[i][j] = camera.constructRayThroughPixel(WIDTH, HIGHT, j, i, 1, 2 * WIDTH, 2 * HIGHT);
				ArrayList<Point3D> point3ds = new ArrayList<Point3D>(plane.findIntersections(rays[i][j]));
				for (Point3D p : point3ds)
					planeIntersections.add(p);

				ArrayList<Point3D> point3ds1 = new ArrayList<Point3D>(plane1.findIntersections(rays[i][j]));
				for (Point3D p : point3ds1)
					plane1Intersections.add(p);

			}
		System.out.println(planeIntersections.size());
		System.out.println(plane1Intersections.size());
		assertTrue(planeIntersections.size() == 9);
		assertTrue(plane1Intersections.size() == 9);

		for (Point3D point : planeIntersections)
			System.out.println(point);
		System.out.println();
		for (Point3D point : plane1Intersections)
			System.out.println(point);

	}

}
