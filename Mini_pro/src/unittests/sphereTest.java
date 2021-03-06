/**
 * 
 */
package unittests;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import elements.Camera;
import geometries.Geometry;
import geometries.Sphere;
import primitives.Color;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

/**
 * @author Weinberg Testing small sphere with two intersection points Testing
 *         when the camera is into the sphere with 9 intersection points
 */
public class sphereTest {

	@Test
	public void testIntersection() {
		Sphere sphere = new Sphere(new Point3D(0, 0, -3), 1, Color.white);
		Sphere sphere2 = new Sphere(new Point3D(0, 0, -2), 10, Color.white);

		Camera camera = new Camera();
		final int WIDTH = 3;
		final int HEIGHT = 3;

		Ray[][] rays = new Ray[HEIGHT][WIDTH];

		ArrayList<Point3D> intersectionPointsSphere = new ArrayList<Point3D>();
		ArrayList<Point3D> intersectionPointsSphere2 = new ArrayList<Point3D>();

		for (int i = 0; i < HEIGHT; i++) {
			for (int j = 0; j < WIDTH; j++) {

				rays[i][j] = camera.constructRayThroughPixel(WIDTH, HEIGHT, j, i, 1, 3 * WIDTH, 3 * HEIGHT);
				Map<Geometry, List<Point3D>> point3ds = sphere.findIntersections(rays[i][j]);
				Map<Geometry, List<Point3D>> point3ds2 = sphere2.findIntersections(rays[i][j]);

				for (Map.Entry<Geometry, List<Point3D>> points : point3ds.entrySet())
					for (Point3D p : points.getValue())
						intersectionPointsSphere.add(p);
				
				for (Map.Entry<Geometry, List<Point3D>> points : point3ds2.entrySet())
					for (Point3D p : points.getValue())
						intersectionPointsSphere2.add(p);

			}
		}

		for (Point3D iPoint : intersectionPointsSphere)
			System.out.println(iPoint);
		System.out.println("----");
		for (Point3D iPoint : intersectionPointsSphere2)
			System.out.println(iPoint);

		assertTrue(intersectionPointsSphere.size() == 2);
		assertTrue(intersectionPointsSphere2.size() == 9);

	}

}
