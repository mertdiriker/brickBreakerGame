package brickBreakerGame;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		
		JFrame obj = new JFrame();
		
		Oynanis oynanis = new Oynanis();
		obj.setBounds(10, 10, 710, 600);
		obj.setTitle("Breakout Ball");
		obj.setResizable(false);
		obj.setVisible(true);
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		obj.add(oynanis);
		
		
		// TODO Auto-generated method stub

	}

}
