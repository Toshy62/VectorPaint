package fr.iutinfo.librairies;

import fr.iutinfo.model.Figure;

/**
 * Interface impl�mentant le design pattern observer prennant en param�tre une figure
 * @see fr.iutinfo.librairies.MyObservable
 */
public interface MyObserver {
	public void update(MyObservable observable, Figure modified);
}
