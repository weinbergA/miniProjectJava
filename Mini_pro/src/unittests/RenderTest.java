package unittests;

import java.awt.AWTError;

import org.junit.Test;

import elements.Camera;
import geometries.*;
import primitives.*;
import renderer.ImageWriter;
import renderer.Render;
import scene.Scene;

public class RenderTest {
	@Test
	public void basicRendering() {
		Scene scene = new Scene("Test scene");
		scene.setCamera(new Camera(new Point3D(0, 0, 0), new Vector(0, -1, 0), new Vector(0, 0, 1)));
		scene.setScreenDistance(150);
		scene.setBackground(new Color(50, 50, 50));
		scene.setAmbientLight(new Color(255,255,255), 0.1);
		Geometries geometries = new Geometries();

		geometries.addGeometry(new Sphere(new Point3D(0, 0, 150), 50, new Color(244, 95, 8)));

		geometries.addGeometry(new Triangle(new Point3D(100, 0, 149), new Point3D(0, 100, 149),
				new Point3D(100, 100, 149), new Color(255, 102, 255)));

		geometries.addGeometry(new Triangle(new Point3D(100, 0, 149), new Point3D(0, -100, 149),
				new Point3D(100, -100, 149), new Color(153, 204, 255)));

		geometries.addGeometry(new Triangle(new Point3D(-100, 0, 149), new Point3D(0, 100, 149),
				new Point3D(-100, 100, 149), new Color(100, 0, 102)));

		geometries.addGeometry(new Triangle(new Point3D(-100, 0, 149), new Point3D(0, -100, 149),
				new Point3D(-100, -100, 149), new Color(224, 224, 224)));
		scene.setGeomtries(geometries);

		ImageWriter imageWriter = new ImageWriter("test0", 500, 500, 500, 500);
		Render render = new Render(imageWriter, scene);

		render.renderImage();
		render.printGrid(50);
		render.writeToImage();
	}
}