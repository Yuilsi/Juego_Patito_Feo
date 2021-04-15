package Modelo;

import java.awt.Graphics;

public class PatitoFeo extends Elemento {

	public PatitoFeo(String recurso, int x, int y, int xt, int vx, int vy) {
		super(recurso, x, y, xt, vx, vy);
	}

	@Override
	public void dibuja(Graphics g) {
		g.drawImage(imagen,getX(),getY(),getXt(),getXt(),null);
	}
	
	@Override
	public void anima() {
		  //cuando toque los bordes cambie de direccion
		setY(getY()+getVy());
		if (getX()<0){
			
		}
		if (getY()<450){
			setVy(-getVy());
		}
			
		if (getY()>550){
			setVy(-getVy());
		}
		
	}
	

}
