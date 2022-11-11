package com.zetcode.sprite;

import javax.swing.ImageIcon;

public class LevelUp extends Sprite {

    private boolean hit ;
    
    public LevelUp ( int x, int y ) {
        initLevelUp( x, y );
    }

    public void initLevelUp( int x, int y ) {
        this.x = x ;
        this.y = y ;

        var levelUpImg = "src/images/LevelUpIcon.png" ;
        var ii = new ImageIcon( levelUpImg ) ;

        setImage( ii.getImage() ) ;
    }

    public void setHit( boolean hit ) {
        this.hit = hit ;
    }

    public boolean isHit() {
        return this.hit ;
    }

}
