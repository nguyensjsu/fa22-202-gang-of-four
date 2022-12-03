package com.zetcode;

import com.zetcode.BackgroundMusic.IMusicStrategy;
import com.zetcode.BackgroundMusic.Music1;
import com.zetcode.BackgroundMusic.Music2;
import com.zetcode.BackgroundMusic.Music3;
import com.zetcode.DifficultyMode.ModeHandler;
import com.zetcode.LiveScore.LiveScoreObserver;
import com.zetcode.LiveScore.LiveScoreSubject;
import com.zetcode.TimerObserver.*;
import com.zetcode.Command.*;
import com.zetcode.sprite.Alien;
import com.zetcode.sprite.Bomb;
import com.zetcode.sprite.Player;
import com.zetcode.sprite.Shot;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import com.zetcode.MultipleLives.RemainingLivesObserver;
import com.zetcode.MultipleLives.RemainingLivesSubject;
import com.zetcode.TimerObserver.TimerSubject;
import com.zetcode.cheatcode.InputHandler;
import com.zetcode.cheatcode.KeyEventDispenseChain;

import com.zetcode.sprite.DoubleShot;
import com.zetcode.sprite.IShot ;
import com.zetcode.sprite.LevelUp;


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
    private LiveScoreSubject scoreSubject = new LiveScoreSubject(0);
    private LiveScoreObserver scoreObserver = new LiveScoreObserver(scoreSubject);

    // Timer Observer
    public long time = 0;
    private TimerSubject timerSubject = new TimerSubject(0);
    private TimerObserver timerObserver = new TimerObserver(timerSubject);

    // Multiple Lives Feature

    public int remainingLives = 3;
    private RemainingLivesObserver livesObserver;
    private RemainingLivesSubject livesSubject;


    // BackgroundMusicFeature
    public static IMusicStrategy musicStrategy;
    
    // Difficulty modes
    public ModeHandler mod;
    public int cr = 0;


    // JButtonFeature
    public static boolean isMusicPlaying = false;
    private static File f = null;
    private static Clip c = null;
    private static AudioInputStream as = null;
    boolean restartClicked = false;
    JButton pauseButton = new JButton("Pause");
    JButton resumeButton = new JButton("Resume");
    JButton restartButton = new JButton("Restart");
    JButton pauseMusic = new JButton("Toggle Sound");
    JButton toggleMusic = new JButton("Next Music");
    JButton hardMode = new JButton("Hard Mode");
    JButton easyMode = new JButton("Easy Mode");

	private KeyEventDispenseChain chain;

    public Board() {

        initBoard();
        gameInit();
    }

    private void initBoard() {

        PauseHandler settingHandler = new PauseHandler();
        ResumeHandler resumeHandler = new ResumeHandler();
        RestartHandler restartHandler = new RestartHandler();
        PauseMusicHandler pauseMusicHandler = new PauseMusicHandler();
        ToggleMusicHandler toggleMusicHandler = new ToggleMusicHandler();
        EasyButtonHandler easyHandler = new EasyButtonHandler();
        HardButtonHandler hardHandler = new HardButtonHandler();

        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new GridLayout(0, 5));
        buttonPane.setPreferredSize(new Dimension(Commons.BOARD_WIDTH, Commons.JBUTTON_HEIGHT));
        buttonPane.add(pauseButton);
        buttonPane.add(restartButton);
        buttonPane.add(pauseMusic);
        buttonPane.add(toggleMusic);
        buttonPane.add(hardMode);

        add(buttonPane);

        pauseButton.addActionListener(settingHandler);
        resumeButton.addActionListener(resumeHandler);
        restartButton.addActionListener(restartHandler);
        pauseMusic.addActionListener(pauseMusicHandler);
        toggleMusic.addActionListener(toggleMusicHandler);
        hardMode.addActionListener(hardHandler);
        easyMode.addActionListener(easyHandler);


        pauseButton.setFocusable(false);
        restartButton.setFocusable(false);
        resumeButton.setFocusable(false);
        pauseMusic.setFocusable(false);
        toggleMusic.setFocusable(false);
        hardMode.setFocusable(false);
        easyMode.setFocusable(false);
        addKeyListener(new TAdapter());
        setFocusable(true);
        d = new Dimension(Commons.BOARD_WIDTH, Commons.BOARD_HEIGHT);
        setBackground(Color.black);
        
        mod = new ModeHandler();

        timer = new Timer(Commons.DELAY, new GameCycle());
        timer.start();

        gameInit();
    }

    // JButtonFeature
    private class PauseHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            pauseGame();
        }
    }

    // JButtonFeature
    private void pauseGame() {
        Container parent = pauseButton.getParent();

        try {
            // Pause feature
            ButtonControl control = new ButtonControl();
            PauseButton pb = new PauseButton(parent, pauseButton, resumeButton, timer, musicStrategy);
            ICommand pause = new PauseButtonPressed(pb);
            //switch on
            control.setCommand(pause);
            control.pressButton();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
    // JButtonFeature
    private class ResumeHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            resumeGame();
        }
    }
    // JButtonFeature
    private void resumeGame() {
        Container parent = resumeButton.getParent();
        try {
            if(isMusicPlaying){
                try {
                    Board.stopMusic();
                    if(musicStrategy!= null){
                        musicStrategy.closeMusic();
                        isMusicPlaying = false;
                    }
                } catch (Exception io_E) {
                    // TODO Auto-generated catch block
                    io_E.printStackTrace();
                }
            }
            else{
                try {
                    Board.playMusic();
                } catch (Exception io_E) {
                    // TODO Auto-generated catch block
                    io_E.printStackTrace();
                }
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        parent.add(pauseButton, 0, 0);
        parent.remove(resumeButton);
        parent.revalidate();
        parent.repaint();
        timer.stop();
        timer = new Timer(Commons.PERIOD, new GameCycle());
        timer.start();

    }
    // JButtonFeature
    private class RestartHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                // Restart feature
                ButtonControl control = new ButtonControl();
                RestartButton rb = new RestartButton();
                ICommand restart = new RestartButtonPressed(rb);
                //switch on
                control.setCommand(restart);
                control.pressButton();
            }
            catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }
    // JButtonFeature
    private class PauseMusicHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            if(isMusicPlaying){
                try {
                    Board.stopMusic();
                    if(musicStrategy!= null){
                        musicStrategy.closeMusic();
                        isMusicPlaying = false;
                    }
                } catch (Exception io_E) {
                    // TODO Auto-generated catch block
                    io_E.printStackTrace();
                }
            }
            else{
                try {
                    Board.playMusic();
                } catch (Exception io_E) {
                    // TODO Auto-generated catch block
                    io_E.printStackTrace();
                }
            }
        }
    }
    // JButtonFeature
    private class ToggleMusicHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(musicStrategy == null) {
                musicStrategy = new Music1();
            }
            if(isMusicPlaying){
                try {
                    if(musicStrategy.toString() == "music1"){
                        Board.stopMusic();
                        musicStrategy.closeMusic();
                        musicStrategy = new Music2();
                    }
                    else if(musicStrategy.toString() == "music2"){
                        Board.stopMusic();
                        musicStrategy.closeMusic();
                        musicStrategy = new Music3();
                    }
                    else{
                        Board.stopMusic();
                        musicStrategy.closeMusic();
                        musicStrategy = new Music1();
                    }
                    musicStrategy.runMusic();
                } catch (Exception io_E) {
                    // TODO Auto-generated catch block
                    io_E.printStackTrace();
                }
            }
            else{
                try {
                    musicStrategy.closeMusic();
                    musicStrategy = new Music3();
                    musicStrategy.runMusic();
                } catch (Exception io_E) {
                    // TODO Auto-generated catch block
                    io_E.printStackTrace();
                }
            }

        }

    }
    public static void playMusic() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        try {
            stopMusic();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        f = new File("resources/music1.wav").getAbsoluteFile();
        as = AudioSystem.getAudioInputStream(f);
        c = AudioSystem.getClip();
        c.open(as);
        // Plays audio once
        c.start();
        c.loop(Clip.LOOP_CONTINUOUSLY);
        isMusicPlaying = true;
    }
    public static void stopMusic() throws Exception {
        if(musicStrategy != null) {
            musicStrategy.closeMusic();
        }
        if (c != null) // do not nest it to the previous condition ...
        {
            isMusicPlaying = false;
            c.stop();
            c.flush();
            c.close();
        }
    }
    
 // Difficulty Mode Feature
    private class EasyButtonHandler implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            changeToEasy();
        }
    }

    public void changeToEasy()  {
        Container parent = easyMode.getParent();

        cr = mod.change();

        parent.add(hardMode, 0, 4);
        parent.remove(easyMode);
        parent.revalidate();
        parent.repaint();


    }

    private class HardButtonHandler implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            changeToHard();
        }
    }

    public void changeToHard()  {
        Container parent = hardMode.getParent();

        cr = mod.change();

        parent.add(easyMode, 0, 4);
        parent.remove(hardMode);
        parent.revalidate();
        parent.repaint();


    }

    private void gameInit() {

        if(musicStrategy == null) {
            musicStrategy = new Music1();
        }
        if(!isMusicPlaying) {
            musicStrategy.runMusic();
        }

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
        lvlUp = new LevelUp(Commons.BOARD_WIDTH/2 - 6, Commons.OBSERVER_INIT_Y + 25) ;

        // observer
        scoreSubject.attach(scoreObserver);

        // timer observer
        timerSubject.attach(timerObserver);

        // LiveScoreFeature
//        scoreSubject = new LiveScoreSubject();
//        scoreObserver = new LiveScoreObserver(scoreSubject);

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
            g.drawImage(lvlUp.getImage(), lvlUp.getX(), lvlUp.getY()+20, this ) ;
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
        	
        	if(cr == 0) {
                g.setColor(Color.black);
                g.fillRect(0, 0, d.width, d.height);
                g.setColor(Color.green);
                g.drawString("Score: " + scoreObserver.getScore(), Commons.BOARD_WIDTH - 90, Commons.OBSERVER_INIT_Y);

            }
            else {
                g.setColor(Color.white);
                g.fillRect(0, 0, d.width, d.height);
                g.setColor(Color.green);
                g.drawString("Score: " + scoreObserver.getScore(), Commons.BOARD_WIDTH - 90, Commons.OBSERVER_INIT_Y);
            }

            g.drawString("Timer: " + timerObserver.getTime(), (Commons.BOARD_WIDTH/2 - 50), Commons.OBSERVER_INIT_Y);


            g.drawLine(0, Commons.GROUND,
                    Commons.BOARD_WIDTH, Commons.GROUND);

            drawAliens(g);
            drawPlayer(g);
            drawShot(g);
            drawBombing(g);
            drawLevelUp(g);
//            drawScore(currentScore, g);
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
        g.fillRect(50, Commons.BOARD_HEIGHT / 2 - 30, Commons.BOARD_WIDTH - 100, 50);
        g.setColor(Color.white);
        g.drawRect(50, Commons.BOARD_HEIGHT / 2 - 30, Commons.BOARD_WIDTH - 100, 50);

        var small = new Font("Helvetica", Font.BOLD, 14);
        var fontMetrics = this.getFontMetrics(small);

        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(message, (Commons.BOARD_WIDTH - fontMetrics.stringWidth(message)) / 2,
                Commons.BOARD_HEIGHT / 2);
    }

    // LiveScoreFeature

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

        // observer
        int tempScore = scoreObserver.getScore();

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
//                                scoreUp(currentScore);
                            }
                            if ((i < 23) && ((aliens.get(i+1).getX()) == (aliens.get(i).getX()+18))) {
                                aliens.get(i+1).setImage(ii.getImage());
                                aliens.get(i+1).setDying(true);
                                deaths++;
//                                scoreUp(currentScore);
                            }
                        }

                    }
                }
                // added score keeper
                scoreSubject.setState(deaths);
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
    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {

            player.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {

            player.keyPressed(e);

            int x = player.getX();
            int y = player.getY();

            int key = e.getKeyCode();

            if (key == KeyEvent.VK_SPACE) {

                if (inGame) {

                    if (!shot.isVisible()) {

                        shot = new Shot(x, y);
                    }
                }
            }
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
		//System.err.println(key);
		if (key == 16 || key == 66) {
			levelUpByCheatCode();
        } else if (this.chain!=null) {
        	this.chain.keyEvent(key);
        }
	}
}
