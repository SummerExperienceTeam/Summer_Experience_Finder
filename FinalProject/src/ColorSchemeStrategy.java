import java.awt.Color;

public interface ColorSchemeStrategy 
{
	public Color convertFXColorToSwingColor(javafx.scene.paint.Color fxColor);
	public Color getColorOne();
	public Color getColorTwo();
	public Color getColorThree();
	public Color getColorFour();
	public Color getColorFive();
	public Color getFontColor();
	

}
