package invaders.utilities;

import invaders.game.Game;

public interface Command {
    void Apply(Game game);
}
