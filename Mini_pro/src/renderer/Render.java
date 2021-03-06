/**
 * 
 */
package renderer;

import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import geometries.Geometry;
import primitives.Color;
import primitives.Point3D;
import primitives.Ray;
import scene.Scene;

/**
 * 
 * @author Weinberg
 * 
 */
public class Render {
	private ImageWriter _imageWriter;
	private Scene _scene;

	/********** Constructors ***********/
	public Render(ImageWriter imageWriter, Scene scene) {
		_imageWriter = new ImageWriter(imageWriter);
		_scene = scene;
	}

	/************** Getters/Setters *******/
	/**
	 * @return the _imageWriter
	 */
	public ImageWriter get_imageWriter() {
		return _imageWriter;
	}

	/**
	 * @return the _scene
	 */
	public Scene get_scene() {
		return _scene;
	}

	public void renderImage() {
		for (int i = 0; i < _imageWriter.getNx(); i++)
			for (int j = 0; j < _imageWriter.getNy(); j++) {
				Ray ray = _scene.getCamera().constructRayThroughPixel(_imageWriter.getNx(), _imageWriter.getNy(), i, j,
						_scene.getScreenDistance(), _imageWriter.getWidth(), _imageWriter.getHeight());
				Map<Geometry, List<Point3D>> intersectionPoints = _scene.getGeometries().findIntersections(ray);
				Boolean emptyMap = false;
				for (Map.Entry<Geometry, List<Point3D>> entry : intersectionPoints.entrySet())
					if (!entry.getValue().isEmpty())
						emptyMap = true;
				if (emptyMap == false)
					_imageWriter.writePixel(i, j, _scene.getBackground().getColor());
				else {

					Map<Geometry, Point3D> map = getClosestPoint(intersectionPoints);
					Map.Entry<Geometry, Point3D> entry = map.entrySet().iterator().next();
					_imageWriter.writePixel(i, j, calcColor(entry.getKey(), entry.getValue()).getColor());
				}
			}
	}

	public void printGrid(int k) {

		for (int i = 0; i < _imageWriter.getNx(); i += k)
			for (int j = 0; j < _imageWriter.getNy(); j++)
				_imageWriter.writePixel(i, j, java.awt.Color.white);
		for (int i = 0; i < _imageWriter.getNx(); i += k)
			for (int j = 0; j < _imageWriter.getNy(); j++)
				_imageWriter.writePixel(j, i, java.awt.Color.white);

	}

	public void writeToImage() {
		_imageWriter.writeToimage();
	}

	private Color calcColor(Geometry geometry, Point3D point3d) {
		Color color = new Color(_scene.getAmbientLight().getIntensity());
		color.add(geometry.getColor());
		return color;
	}

	private Map<Geometry, Point3D> getClosestPoint(Map<Geometry, List<Point3D>> intersectionPoints) {

		double distance = Double.MAX_VALUE;
		Map<Geometry, Point3D> map = new HashMap<Geometry, Point3D>();

		Point3D p0 = _scene.getCamera().getP0();

		for (Map.Entry<Geometry, List<Point3D>> iPoints : intersectionPoints.entrySet())
			for (Point3D iPoint : iPoints.getValue()) {
				if (iPoint.distance(p0) < distance) {
					distance = iPoint.distance(p0);
					map.clear();
					map.put(iPoints.getKey(), iPoint);
				}
			}
		return map;
	}

}
