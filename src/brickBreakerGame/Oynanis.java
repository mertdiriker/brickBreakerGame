package brickBreakerGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;

import javax.swing.JPanel;

public class Oynanis extends JPanel implements KeyListener,ActionListener{
	
	private boolean play = false;
	private int puan = 0;
	
	private int totalBricks = 21;
	
	private Timer timer;
	private int delay = 8;
	
	private int playerX = 310;
	
	private int ballposX = 120;
	private int ballposY = 350;
	private double ballXdir = -1;
	private double ballYdir = -2;
	private HaritaOlusturucu harita;
	
	
	public Oynanis() {
		
		harita = new HaritaOlusturucu(3, 7);
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay,this);
		timer.start();
		
			
	}
	
	public void paint(Graphics g) {
		//arkaplan
		g.setColor(Color.black);
		g.fillRect(1,1, 692, 592);
		
		//harita çizimi
		
		harita.draw((Graphics2D)g);
		
		//sýnýrlar
		
	    g.setColor(Color.yellow);
	    g.fillRect(0, 0, 3, 592);
	    g.fillRect(0, 0, 692, 3);
	    g.fillRect(691, 0, 3, 592);
	    
	    //puanlama
	    
	    g.setColor(Color.white);
	    g.setFont(new Font("serif",Font.BOLD,25));
	    g.drawString(""+puan,590,30);
	    
	    
	    //platform
	    
	    g.setColor(Color.green);
	    g.fillRect(playerX,550,100,8);
	    
	    //top
	    
	    g.setColor(Color.yellow);
	    g.fillOval(ballposX,ballposY,20,20);
	    
	    if(totalBricks <=0) {
	    	play=false;
	    	ballXdir = 0;
	    	ballYdir = 0;
	    	g.setColor(Color.red);
	    	g.setFont(new Font("serif",Font.BOLD,30));
	    	g.drawString("KAZANDIN",260,300);
	    	g.setFont(new Font("serif",Font.BOLD,30));
	    	g.drawString("LEVEL SEÇÝN (1,2,3,4,5) ",230,350);
	    	
	    	
	    }
	    
	    if(ballposY > 570) {
	    	play=false;
	    	ballXdir = 0;
	    	ballYdir = 0;
	    	g.setColor(Color.red);
	    	g.setFont(new Font("serif",Font.BOLD,30));
	    	g.drawString("OYUN BÝTTÝ ",190,300);
	    	g.setFont(new Font("serif",Font.BOLD,30));
	    	g.drawString("TEKRAR ÝÇÝN LEVEL SEÇ(1,2,3) ",230,350);
	    }
	    
	    g.dispose();
	    
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		timer.start();
		
		if(play) {
			
			if(new Rectangle(ballposX,ballposY, 20, 20).intersects(new Rectangle(playerX,550,100,8))) {
				ballYdir = -ballYdir;
			}
			
		    A: for(int i = 0; i < harita.harita.length;i++) {
				
				for(int j = 0 ; j<harita.harita[0].length;j++) {
					if(harita.harita[i][j] > 0 ) {
						int brickX = j * harita.brickGenislik + 80;
						int brickY = i * harita.brickYukseklik + 50;
						int brickGenislik = harita.brickGenislik;
						int brickYukseklik = harita.brickYukseklik;
						
						Rectangle rect = new Rectangle(brickX,brickY,brickGenislik,brickYukseklik);
						Rectangle ballRect = new Rectangle(ballposX,ballposY,20,20);
						Rectangle brickRect = rect;
						
						if(ballRect.intersects(brickRect)) {
							
							harita.setBrickValue(0,i,j);
							totalBricks--;
							puan += 5;
							
							if(ballposX + 19 <= brickRect.x || ballposX + 1 >= brickRect.x + brickRect.width) {
								ballXdir = -ballXdir-0.25;
							}
							else {
								ballYdir = -ballYdir;
							}
						  break A;
						}
						
					}
				}
			}
			
			ballposX += ballXdir;
			ballposY += ballYdir;
			if(ballposX > 0) {
				ballXdir = -ballXdir;
			}
			if(ballposY < 0) {
				ballYdir = -ballYdir;
			}
			if(ballposX < 670) {
				ballXdir = -ballXdir;
			}
		}
		repaint();
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		if(e.getKeyCode() == KeyEvent.VK_D) {
			if(playerX >=600) {
				playerX = 600;
			}
			else {
				moveRight();
			}
		}
        if(e.getKeyCode() == KeyEvent.VK_A) {
        	if(playerX < 10) {
				playerX = 10;
			}
			else {
				moveLeft();
			}
			
		}
        if(e.getKeyCode() == KeyEvent.VK_1) {
        	if(!play) {
        		play = true;
        		ballposX = 120;
        		ballposY = 350;
        		ballXdir = -1;
        		ballYdir = -2;
        		playerX = 310;
        		puan = 0;
        		totalBricks = 21;
        		harita = new HaritaOlusturucu(3,7);
        		
        		repaint();
        	}
        }
        if(e.getKeyCode() == KeyEvent.VK_2) {
        	if(!play) {
        		play = true;
        		ballposX = 120;
        		ballposY = 350;
        		ballXdir = -1.75;
        		ballYdir = -2.75;
        		playerX = 310;
        		puan = 0;
        		totalBricks = 24;
        		harita = new HaritaOlusturucu(3,8);
        		
        		repaint();
        	}
        }
        if(e.getKeyCode() == KeyEvent.VK_3) {
        	if(!play) {
        		play = true;
        		ballposX = 120;
        		ballposY = 350;
        		ballXdir = -2.5;
        		ballYdir = -3.5;
        		playerX = 310;
        		puan = 0;
        		totalBricks = 32;
        		harita = new HaritaOlusturucu(4,8);
        		
        		repaint();
        	}
        }
        if(e.getKeyCode() == KeyEvent.VK_4) {
        	if(!play) {
        		play = true;
        		ballposX = 120;
        		ballposY = 350;
        		ballXdir = -3;
        		ballYdir = -4;
        		playerX = 310;
        		puan = 0;
        		totalBricks = 40;
        		harita = new HaritaOlusturucu(5,8);
        		
        		repaint();
        	}
        }
        if(e.getKeyCode() == KeyEvent.VK_5) {
        	if(!play) {
        		play = true;
        		ballposX = 120;
        		ballposY = 350;
        		ballXdir = -3.5;
        		ballYdir = -4.5;
        		playerX = 310;
        		puan = 0;
        		totalBricks = 50;
        		harita = new HaritaOlusturucu(5,10);
        		
        		repaint();
        	}
        }
        
	}
	public void moveRight(){
	
	      play = true ;
	      playerX+=45;
	}
	public void moveLeft(){
		
	      play = true ;
	      playerX-=45;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	

}
