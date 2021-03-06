package fr.iutinfo.model;

import java.awt.Color;

import fr.iutinfo.librairies.CorruptFileException;
import fr.iutinfo.librairies.MyObservable;

public abstract class Figure extends MyObservable implements Cloneable {
	public static final int GO_UP = 1;
	public static final int GO_DOWN = 2;
	public static final int GO_LEFT = 3;
	public static final int GO_RIGHT = 4;
	public final static float ERROR_MARGE = (float) 0.5;
	
	/**
	 * Defini si une forme est pleine (true) ou si elle ne contient que le contour(false)
	 */
	private boolean _fill = true;
	/**
	 * Contient la couleur de la figure
	 */
	private  Color _color = Color.BLACK;
	
	/**
	 * Modifie le remplissage d'une forme
	 * @param fill
	 */
	public void setFill(boolean fill) {
		_fill = fill;
		notifyObs(this);
	}
	
	/**
	 * Retourne l'etat de remplissage de la forme
	 * @return
	 */
	public boolean isFill() {
		return _fill;
	}
	
	/**
	 * Modifie la couleur d'une forme
	 * @param color
	 */
	public void setColor(Color color) {
		_color = color;
		notifyObs(this);
	}
	
	/**
	 * Retourne la couleur d'une forme
	 * @return
	 */
	public Color getColor() {
		return _color;
	}
	
	/**
	 * Permet de diriger une forme dans une direction(LEFT, RIGHT, DOWN, UP) avec une vitesse
	 * @param direction
	 * @param speed
	 */
	public abstract void move(int direction, double speed);
	/**
	 * Permet de redimensionner une figure en remplacent le point a l'origine par l'autre
	 * @param originTop
	 * @param originLeft
	 * @param endTop
	 * @param endLeft
	 */
	public abstract void resize(double originTop, double originLeft, double endTop, double endLeft);
	
	/**
	 * Methode de clonage, si la figure contient une liste de vecteur alors la classe fille doit redefinir clone
	 * @see Polygon.clone
	 */
	public Figure clone() {
		try {
			return (Figure) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Methode permettant la sauvegarde de la Figure
	 * @return String la representation sous forme de texte de la figure
	 */
	public abstract String save();
	
	/**
	 * Permet de restaurer une figure a partir de sa representation sous forme de texte
	 * @param s
	 * @return
	 * @throws CorruptFileException
	 */
	public static Figure restore(String s) throws CorruptFileException {
		return null;
	}
	
	/**
	 * Permet d'encoder une couleur pour la sauvegarde d'une figure
	 * @param c
	 * @return
	 */
	public static String encodeColor(Color c) {
		String str = "#";
		String current;
		
		current = Integer.toHexString(c.getAlpha());
		if(current.length() < 2) current = "0" + current;
		str += current;
	
		current = Integer.toHexString(c.getRed());
		if(current.length() < 2) current = "0" + current;
		str += current;
		
		current = Integer.toHexString(c.getGreen());
		if(current.length() < 2) current = "0" + current;
		str += current;
				
		current = Integer.toHexString(c.getBlue());
		if(current.length() < 2) current = "0" + current;
		str += current;
		return str;
	}
	
	/**
	 * Permet de decoder une couleur pour l'ouverture d'une figure
	 * @param s
	 * @return
	 */
	public static Color decodeColor(String s) {
		if(s.startsWith("#")) {
			int a, r, g, b;
			a = Integer.decode("#" + s.substring(1, 3));
			r = Integer.decode("#" + s.substring(3, 5));
			g = Integer.decode("#" + s.substring(5, 7));
			b = Integer.decode("#" + s.substring(7, 9));
			return new Color(r, g, b, a);
		} else {
			throw new IllegalArgumentException(s + " must be HexNumber");
		}
	}
}
