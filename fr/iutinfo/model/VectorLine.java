package fr.iutinfo.model;

/**
 * Classe repr�sentant une ligne vectorielle
 * @author pierre
 *
 */
public class VectorLine extends Figure {
	private Vector _vector;
	
	public VectorLine(Vector v) {
		_vector = v;
	}

	public Vector getVector() {
		return _vector;
	}
}
