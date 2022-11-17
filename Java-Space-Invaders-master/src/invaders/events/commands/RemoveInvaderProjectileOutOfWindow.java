package invaders.events.commands;

import invaders.actors.InvaderProjectile;
import invaders.game.Game;
import invaders.utilities.Command;

public class RemoveInvaderProjectileOutOfWindow implements Command {
    private final InvaderProjectile invaderProjectileOutOfWindow;

    public RemoveInvaderProjectileOutOfWindow(InvaderProjectile invaderProjectileOutOfWindow){
        this.invaderProjectileOutOfWindow = invaderProjectileOutOfWindow;
    }

    @Override
    public void Apply(Game game) {
        int indexOfDeadProjectile = game.allInvaderProjectiles.indexOf(invaderProjectileOutOfWindow);
        game.allInvaderProjectiles.remove(indexOfDeadProjectile);
    }
}
