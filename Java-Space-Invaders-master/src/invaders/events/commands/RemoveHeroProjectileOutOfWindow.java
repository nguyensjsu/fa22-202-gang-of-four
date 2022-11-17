package invaders.events.commands;

import invaders.actors.HeroProjectile;
import invaders.game.Game;
import invaders.utilities.Command;

public class RemoveHeroProjectileOutOfWindow implements Command {
    private final HeroProjectile heroProjectileOutOfWindow;

    public RemoveHeroProjectileOutOfWindow(HeroProjectile heroProjectileOutOfWindow){
        this.heroProjectileOutOfWindow = heroProjectileOutOfWindow;
    }

    @Override
    public void Apply(Game game) {
        int indexOfDeadProjectile = game.allHeroProjectiles.indexOf(heroProjectileOutOfWindow);
        game.allHeroProjectiles.remove(indexOfDeadProjectile);
    }
}
