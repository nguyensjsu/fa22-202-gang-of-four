package com.zetcode.sprite;

import java.awt.Image;

import javax.swing.ImageIcon ;

public class DoubleShot extends ShotDecorator {


    public DoubleShot( Shot s ) {
        super( s ) ;
        doubleShotImg();
    }

    public void doubleShotImg() {
        var shotImg = "Java-Space-Invaders-master/src/images/shot2.png";
        var ii = new ImageIcon(shotImg);
        Image tempImg = ii.getImage();
        Image tempImg2 = tempImg.getScaledInstance(3, 12, java.awt.Image.SCALE_SMOOTH);
        ii = new ImageIcon(tempImg2);
        setImage(ii.getImage());
    }

}
