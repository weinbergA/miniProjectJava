/**
 * 
 */
package unittests;

import java.awt.Color;

import org.junit.Test;

import renderer.ImageWriter;

/**
 * @author Weinberg
 *
 */
public class ImageWriterTest {
	ImageWriter imageWriter = new ImageWriter("testImage", 500, 500, 500, 500);
	java.awt.Color color = Color.blue;

	@Test
	public void planeGridTest() {
		for (int i = 0; i < 500; i += 50)
			for (int j = 0; j < 500; j++)
				imageWriter.writePixel(i, j, color);
		for (int i = 0; i < 500; i += 50)
			for (int j = 0; j < 500; j++)
				imageWriter.writePixel(j, i, color);

		imageWriter.writeToimage();
	}

}
