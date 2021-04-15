package Modelo;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class MamaPato extends Elemento {

	private boolean activo;
	
	public MamaPato(String recurso,int x, int y,int tx, int vx, int vy) {
		super(recurso, x, y, tx, vx, vy);
		activo=false;
	}

	@Override
	public void dibuja(Graphics g) {
		
		if (isMisionCumplida()){
			imagen = new ImageIcon(this.getClass().getResource("mort.png")).getImage();
			g.drawImage(imagen,getX(),getY(),getXt(),getXt(),null);
		}else{
			if(isActivo()){
				imagen = new ImageIcon(this.getClass().getResource("rojomamaPato.png")).getImage();
				g.drawImage(imagen,getX(),getY(),getXt(),getXt(),null);
			}else{
				imagen = new ImageIcon(this.getClass().getResource("pj.png")).getImage();
				g.drawImage(imagen,getX(),getY(),getXt(),getXt(),null);
			}
		}
	}
	

	public boolean isActivo() {
		return activo;
	}
	
	@Override
	public void anima() {
		setX(getX()+getVx());
		setY(getY()+getVy());
		if (getX()<0 || getY()<0 || getX()>750 || getY()>550){
			if(isActivo()){
				if(getX()<0){
					setX(750);
				}
				if(getX()>750){
					setX(0);
				}
				if(getY()<0){
					setY(550);
				}
				if(getY()>550){
					setY(0);
				}
			}else{
				setMisionCumplida(true);
			}
		}
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

}
