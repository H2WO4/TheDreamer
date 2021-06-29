package TheDreamer.patches;

import TheDreamer.cards.Thought;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.EmptyDeckShuffleAction;
import com.megacrit.cardcrawl.actions.common.ExhaustSpecificCardAction;
import com.megacrit.cardcrawl.actions.common.ShuffleAction;
import com.megacrit.cardcrawl.actions.defect.ShuffleAllAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

@SpirePatch(clz = ShuffleAction.class, method = "update")
@SpirePatch(clz = EmptyDeckShuffleAction.class, method = "update")
@SpirePatch(clz = ShuffleAllAction.class, method = "update")
public class Shuffle {
    public static void Prefix(AbstractGameAction __instance) {
        for (AbstractCard c: AbstractDungeon.player.discardPile.group) {
            AbstractDungeon.actionManager.addToTop(new ExhaustSpecificCardAction(c, AbstractDungeon.player.drawPile));
        }
    }
}