package invaders.events.commands;

import invaders.actors.HeroShip;
import invaders.actors.HeroProjectile;
import invaders.game.Game;
import invaders.utilities.*;
import invaders.utilities.Command;
import invaders.utilities.SoundEffectPlayer;

import java.awt.*;

public class HeroShipShoot implements Command {
    private final Point heroShipLocation;
    public HeroShipShoot(Point heroShipLocation) {
        this.heroShipLocation = heroShipLocation;
    }

    @Override
    public void Apply(Game game) {
        Point projectileLocation = new Point(
            (int)(heroShipLocation.getX() + HeroShip.WIDTH / 2 * HeroShip.DRAWING_SCALE),
            (int)(heroShipLocation.getY()));
        game.allHeroProjectiles.add(new HeroProjectile(projectileLocation));
        SoundEffectPlayer.Play(SoundEffectTracks.GetTrackPath(SoundEffectTracks.Track.HeroShoot));
    }
}
