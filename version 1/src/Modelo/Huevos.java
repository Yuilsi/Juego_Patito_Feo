package Modelo;

import java.awt.Graphics;

public class Huevos extends Elemento {

	public Huevos(String recurso, int x, int y, int xt, int vx, int vy) {
		super(recurso, x, y, xt, vx, vy);
	}

	@Override
	public void dibuja(Graphics g) {
		g.drawImage(imagen,getX(),getY(),getXt(),getXt(),null);
	}
	
	@Override
	public void anima() {
		
		setY(getY()+getVy());
		
		if (getY()<500){
			setVy(-getVy());
		}
				
		if (getY()>600){
			setVy(-getVy());
		}
		
	}
	

}