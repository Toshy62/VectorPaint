package fr.iutinfo.model;

/**
 * Classe repr�sentant un cercle
 * @author pierre
 * TODO A recoder compl�tement
 */
public class Circle extends Figure {
	private Vector _height;
	private Vector _width;
	
	/**
	 * Crée un cercle avec deux vecteurs
	 * @param height
	 * @param width
	 */
	public Circle(Vector height, Vector width) {
		_height = height;
		_width = width;
		notifyObs();
	}
}
