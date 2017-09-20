import java.awt.Color;

public class ColorSchemeColoradoCollege implements ColorSchemeStrategy {

	private Color colorOne;
	private Color colorTwo;
	private Color colorThree; 
	private Color colorFour;
	private Color colorFive; 
	private Color fontColor; 
	public ColorSchemeColoradoCollege()
	{
		colorOne = convertFXColorToSwingColor(javafx.scene.paint.Color.BLACK); //Dark
		colorTwo = convertFXColorToSwingColor(javafx.scene.paint.Color.GOLDENROD); //Light
		colorThree = convertFXColorToSwingColor(javafx.scene.paint.Color.DARKGOLDENROD);
		colorFour = convertFXColorToSwingColor(javafx.scene.paint.Color.GOLD);
		colorFive = convertFXColorToSwingColor(javafx.scene.paint.Color.GOLD);
		fontColor = Color.WHITE;
		
	}
	
	/**
	 * converts javafx colors to color object 
	 * @param fxColor
	 * @return
	 */
	public Color convertFXColorToSwingColor(javafx.scene.paint.Color fxColor)
	{
		java.awt.Color awtColor = new java.awt.Color((float) fxColor.getRed(),
		                                             (float) fxColor.getGreen(),
		                                             (float) fxColor.getBlue(),
		                                             (float) fxColor.getOpacity());
		return awtColor;
	}
	
	@Override
	public Color getColorOne() {
		
		return colorOne;
	}

	@Override
	public Color getColorTwo() {
		
		return colorTwo;
	}

	@Override
	public Color getColorThree() {
		
		return colorThree;
	}

	@Override
	public Color getColorFour() {
		// TODO Auto-generated method stub
		return colorFour;
	}

	@Override
	public Color getColorFive() {
		// TODO Auto-generated method stub
		return colorFive;
	}
	
	public Color getFontColor() {
		
		return fontColor;
	}
	
	

}
