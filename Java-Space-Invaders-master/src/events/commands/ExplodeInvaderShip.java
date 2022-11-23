package events.commands;

import actors.InvaderShip;
import events.EventResolution;
import game.Game;
import resources.SoundEffectTracks;
import utilities.Command;
import utilities.SoundEffectPlayer;
import vfx.Explosion;

public class ExplodeInvaderShip implements Command {
    private final InvaderShip invaderShipThatIsHit;
    private final EventResolution eventResolution;

    public ExplodeInvaderShip(
        InvaderShip invaderShipThatIsHit,
        EventResolution eventResolution){
        this.invaderShipThatIsHit = invaderShipThatIsHit;
        this.eventResolution = eventResolution;
    }

    @Override
    public void Apply(Game game) {
        int indexOfExplodedShip = game.allInvaderShips.indexOf(invaderShipThatIsHit);
        if(indexOfExplodedShip >= 0){
            game.allExplosionVFX.add(new Explosion(invaderShipThatIsHit.GetLocation()));
            game.allInvaderShips.remove(indexOfExplodedShip);
            SoundEffectPlayer.Play(SoundEffectTracks.GetTrackPath(SoundEffectTracks.Track.InvaderExplosion));
            game.Score = game.Score + 100 + bonusPointsWithExponentialDecay(game.GetRuntimeInSeconds());
            if(game.allInvaderShips.isEmpty())
                eventResolution.Push(new EndGame(true));
        }
    }
    private static final int TotalBonusPoints = 1000;
    private static final double ExponentialDecayConstant = 0.1;
    private int bonusPointsWithExponentialDecay(long time){
        return (int)(TotalBonusPoints * Math.exp(-ExponentialDecayConstant * time));
    }
}
