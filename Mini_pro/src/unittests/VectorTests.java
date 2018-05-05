package unittests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import primitives.*;
/**
 * @author Weinberg
 *Testing math operations in vector
 */
public class VectorTests {

	@Test
	public void testAdd() {

		Point3D p0 = new Point3D(1.0, 2, 3);
		Point3D p1 = new Point3D(1.0, 5, 3);
		Point3D p3 = new Point3D(2.0, 7.0, 6.0);

		Vector vec1 = new Vector(p0);
		Vector vec2 = new Vector(p1);
		Vector vec3 = new Vector(p3);
		assertEquals(vec3, vec1.add(vec2));
		assertNotEquals(vec2, vec3.add(vec1));
	}

	@Test
	public void testSubtract() {

		Point3D p0 = new Point3D(1.0, 2, 3);
		Point3D p1 = new Point3D(1.0, 5, 3);
		Point3D p3 = new Point3D(0.0, -3, 0);

		Vector vec1 = new Vector(p0);
		Vector vec2 = new Vector(p1);
		Vector vec3 = new Vector(p3);
		assertEquals(vec3, vec1.sub(vec2));
		assertNotEquals(vec2, vec3.sub(vec1));
	}

	@Test
	public void testScaling() {
		Point3D p0 = new Point3D(1.0, 2, 3);
		Point3D p1 = new Point3D(3.0, 6, 9);
		Vector vec1 = new Vector(p0);
		Vector vec2 = new Vector(p1);
		assertEquals(vec2, vec1.scalarMultiplicat(3.0));
	}

	@Test
	public void testDotProduct() {
		Point3D p0 = new Point3D(1.0, 0, 1);
		Point3D p1 = new Point3D(1.0, 0, -1);
		Vector vec1 = new Vector(p0);
		Vector vec2 = new Vector(p1);
		assertEquals(0.0, vec1.dotProduct(vec2), 0.0001);
		assertNotEquals(10.13, vec1.dotProduct(vec2), 0.0001);
	}

	@Test
	public void testLength() {
		Point3D p0 = new Point3D(1.0, 2, 3);
		Vector vec1 = new Vector(p0);
		assertEquals(Math.sqrt(14), vec1.Length(), 0.0001);
	}

	@Test
	public void testNormalize() {
		Point3D p0 = new Point3D(1.0, 2, 3);
		Point3D p1 = new Point3D(1 / Math.sqrt(14), 2 / Math.sqrt(14), 3 / Math.sqrt(14));
		Vector vec1 = new Vector(p0);
		Vector vec2 = new Vector(p1);
		vec1.normalize();
		assertEquals(vec2, vec1);
		Point3D p2 = new Point3D(0.0, 0, 0);
		
		try {
			Vector vec3 = new Vector(p2);
			fail();
		} catch (IllegalArgumentException e) {
		}
	}

	@Test
	public void testCrossProduct() {
		Point3D p0 = new Point3D(1.0, 0, 0);
		Point3D p1 = new Point3D(0, 0, -1);
		Vector vec1 = new Vector(p0);
		Vector vec2 = new Vector(p1);
		Point3D p3 = new Point3D(1.0, 0, 0);
		Point3D p4 = new Point3D(0.0, 1, 0);
		Point3D p5 = new Point3D(0.0, 0, 1);
		Vector vec4 = new Vector(p3);
		Vector vec5 = new Vector(p4);
		Vector vec6 = new Vector(p5);
		assertEquals(vec6, vec4.crossProduct(vec5));
		assertNotEquals(vec5, vec4.crossProduct(vec5));
		assertEquals(vec1.crossProduct(vec2), new Vector(0, -1, 0));
	}
}
