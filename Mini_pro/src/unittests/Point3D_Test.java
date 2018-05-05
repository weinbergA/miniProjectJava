package unittests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import primitives.Point3D;

public class Point3D_Test {
	Point3D p1 = new Point3D(1, 2, 3);
	Point3D p2 = new Point3D(-4, -3, -2);

	@Test
	public void distanceTest() {
		assertTrue(p1.distance(p2) == Math.sqrt(75));
	}

}
