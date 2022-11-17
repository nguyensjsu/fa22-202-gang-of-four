package invaders.events.commands;

import invaders.game.Game;
import invaders.utilities.Command;

public class MoveInvadersToNextLineAndChangeDirectionOfMovement implements Command {
    @Override
    public void Apply(Game game) {
        game.allInvaderShips
        .stream()
        .filter(invaderShip -> !invaderShip.IsGoingToChangeDirection())
        .forEach(invader -> {
            invader.ChangeDirectionOfMovement();
            invader.MoveToNextLine();
        });
    }
}
