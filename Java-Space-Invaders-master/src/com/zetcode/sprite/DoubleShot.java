package com.zetcode.sprite;

import javax.swing.ImageIcon ;

public class DoubleShot extends ShotDecorator {


    public DoubleShot( Shot s ) {
        super( s ) ;
        doubleShotImg();
    }

    public void doubleShotImg() {
        var shotImg = "src/images/shot2.png";
        var ii = new ImageIcon(shotImg);
        setImage(ii.getImage());
    }

}
