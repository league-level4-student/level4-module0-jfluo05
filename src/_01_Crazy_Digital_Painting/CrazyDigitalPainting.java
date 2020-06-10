package _01_Crazy_Digital_Painting;

import java.awt.Color;

public class CrazyDigitalPainting {
	//1. Create two final static integers for the width and height of the display.
	final static int width=500;
	final static int height=500;
	
	ColorArrayDisplayer cad=new ColorArrayDisplayer();
	//2. Create a 2D array of Color objects. You will need to import
	//java.awt.Color. Initialize the size of the array using the 
	//integers created in step 1.
	
	Color[][] color=new Color[width][height];
	
	public CrazyDigitalPainting() {
		//3. Open the crazy_digital_painting.png file and look at the image.
		
		//4. Iterate through the 2D array and initialize each Color object
		//   to a new color. The sample image was created using the following 
		//   pattern:
		//   colors[i][j] = new Color(i % 256, (i * j) % 256, j % 256);
		for(int i = 0; i < color.length; i++) {
			for(int k = 0; k < color[i].length; k++) {
				color[i][k]=new Color(i*i % 256, (i * k) % 256, k % 256);
			}
		}
		//5. Come up with your own pattern to make a cool crazy image.
		
		//6. Use the ColorArrayDisplayer class to call the displayColorsAsImage method 
		//   to show off your picture.
		cad.displayColorsAsImage(color);
	}
	
	public static void main(String[] args) {
		new CrazyDigitalPainting();
	}
}
