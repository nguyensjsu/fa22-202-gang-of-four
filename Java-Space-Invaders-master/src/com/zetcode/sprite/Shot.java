package com.zetcode.sprite;

import java.awt.Image;

import javax.swing.ImageIcon;

import com.zetcode.utilites.SoundEffectPlayer;
import com.zetcode.utilites.SoundEffectTracks;

public class Shot implements IShot {

    private boolean visible;
    private Image image;
    private boolean dying;

    int x;
    int y;
    int dx;

    public Shot() {
    }

    public Shot(int x, int y) {

        initShot(x, y);
    }

    public void initShot(int x, int y) {

        var shotImg = "Java-Space-Invaders-master/src/images/shot.png";
        var ii = new ImageIcon(shotImg);
        setImage(ii.getImage());

        int H_SPACE = 6;
        setX(x + H_SPACE);

        int V_SPACE = 1;
        setY(y - V_SPACE);
        
        SoundEffectPlayer.Play(SoundEffectTracks.GetTrackPath(SoundEffectTracks.Track.InvaderShoot));
    }

    public void die() {

        visible = false;
    }

    public boolean isVisible() {

        return visible;
    }

    public void setVisible(boolean visible) {

        this.visible = visible;
    }

    public void setImage(Image image) {

        this.image = image;
    }

    public Image getImage() {

        return image;
    }

    public void setX(int x) {

        this.x = x;
    }

    public void setY(int y) {

        this.y = y;
    }

    public int getY() {

        return y;
    }

    public int getX() {

        return x;
    }

    public void setDying(boolean dying) {

        this.dying = dying;
    }

    public boolean isDying() {

        return this.dying;
    }
}
