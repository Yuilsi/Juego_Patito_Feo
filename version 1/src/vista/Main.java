package vista;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import Controlador.Juego;
import Modelo.Huevos;
import Modelo.ImplenemetaImagen;
import Modelo.MamaPato;
import Modelo.Puntuacion;
import Modelo.Texto;

import java.io.*; 

public class Main extends Juego {

	private ImplenemetaImagen fondo;
	private static int velocitat=20;
	
	private int contador;
	private MamaPato rojomamaPato;
	private ImplenemetaImagen guadar;
	private ImplenemetaImagen finalizar;
	
	
	
	private Huevos punto;
	private Puntuacion puntuacion;
	
	public Main() {
		super("Patito feo!", 800, 600);
		
		inicializa();
		
		 start();
	}
	
	public void inicializa(){
		
		fondo = new ImplenemetaImagen("fondo.jpg",0,0,800,600);
		area.add(fondo);
		rojomamaPato= new MamaPato("pj.png",350,400,200,0,0);
		contador = 0;
		punto = new Huevos("huevo.png",300,500,60,0,0);
				
		
				
				
				
	
		puntuacion=new Puntuacion(10,20);
		
		area.add(puntuacion);
		area.add(rojomamaPato);
		area.add(punto);
	
		
		
		temporizador.add(rojomamaPato);
		temporizador.add(punto);
		temporizador.add(puntuacion);
		
		
	}
	
	
	

	public static int getVelocitat() {
		return velocitat;
	}
	public static void setVelocitat(int velocitat) {
	Main.velocitat = velocitat;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		
		if(e.getKeyCode()==KeyEvent.VK_SPACE){
			if(rojomamaPato.getMisionCumplida()){
				guadar.setVisible(false);
				finalizar.setVisible(false);
				//reiniciar.setVisible(false);
				rojomamaPato.setMisionCumplida(false);
				velocitat=20;
				temporizador.restart();
				area.vacia();
				temporizador.vacia();
				inicializa();
				area.repaint();
			}
		}
	}

	@Override
	public void comprobaciones() {
		
		Rectangle rect = new Rectangle(rojomamaPato.getX(),rojomamaPato.getY(),rojomamaPato.getXt(),
				rojomamaPato.getXt());

	
		
		Rectangle rectp = new Rectangle(punto.getX(),punto.getY(),punto.getXt(),punto.getXt());
		if(rect.intersects(rectp)){
			punto.setX((int) ((Math.random()*600)+10));
			punto.setX((int) ((Math.random()*400)+10));
			punto.setVx((int) ((Math.random()*10)));
			punto.setVy((int) ((Math.random()*10)));
			puntuacion.setA(puntuacion.getA()+1);
		}
		// && puntuacion.getA()>0
		if((puntuacion.getA()%5)==0){
			rojomamaPato.setActivo(true);
		}else{
			rojomamaPato.setActivo(false);
		}
		if(rojomamaPato.getMisionCumplida()){
			temporizador.stop();
		guadar= new ImplenemetaImagen("gameover.png",0,0,800,600);
		area.add(guadar);
			
		}
	}

	
	public void mousePressed() {
		selectButton();
	
}
	
	private String getEnC() {
		int num=(int) (4 * Math.random());
		String cambio = "patohijo.png";
		switch (num) {
		case 1:
			cambio="patohijo.png";
			break;
		case 2:
		
			break;
		}
		return cambio;
	}
	
	

	
	private void selectButton() {
			
	}
	
	public static void main(String[] args) {
		new Main();
		Texto lc= new Texto();
		lc.read("texto.txt");
	}


}