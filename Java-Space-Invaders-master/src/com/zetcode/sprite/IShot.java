package com.zetcode.sprite;

import java.awt.Image;

public interface IShot {
    
    void initShot( int x, int y ) ;
    void die() ;
    boolean isVisible() ;
    void setVisible(boolean visible) ;
    void setImage(Image image) ;
    Image getImage() ;
    void setX(int x) ;
    void setY(int y) ;
    int getY() ;
    int getX() ;
    void setDying(boolean dying) ;
    boolean isDying() ;
    
}
