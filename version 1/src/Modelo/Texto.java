package Modelo;

import java.io.*;    // importar toda
public class Texto {

	public void read (String nameFile) {
		
		try {
			FileReader r= new FileReader (nameFile);
			BufferedReader buffer = new BufferedReader(r);  // lee linea por linea y se lo asigna a temp
			
			String temp = "";
			while(temp!= null) {
				
				temp= buffer.readLine();
				
				String x;    
				x= temp;                        
				
				String []arreglo=x.split(" ");  
				
				for (int i=0; i<arreglo.length;i++) {
					System.out.println(" "+ arreglo[i]);
			
				}
				 if (temp==null)
					 
					 break;
			};
			
			}catch(Exception e) {
				System.out.println(e.getMessage());    //si no se encuentra el archivo se genera un mensaje 
				
			};
		}
		
	}

