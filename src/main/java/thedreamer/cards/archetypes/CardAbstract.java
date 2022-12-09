package thedreamer.cards.archetypes;

import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.common.DiscardSpecificCardAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public abstract class CardAbstract extends CustomCard
{
    public CardAbstract(final String id,
                        final String name,
                        final String img,
                        final int cost,
                        final String rawDescription,
                        final CardType type,
                        final CardColor color,
                        final CardRarity rarity,
                        final CardTarget target)
    {
        super(id, name, img, cost, rawDescription, type, color, rarity, target);
    }

    @Override
    public boolean canUse(AbstractPlayer p, AbstractMonster m)
    {
        cantUseMessage = "I cannot play an abstract card.";
        return false;
    }

    @Override
    public void triggerWhenDrawn()
    {
        addToTop(new DrawCardAction(1));
        addToTop(new DiscardSpecificCardAction(this));
    }
}