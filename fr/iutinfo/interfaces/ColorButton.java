package fr.iutinfo.interfaces;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ColorButton extends JButton {

	private Color color;

	public ColorButton(Color c){
		this.color=c;
		setPreferredSize(new Dimension(30, 30));
		setBackground(color);
		setOpaque(true);
		setBorderPainted(false);
	}
	
	public ColorButton(ImageIcon ic){
		super(ic);
		setText("perso");
		color = Color.white;
		setOpaque(true);
		setPreferredSize(new Dimension(30, 30));
	}

	/**
	 * retourne la couleur
	 * @return Color
	 */
	public Color getColor(){
		return this.color;
	}
	/**
	 * set la couleur
	 * @param color
	 */
	public void setColor(Color color){
		this.color=color;
		setBackground(color);
		repaint();
	}
	
	public String toString(){
		return getText();
	}
}
