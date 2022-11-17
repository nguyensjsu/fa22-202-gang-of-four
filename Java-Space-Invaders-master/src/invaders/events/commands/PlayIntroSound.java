package invaders.events.commands;

import invaders.game.Game;
import invaders.utilities.Command;
import invaders.utilities.SoundEffectPlayer;
import invaders.utilities.SoundEffectTracks;

public class PlayIntroSound implements Command {
    @Override
    public void Apply(Game game) {
        SoundEffectPlayer.Play(SoundEffectTracks.GetTrackPath(SoundEffectTracks.Track.IntroSound));
    }
}
