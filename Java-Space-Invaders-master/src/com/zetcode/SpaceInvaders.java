package com.zetcode;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class SpaceInvaders extends JFrame {
	
	private Board board = new Board();
	private static SpaceInvaders instance = null;
	
	public int left_moves = 2;
	public int right_moves = 2;
	
	public synchronized static SpaceInvaders getInstance()
	{
		if (instance == null) {
			instance = new SpaceInvaders();
			instance.showGame();
		}
		return instance;
	}
	
	public void restartGame()
	{
		this.setVisible(false);
		try {
			remove(board);
			board = new Board();
			
			showGame();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
    private SpaceInvaders() {

    }

    private void showGame() {
        add(board);
        setTitle("Space Invaders");
        setSize(Commons.BOARD_WIDTH, Commons.BOARD_HEIGHT);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        
        this.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
        	SpaceInvaders.getInstance();
        });
    }
}
