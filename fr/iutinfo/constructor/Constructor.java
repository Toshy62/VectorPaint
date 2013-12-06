package fr.iutinfo.constructor;

import java.awt.Graphics;
import fr.iutinfo.view.SceneView;
import fr.iutinfo.model.Figure;

/**
 * Interface de gestion d'un constructeur de forme
 * @author pierre
 */
public interface Constructor {
	/**
	 * Ajoute un point dans la figure. La m�thode renvoit true si la construction est fini et qu'on peut r�cup�rer la figure et faux sinon
	 * @param topDistance
	 * @param leftDistance
	 * @return
	 * @throws ConstructorException
	 */
	public boolean addPoint(double topDistance, double leftDistance) throws ConstructorException;
	/**
	 * Methode appeler durant la construction de la figure � chaque d�placement de la souris
	 * Elle permet et dessiner ce que verra en temps r�el l'utilisateur afin de lui donner un apercu de la figure qui
	 * serait construite si il cliquer � cette endroit
	 * @param v
	 * @param g
	 * @param mousePosX
	 * @param mousePosY
	 */
	public void paint(SceneView v, Graphics g, int mousePosX, int mousePosY);
	/**
	 * Permet de r�cup�rer la figure cr�er
	 * @return
	 */
	public Figure getFigure();
	/**
	 * Methode de remise � z�ro du constructeur. Il doit commencer une nouvelle figure
	 */
	public void reinit();
	/**
	 * Renvoit true si la construction � commencer (cette m�thode permet d'�viter de redessiner l'�cran � chaque modification si aucune forme n'est en cours de cr�ation)
	 * @return
	 */
	public boolean isBegin();
}
