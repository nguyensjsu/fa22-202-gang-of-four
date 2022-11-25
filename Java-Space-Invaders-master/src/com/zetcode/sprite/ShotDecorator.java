package com.zetcode.sprite;

import java.awt.Image;

public class ShotDecorator implements IShot {

    private Shot shot ;
    protected boolean visible;
    protected Image image;
    protected boolean dying;

    int x;
    int y;
    int dx;

    public ShotDecorator( Shot s) {
        shot = s ;
    }

    public void initShot( int x, int y ) {
        shot.initShot( x, y ) ;
    }

    public void die() {
        shot.die() ;
    }
    
    public boolean isVisible() {
        return shot.isVisible() ;
    }

    public void setVisible( boolean visible ) {
        shot.setVisible( visible ) ;
    }

    public void setImage( Image image ) {
        shot.setImage( image ) ;
    }

    public Image getImage() {
        return shot.getImage() ;
    }

    public void setX( int x ) {
        shot.setX( x ) ;
    }

    public void setY( int y ) {
        shot.setY( y ) ;
    }

    public int getY() {
        return shot.getY() ;
    }

    public int getX() {
        return shot.getX() ;
    }

    public void setDying( boolean dying ) {
        shot.setDying( dying );
    }

    public boolean isDying() {
        return shot.isDying() ;
    }

}
