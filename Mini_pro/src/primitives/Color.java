package primitives;

import java.awt.color.ICC_ColorSpace;

public class Color {
	protected double r;
	protected double g;
	protected double b;

	/********** Constructors ***********/
	public Color(double R, double G, double B) {
		r = R;
		g = G;
		b = B;
	}

	public Color() {
		r = g = b = 255;
	}

	public Color(Color color) {
		this(color.r, color.g, color.b);
	}

	/************** Operations ***************/
	public void add(Color... color) {
		for (Color iColor : color) {
			r += iColor.r;
			g += iColor.g;
			b += iColor.b;
		}
	}

	public Color scale(double Kam) {
		r *= Kam;
		g *= Kam;
		b *= Kam;
		return this;
	}

	public Color reduce(double Kam) {
		scale(1 / Kam);
		return this;
	}

	/************** Getters/Setters *******/
	/**
	 * @return the _color
	 */
	public java.awt.Color getColor() {
		int tempR, tempG, tempB;
		if (r > 255)
			tempR = 255;
		else
			tempR = (int) r;
		if (g > 255)
			tempG = 255;
		else
			tempG = (int) g;
		if (b > 255)
			tempB = 255;
		else
			tempB = (int) b;
		return new java.awt.Color(tempR, tempG, tempB);
	}

}
