package fr.iutinfo.view;

import java.awt.Graphics;
import java.awt.Point;

/**
 * Interface d'affichage d'une forme
 * @author pierre
 */
public interface Printable {
	/**
	 * Methode d'affichage de la forme, elle prend en param�tre le pannel sur lequel elle doit s'afficher ainsi que son objet graphics
	 * @param v
	 * @param g
	 */
	public void paint(SceneView v, Graphics g);
	/**
	 * Methode de test d'une selection, elle doit retourner true si dans la scene view pass� en param�tre, la forme se trouve au point (x,y)
	 * @param v
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean isSelect(SceneView v, int x, int y);
	/**
	 * Retourne le nombre de point de la forme (pour afficher les points de la selection qui sont g�r� ind�pendamment de la forme)
	 * @return
	 */
	public int getNbPoint();
	/**
	 * Recup�re la liste des diff�rents x des points de la forme
	 * @param v
	 * @return
	 */
	public int[] getXPoint(SceneView v);
	/**
	 * Recupere la liste des diff�rents y des points de la forme
	 * @param v
	 * @return
	 */
	public int[] getYPoint(SceneView v);
	/**
	 * Recupere le point de la figure se trouvant au coordonn�es (x,y) dans la figure
	 * @param scene
	 * @param x
	 * @param y
	 * @return
	 */
	public Point getPoint(SceneView scene, int x, int y);
}
