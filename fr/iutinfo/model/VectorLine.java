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

	@Override
	public void move(int direction, double speed) {
		Vector v = _vector;
		switch(direction) {
		case GO_UP:
			v.setTopDistance(v.getTopDistance()-speed);
			v.setEndTopDistance(v.getEndTopDistance()-speed);
			break;
		case GO_DOWN:
			v.setTopDistance(v.getTopDistance()+speed);
			v.setEndTopDistance(v.getEndTopDistance()+speed);
			break;
		case GO_LEFT:
			v.setLeftDistance(v.getLeftDistance()-speed);
			v.setEndLeftDistance(v.getEndLeftDistance()-speed);
			break;
		case GO_RIGHT:
			v.setLeftDistance(v.getLeftDistance()+speed);
			v.setEndLeftDistance(v.getEndLeftDistance()+speed);
			break;
		}
	}

	@Override
	public void resize(double originTop, double originLeft, double endTop, double endLeft) {
		double diffX, diffY;
		boolean beginResize = false, endResize = false;
		if(!beginResize) {
			diffX = Math.abs(_vector.getLeftDistance() - originLeft);
			diffY = Math.abs(_vector.getTopDistance() - originTop);

			if(diffX < ERROR_MARGE && diffY < ERROR_MARGE) {
				_vector.setLeftDistance(endLeft);
				_vector.setTopDistance(endTop);
			}
			beginResize = true;
		}

		if(!endResize) {
			diffX = Math.abs(_vector.getEndLeftDistance() - originLeft);
			diffY = Math.abs(_vector.getEndTopDistance() - originTop);

			if(diffX < ERROR_MARGE && diffY < ERROR_MARGE) {
				_vector.setEndLeftDistance(endLeft);
				_vector.setEndTopDistance(endTop);
			}
			endResize = true;
		}
	}
}
