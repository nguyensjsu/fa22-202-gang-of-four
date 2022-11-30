package com.zetcode;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.zetcode.BackgroundMusic.IMusicStrategy;
import com.zetcode.BackgroundMusic.Music3;
import com.zetcode.LiveScore.LiveScoreObserver;
import com.zetcode.LiveScore.LiveScoreSubject;
import com.zetcode.MultipleLives.RemainingLivesObserver;
import com.zetcode.MultipleLives.RemainingLivesSubject;
import com.zetcode.cheatcode.InputHandler;
import com.zetcode.cheatcode.KeyEventDispenseChain;
import com.zetcode.sprite.Alien;
import com.zetcode.sprite.Bomb;
import com.zetcode.sprite.DoubleShot;
import com.zetcode.sprite.IShot ;
import com.zetcode.sprite.LevelUp;
import com.zetcode.sprite.Player;
import com.zetcode.sprite.Shot;


public class Board extends JPanel implements KeyEventDispenseChain {

    private Dimension d;
    private List<Alien> aliens;
    private Player player;
    private IShot shot;
    private int shotType ;
    private LevelUp lvlUp ;
    private int direction = -1;
    private int deaths = 0;

    private boolean inGame = true;
    private String explImg = "Java-Space-Invaders-master/src/images/explosion.png";
    private String player2 = "Java-Space-Invaders-master/src/images/Player2.png" ;
    private String message = "Game Over";
    private Timer timer;
    private InputHandler inputHandler;

    // LiveScoreFeature
    public int currentScore = 0;
    private LiveScoreSubject scoreSubject;
    private LiveScoreObserver scoreObserver;

    // Multiple Lives Feature

    public int remainingLives = 3;
    private RemainingLivesObserver livesObserver;
    private RemainingLivesSubject livesSubject;


    // BackgroundMusicFeature
    private IMusicStrategy musicStrategy;

    
	private KeyEventDispenseChain chain;    
    
    public Board() {

        initBoard();
        gameInit();
    }

    private void initBoard() {

        //addKeyListener(new TAdapter());

        setFocusable(true);
        d = new Dimension(Commons.BOARD_WIDTH, Commons.BOARD_HEIGHT);
        setBackground(Color.black);

        timer = new Timer(Commons.DELAY, new GameCycle());
        timer.start();

        gameInit();
    }


