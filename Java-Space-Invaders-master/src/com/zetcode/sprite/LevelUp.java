package com.zetcode.sprite;

import java.awt.Image ;

import javax.swing.ImageIcon;

public class LevelUp extends Sprite {

    //private boolean hit ;

    public LevelUp ( int x, int y ) {
        initLevelUp( x, y );
    }

    public void initLevelUp( int x, int y ) {
        this.x = x ;
        this.y = y ;

        var levelUpImg = "Java-Space-Invaders-master/src/images/LevelUpIcon.png" ;
        var ii = new ImageIcon( levelUpImg ) ;
        Image tempImg = ii.getImage();
        Image tempImg1 = tempImg.getScaledInstance(12, 12, java.awt.Image.SCALE_SMOOTH) ;
        ii = new ImageIcon(tempImg1);

        setImage( ii.getImage() ) ;
    }

    /*public void setHit( boolean hit ) {
        this.hit = hit ;
    }

    public boolean isHit() {
        return this.hit ;
    }*/
}
