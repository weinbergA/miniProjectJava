package unittests;

import static org.junit.Assert.*;
import org.junit.Test;
import elements.Camera;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;
import scene.Scene;

public class CameraTests {

	Camera c1 = new Camera();
	Scene s1 = new Scene("s1");
	Vector vector = new Vector(1, 0, 0);

	Vector v1 = new Vector(1 / Math.sqrt(6), 1 / Math.sqrt(6), -Math.sqrt(2) / Math.sqrt(3));
	Ray ray1 = new Ray(Point3D.ZERO, v1);
	Ray rar2 = new Ray(Point3D.ZERO, new Vector(-1 / Math.sqrt(6), -1 / Math.sqrt(6), -Math.sqrt(2) / Math.sqrt(3)));
	Ray ray3 = new Ray(Point3D.ZERO, new Vector(-1 / Math.sqrt(6), 1 / Math.sqrt(6), -Math.sqrt(2) / Math.sqrt(3)));
	Ray ray4 = new Ray(Point3D.ZERO, new Vector(0, 0, -1));

	Point3D p2 = new Point3D(-3, 3, -3);
	Camera c2 = new Camera(p2, new Vector(1, 1, 1), new Vector(-1, 2, -1));
	Ray r21 = new Ray(p2, new Vector(140, 260, -223).normalize());

	@Test
	public void constructorCamera() {
		// test vRight
		s1.setCamera(c1);
		assertEquals(vector, s1.getCamera().get_vRight());
		// test orthogonals vectors
		try {
			new Camera(Point3D.ZERO, v1, new Vector(1, 9, 8));
			fail("The vectors are orthogonals");
		} catch (IllegalArgumentException e) {
			assertTrue(true);
		}
	}

	@Test
	public void buidRayTest() {
		s1.setCamera(c1);
		s1.setScreenDistance(100);
		assertEquals(s1.getCamera().constructRayThroughPixel(3, 3, 3, 3, s1.getScreenDistance(), 150, 150), ray1);
		assertEquals(s1.getCamera().constructRayThroughPixel(3, 3, 1, 1, s1.getScreenDistance(), 150, 150), rar2);
		assertEquals(s1.getCamera().constructRayThroughPixel(3, 3, 1, 3, s1.getScreenDistance(), 150, 150), ray3);
		assertEquals(s1.getCamera().constructRayThroughPixel(3, 3, 2, 2, s1.getScreenDistance(), 150, 150), ray4);

	}
}
