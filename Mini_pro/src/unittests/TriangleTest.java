/**
 * 
 */
package unittests;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import elements.Camera;
import geometries.Triangle;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

/**
 * @author Weinberg
 *Testing two triangles from the presentation
 */
public class TriangleTest {

	@Test
	public void testIntersectionPoints() {

		final int WIDTH = 3;
		final int HEIGHT = 3;

		Ray[][] rays = new Ray[HEIGHT][WIDTH];

		Camera camera = new Camera();

		Triangle triangle = new Triangle(new Point3D(0, -1, -2), new Point3D(1, 1, -2), new Point3D(-1, 1, -2));

		Triangle triangle2 = new Triangle(new Point3D(0, -20, -2), new Point3D(1, 1, -2), new Point3D(-1, 1, -2));

		ArrayList<Point3D> intersectionPointsTriangle = new ArrayList<Point3D>();
		ArrayList<Point3D> intersectionPointsTriangle2 = new ArrayList<Point3D>();

		System.out.println("Camera:\n" + camera);

		for (int i = 0; i < HEIGHT; i++) {
			for (int j = 0; j < WIDTH; j++) {

				rays[i][j] = camera.constructRayThroughPixel(WIDTH, HEIGHT, j, i, 1, 3 * WIDTH, 3 * HEIGHT);

				ArrayList<Point3D> rayIntersectionPoints = new ArrayList<Point3D>(triangle.findIntersections(rays[i][j]));
				ArrayList<Point3D> rayIntersectionPoints2 = new ArrayList<Point3D>(triangle2.findIntersections(rays[i][j]));

				for (Point3D iPoint : rayIntersectionPoints)
					intersectionPointsTriangle.add(iPoint);

				for (Point3D iPoint : rayIntersectionPoints2)
					intersectionPointsTriangle2.add(iPoint);
			}
		}
		System.out.println(intersectionPointsTriangle.size());
		System.out.println(intersectionPointsTriangle2.size());

		assertTrue(intersectionPointsTriangle.size() == 1);
		assertTrue(intersectionPointsTriangle2.size() == 3);

		System.out.println("Intersection Points:");
		for (Point3D p : intersectionPointsTriangle) {
			System.out.println(p);
		}

		System.out.println("--");
		for (Point3D p : intersectionPointsTriangle2) {
			System.out.println(p);
		}

	}
	
}
