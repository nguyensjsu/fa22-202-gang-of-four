package com.zetcode;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class SpaceInvaders extends JFrame  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static SpaceInvaders instance = null;
	public Board board = new Board();
	
	
	public static int left_moves = 5;
	public static int right_moves = 5;
	

	public static synchronized SpaceInvaders getInstance()  {
		if (instance == null) {
			instance = new SpaceInvaders();
		}
		return instance;			
	}
	
    private SpaceInvaders() {
        initUI();
    }

    private void initUI() {
        add(board);
        setTitle("Space Invaders");
        setSize(Commons.BOARD_WIDTH, Commons.BOARD_HEIGHT);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            var ex = SpaceInvaders.getInstance();
            ex.setVisible(true);
            SoundEffectPlayer.Play(SoundEffectTracks.GetTrackPath(SoundEffectTracks.Track.IntroSound));
        });
    }
}