    private void gameInit() {

        aliens = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 6; j++) {

                var alien = new Alien(Commons.ALIEN_INIT_X + 18 * j,
                        Commons.ALIEN_INIT_Y + 18 * i);
                aliens.add(alien);
            }
        }

        player = new Player();
        shot = new Shot();
        shotType = 0 ;
        lvlUp = new LevelUp(150, 25) ;

        // LiveScoreFeature
        scoreSubject = new LiveScoreSubject();
        scoreObserver = new LiveScoreObserver(scoreSubject);

        // Start the music
        musicStrategy = new Music3();
        musicStrategy.runMusic();

        // Remaining Lives Feature
        livesSubject = new RemainingLivesSubject(remainingLives);
        livesObserver = new RemainingLivesObserver(livesSubject);
        
        inputHandler = new InputHandler(this);
        
        player.setNextChain(livesSubject);
        livesSubject.setNextChain(this);
    }

    private void drawAliens(Graphics g) {

        for (Alien alien : aliens) {

            if (alien.isVisible()) {

                g.drawImage(alien.getImage(), alien.getX(), alien.getY(), this);
            }

            if (alien.isDying()) {

                alien.die();
            }
        }
    }

    private void drawLevelUp( Graphics g ) {
        if ( lvlUp.isVisible() ) {
            g.drawImage(lvlUp.getImage(), lvlUp.getX(), lvlUp.getY(), this ) ;
        }

        if ( lvlUp.isDying() ) {
            lvlUp.die() ;
        }
    }

    private void drawPlayer(Graphics g) {

        if (player.isVisible()) {

            g.drawImage(player.getImage(), player.getX(), player.getY(), this);
        }

        if (player.isDying()) {

            player.die();
            inGame = false;
        }
    }

    private void drawShot(Graphics g) {
        if (shot.isVisible()) {

            g.drawImage(shot.getImage(), shot.getX(), shot.getY(), this);
        }
    }

    private void drawBombing(Graphics g) {

        for (Alien a : aliens) {

            Bomb b = a.getBomb();

            if (!b.isDestroyed()) {

                g.drawImage(b.getImage(), b.getX(), b.getY(), this);
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);
    }

    private void doDrawing(Graphics g) {

        g.setColor(Color.black);
        g.fillRect(0, 0, d.width, d.height);
        g.setColor(Color.green);

        if (inGame) {

            g.drawLine(0, Commons.GROUND,
                    Commons.BOARD_WIDTH, Commons.GROUND);

            drawAliens(g);
            drawPlayer(g);
            drawShot(g);
            drawBombing(g);
            drawLevelUp(g);
            drawScore(currentScore, g);
            drawLives(remainingLives, g);

        } else {

            if (timer.isRunning()) {
                timer.stop();
            }

            gameOver(g);
        }

        Toolkit.getDefaultToolkit().sync();
    }

    private void gameOver(Graphics g) {

        g.setColor(Color.black);
        g.fillRect(0, 0, Commons.BOARD_WIDTH, Commons.BOARD_HEIGHT);

        g.setColor(new Color(0, 32, 48));
        g.fillRect(50, Commons.BOARD_WIDTH / 2 - 30, Commons.BOARD_WIDTH - 100, 50);
        g.setColor(Color.white);
        g.drawRect(50, Commons.BOARD_WIDTH / 2 - 30, Commons.BOARD_WIDTH - 100, 50);

        var small = new Font("Helvetica", Font.BOLD, 14);
        var fontMetrics = this.getFontMetrics(small);

        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(message, (Commons.BOARD_WIDTH - fontMetrics.stringWidth(message)) / 2,
                Commons.BOARD_WIDTH / 2);
    }

    // LiveScoreFeature
    private void drawScore(int currentScore , Graphics g) {
        scoreSubject.drawScore(currentScore, g);
    }

    private void scoreUp(int currentScore) {
        this.currentScore = scoreSubject.scoreUp(currentScore);
        //g.drawString("Score: "+ currentScore , Commons.BOARD_WIDTH - 90, 20);

    }

    // Remaining Lives Feature
    private void drawLives(int remainingLives, Graphics g)
    {
        livesSubject.drawLives(remainingLives,g);
    }

    private void reduceLives(int remainingLives)
    {
        this.remainingLives = livesSubject.reduceLives(remainingLives);
    }

    private void update() {

        if (deaths == Commons.NUMBER_OF_ALIENS_TO_DESTROY) {

            inGame = false;
            timer.stop();
            message = "Congratulations!!! You won.";
        }

        // player
        player.act();

        // shot
        if (shot.isVisible()) {

            int shotX = shot.getX();
            int shotY = shot.getY();

            //for (Alien alien : aliens) {
            for (int i = 0; i < aliens.size(); i++) {
                int alienX = aliens.get(i).getX();
                int alienY = aliens.get(i).getY();

                if (aliens.get(i).isVisible() && shot.isVisible()) {
                    if (shotX >= (alienX)
                            && shotX <= (alienX + Commons.ALIEN_WIDTH)
                            && shotY >= (alienY)
                            && shotY <= (alienY + Commons.ALIEN_HEIGHT)) {

                        var ii = new ImageIcon(explImg);
                        aliens.get(i).setImage(ii.getImage());
                        aliens.get(i).setDying(true);
                        deaths++;
                        shot.die();
                        if (shotType == 1 ) {
                            if ((i > 0) && ((aliens.get(i-1).getX()) == (aliens.get(i).getX()-18))) {
                                aliens.get(i-1).setImage(ii.getImage());
                                aliens.get(i-1).setDying(true);
                                deaths++;
                                scoreUp(currentScore);
                            }
                            if ((i < 23) && ((aliens.get(i+1).getX()) == (aliens.get(i).getX()+18))) {
                                aliens.get(i+1).setImage(ii.getImage());
                                aliens.get(i+1).setDying(true);
                                deaths++;
                                scoreUp(currentScore);
                            }
                        }
                        // LiveScoreFeature
                        //currentScore += 1;
                        //currentScore = scoreSubject.scoreUp(currentScore);
                        scoreUp(currentScore);
                    }
                }
            }

            int y = shot.getY();
            y -= 4;

            if (y < 0) {
                shot.die();
            } else {
                shot.setY(y);
            }

            // added for levelup
            if ( lvlUp.isVisible() && shot.isVisible() ) {
                int levelUpX = lvlUp.getX() ;
                int levelUpY = lvlUp.getY() ;
                if (shotX >= (levelUpX)
                        && shotX <= (levelUpX + Commons.LEVELUP_WIDTH)
                        && shotY >= (levelUpY)
                        && shotY <= (levelUpY + Commons.LEVELUP_HEIGHT)) {
                    var ii = new ImageIcon( explImg ) ;
                    lvlUp.setImage( ii.getImage() );
                    lvlUp.setDying(true);
                    shot.die() ;
                    var iiPlayer2 = new ImageIcon( player2 ) ;
                    Image tempImg = iiPlayer2.getImage() ;
                    Image tempImg2 = tempImg.getScaledInstance(12, 12 , java.awt.Image.SCALE_SMOOTH);
                    iiPlayer2 = new ImageIcon( tempImg2) ;
                    player.setImage( iiPlayer2.getImage() ) ;
                    shotType = 1 ;
                }
            }
        }

        // aliens

        for (Alien alien : aliens) {

            int x = alien.getX();

            if (x >= Commons.BOARD_WIDTH - Commons.BORDER_RIGHT && direction != -1) {

                direction = -1;

                Iterator<Alien> i1 = aliens.iterator();

                while (i1.hasNext()) {

                    Alien a2 = i1.next();
                    a2.setY(a2.getY() + Commons.GO_DOWN);
                }
            }

            if (x <= Commons.BORDER_LEFT && direction != 1) {

                direction = 1;

                Iterator<Alien> i2 = aliens.iterator();

                while (i2.hasNext()) {

                    Alien a = i2.next();
                    a.setY(a.getY() + Commons.GO_DOWN);
                }
            }
        }

        Iterator<Alien> it = aliens.iterator();

        while (it.hasNext()) {

            Alien alien = it.next();

            if (alien.isVisible()) {

                int y = alien.getY();

                if (y > Commons.GROUND - Commons.ALIEN_HEIGHT) {
                    inGame = false;
                    message = "Invasion!";
                }

                alien.act(direction);
            }
        }

        // bombs
        var generator = new Random();

        for (Alien alien : aliens) {

            int shot = generator.nextInt(15);
            Bomb bomb = alien.getBomb();

            if (shot == Commons.CHANCE && alien.isVisible() && bomb.isDestroyed()) {

                bomb.setDestroyed(false);
                bomb.setX(alien.getX());
                bomb.setY(alien.getY());
            }

            int bombX = bomb.getX();
            int bombY = bomb.getY();
            int playerX = player.getX();
            int playerY = player.getY();

            if (player.isVisible() && !bomb.isDestroyed()) {

                if (bombX >= (playerX)
                        && bombX <= (playerX + Commons.PLAYER_WIDTH)
                        && bombY >= (playerY)
                        && bombY <= (playerY + Commons.PLAYER_HEIGHT)) {

                	if(livesSubject.liveStatus()>1)
                    {
                        reduceLives(livesSubject.liveStatus());
                        bomb.setDestroyed(true);
                    }
                    else {

                        var ii = new ImageIcon(explImg);
                        player.setImage(ii.getImage());
                        player.setDying(true);
                        bomb.setDestroyed(true);
                        reduceLives(livesSubject.liveStatus());
                    }
                }
            }

            if (!bomb.isDestroyed()) {

                bomb.setY(bomb.getY() + 1);

                if (bomb.getY() >= Commons.GROUND - Commons.BOMB_HEIGHT) {

                    bomb.setDestroyed(true);
                }
            }
        }
    }

    private void doGameCycle() {

        update();
        repaint();
    }

    public void keyPressed(KeyEvent e) {
    	
    	player.keyPressed(e);

        int x = player.getX();
        int y = player.getY();

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_SPACE) {

            if (inGame) {

                if (!shot.isVisible()) {
                    if (shotType == 0 ) {
                        shot = new Shot(x, y);
                    }
                    else if (shotType == 1 ) {
                        shot = new DoubleShot( new Shot( x, y ) ) ;
                    }
                    shot.setVisible(inGame);
                }
            }
        }
    }

    public void keyReleased(KeyEvent e) {
        player.keyReleased(e);
    }
    

    private class GameCycle implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            doGameCycle();
        }
    }
    
    
    public void levelUpByCheatCode()
    {
        var ii = new ImageIcon( explImg ) ;
        lvlUp.setImage( ii.getImage() );
        lvlUp.setDying(true);
        shot.die() ;
        var iiPlayer2 = new ImageIcon( player2 ) ;
        Image tempImg = iiPlayer2.getImage() ;
        Image tempImg2 = tempImg.getScaledInstance(12, 12 , java.awt.Image.SCALE_SMOOTH);
        iiPlayer2 = new ImageIcon( tempImg2) ;
        player.setImage( iiPlayer2.getImage() ) ;
        shotType = 1 ;
    }
    
    @Override
	public void setNextChain(KeyEventDispenseChain nextChain) {
		this.chain=nextChain;
	}
	
	@Override
	public void keyEvent(int key) {
		// TODO Auto-generated method stub		
		System.err.println(key);
		if (key == 16 || key == 66) {
			levelUpByCheatCode();
        } else if (this.chain!=null) {		
        	this.chain.keyEvent(key);		
        }
	}
}
