/**
 * 
 */
package scene;

import elements.AmbientLight;
import elements.Camera;
import geometries.Geometries;
import geometries.Geometry;
import primitives.Color;

/**
 * @author Weinberg Scene include the camera, the screen distance, the
 *         background color, and name
 */
public class Scene {
	private String _name;
	private Color _background;
	private Geometries _geometries;
	private Camera _camera;
	double _screenDistance;
	private AmbientLight _ambientLight;

	/**
	 * @param _name
	 * @param _background
	 * @param _geometries
	 * @param _camera
	 * @param _screenDistance
	 */
	public Scene(String name) {
		this._name = new String(name);
		this._background = new Color(0, 0, 0);
		this._geometries = new Geometries();
		this._camera = new Camera();
		this._screenDistance = 1;
		this._ambientLight = new AmbientLight(new Color(0, 0, 0), 1);
	}

	// ***************** Constructors ********************** //
	/**
	 * @return the color
	 */
	public Color getColor() {
		return _background;
	}

	/**
	 * @return the camera
	 */
	public Camera getCamera() {
		return _camera;
	}

	/**
	 * @param camera
	 *            the camera to set
	 */
	public void setCamera(Camera camera) {
		this._camera = new Camera(camera);
	}

	/**
	 * @return the screenDistance
	 */
	public double getScreenDistance() {
		return _screenDistance;
	}

	public String getName() {
		return _name;
	}

	/**
	 * @param screenDistance
	 *            the screenDistance to set
	 */
	public void setScreenDistance(double screenDistance) {
		this._screenDistance = screenDistance;
	}

	public void setAmbientLight(Color color, double ka) {
		this._ambientLight = new AmbientLight(color, ka);
	}
	
	public void addGeometry(Geometry g) {
		_geometries.addGeometry(g);
	}

	/**
	 * @return the _background
	 */
	public Color getBackground() {
		return _background;
	}

	/**
	 * @return the _geometries
	 */
	public Geometries getGeometries() {
		return _geometries;
	}

	public void setBackground(Color color) {
		this._background = new Color(color);
	}

	public void setGeomtries(Geometries geometries) {
		_geometries = new Geometries(geometries);
	}

	/**
	 * @return the _ambientLight
	 */
	public AmbientLight getAmbientLight() {
		return _ambientLight;
	}

}
