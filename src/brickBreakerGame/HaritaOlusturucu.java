package brickBreakerGame;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class HaritaOlusturucu {
	
	public int harita[][];
	public int brickYukseklik;
	public int brickGenislik;
	public HaritaOlusturucu(int row,int col) {
		
		harita = new int[row][col];
		for(int i = 0; i < harita.length;i++) {
			for(int j=0;j<harita[0].length;j++) {
				
				harita[i][j] = 1;
				
			}
			
		brickGenislik = 540/col;
		brickYukseklik= 150/row;
		}
		
		}
		public void draw(Graphics2D g) {
			for(int i = 0; i < harita.length;i++) {
				for(int j=0;j<harita[0].length;j++) {
				   if(harita[i][j] > 0) {
					   g.setColor(Color.white);
					   g.fillRect(j * brickGenislik + 80,i * brickYukseklik + 50, brickGenislik,brickYukseklik);
					   
					   g.setStroke(new BasicStroke(3));
					   g.setColor(Color.black);
					   g.drawRect(j * brickGenislik + 80,i * brickYukseklik + 50, brickGenislik,brickYukseklik);
					   
					      
				   }
				   
				}
			
			
		}
		
	}
		public void setBrickValue(int value,int row , int col) {
			
			harita[row][col]=value;
		}

}
