package thedreamer.patches;

import gameplayatoms.actions.common.ShowExhaustAction;
import thedreamer.cards.Thought;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.EmptyDeckShuffleAction;
import com.megacrit.cardcrawl.actions.common.ShuffleAction;
import com.megacrit.cardcrawl.actions.defect.ShuffleAllAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

@SpirePatch(clz = ShuffleAction.class, method = "update")
@SpirePatch(clz = EmptyDeckShuffleAction.class, method = "update")
@SpirePatch(clz = ShuffleAllAction.class, method = "update")
public class Shuffle
{
    public static void Prefix(AbstractGameAction __instance)
    {
        AbstractPlayer p = AbstractDungeon.player;
        for (AbstractCard c : AbstractDungeon.player.discardPile.group)
            if (c.cardID.equals(Thought.ID))
                p.limbo.addToTop(c);

        for (AbstractCard c : p.limbo.group)
        {
            p.discardPile.removeCard(c);
            AbstractDungeon.actionManager.addToTop(new ShowExhaustAction(c, p.limbo));
        }
    }
}
