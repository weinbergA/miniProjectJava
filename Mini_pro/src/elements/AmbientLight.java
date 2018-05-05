package elements;

import primitives.Color;

public class AmbientLight {
	private Color _color;
	private double Ka;
	
	
	/********** Constructors ***********/
	/**
	 * @param _color
	 * @param ka
	 */
	public AmbientLight(Color color, double ka) {
		this._color = new Color(color);
		Ka = ka;
	}
	
	public AmbientLight(AmbientLight al) {
		this(al.getColor(), al.getKa());
	}

	/************** Operations ***************/
	public Color getIntensity() {
		return _color.scale(Ka);
	}

	/************** Getters/Setters *******/
	/**
	 * @return the _color
	 */
	public Color getColor() {
		return _color;
	}

	/**
	 * @return the ka
	 */
	public double getKa() {
		return Ka;
	}

	/**
	 * @param _color the _color to set
	 */
	public void setColor(Color _color) {
		this._color = _color;
	}

	/**
	 * @param ka the ka to set
	 */
	public void setKa(double ka) {
		Ka = ka;
	}
}
