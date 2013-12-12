package fr.iutinfo.model;

import java.util.ArrayList;

public class Polygon extends Figure {
	protected ArrayList<Vector> _vectorList;
	protected boolean _finished = false;
	
	/**
	 * Cree un polygone vide
	 */
	public Polygon() {
		_vectorList = new ArrayList<Vector>();
	}
	
	/**
	 * Ajoute un vecteur a la forme
	 * @param v
	 * @throws Exception 
	 */
	public void addVector(Vector v) throws Exception {
		if(!_checkVector(v)) {
			throw new IllegalArgumentException("Le vecteur ne suit pas le vecteur precedent");
		}
		if(isFinish()) {
			throw new Exception("La figure est deja pleine");
		}
		if(_isFinish(v)) {
			_finished = true;
		}
		_vectorList.add(v);
	}

	/**
	 * Verifie que le vecteur est ajoutable
	 * @param v
	 * @return
	 */
	protected boolean _checkVector(Vector v) {
		if(_vectorList.isEmpty()) return true;
		
		Vector last = _vectorList.get(_vectorList.size()-1);
		
		double finishY = last.getEndTopDistance();
		double finishX = last.getEndLeftDistance();
		
		double diffY = Math.abs(v.getTopDistance()-finishY);
		double diffX = Math.abs(v.getLeftDistance()-finishX);
		
		if(diffY < ERROR_MARGE && diffX < ERROR_MARGE) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Verifie que la figure est pleine
	 * @param v
	 * @return
	 */
	protected boolean _isFinish(Vector v) {
		if(_vectorList.isEmpty()) return false;
		
		Vector first = _vectorList.get(0);
		
		double finishY = v.getEndTopDistance();
		double finishX = v.getEndLeftDistance();
		
		double diffY = Math.abs(first.getTopDistance()-finishY);
		double diffX = Math.abs(first.getLeftDistance()-finishX);
		
		if(diffY < ERROR_MARGE && diffX < ERROR_MARGE) {
			notifyObs(this);
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Verifie si un polygon est fini
	 * @return
	 */
	public boolean isFinish() {
		return _finished;
	}

	/**
	 * Recup�re la liste des vecteurs constituant le polygone
	 * @return
	 */
	public ArrayList<Vector> getVectors() {
		return _vectorList;
	}

	@Override
	public void move(int direction, double speed) {
		for(Vector v : _vectorList) {
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
		notifyObs(this);
	}

	@Override
	public void resize(double originTop, double originLeft, double endTop, double endLeft) {
		double diffX, diffY;
		boolean beginResize = false, endResize = false;
		for(Vector v : _vectorList) {
			if(!beginResize) {
				diffX = Math.abs(v.getLeftDistance() - originLeft);
				diffY = Math.abs(v.getTopDistance() - originTop);
				if(diffX < ERROR_MARGE && diffY < ERROR_MARGE) {
					System.out.println("Resize");
					v.setLeftDistance(endLeft);
					v.setTopDistance(endTop);
					beginResize = true;
				}
			}
			
			if(!endResize) {
				diffX = Math.abs(v.getEndLeftDistance() - originLeft);
				diffY = Math.abs(v.getEndTopDistance() - originTop);
				if(diffX < ERROR_MARGE && diffY < ERROR_MARGE) {
					v.setEndLeftDistance(endLeft);
					v.setEndTopDistance(endTop);
					endResize = true;
				}
			}
		}
		notifyObs(this);
	}

	@Override
	public Polygon clone() {
		Polygon copy;
		copy = (Polygon) super.clone();
		if(copy == null) return copy;
		copy._vectorList = new ArrayList<Vector>();
		for(Vector v : _vectorList) {
			copy._vectorList.add(v.clone());
		}
		return copy;
	}
}
