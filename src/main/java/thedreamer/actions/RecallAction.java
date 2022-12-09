package thedreamer.actions;

import gameplayatoms.actions.common.MoveRandDrawAction;
import thedreamer.cards.archetypes.AwakeningCard;
import com.evacipated.cardcrawl.mod.stslib.actions.common.SelectCardsAction;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

public class RecallAction extends AbstractGameAction
{

    private final int potency;
    private final boolean doRecall;

    public RecallAction(int potency)
    {
        duration = 0.0F;
        actionType = ActionType.CARD_MANIPULATION;
        this.potency = potency;
        doRecall = true;
    }

    public RecallAction(int potency, boolean doRecall)
    {
        duration = 0.0F;
        actionType = ActionType.CARD_MANIPULATION;
        this.potency = potency;
        this.doRecall = doRecall;
    }

    public void update()
    {
        AbstractPlayer p = AbstractDungeon.player;
        CardGroup temp = new CardGroup(CardGroup.CardGroupType.UNSPECIFIED);
        int end = Math.min(potency, p.discardPile.size());
        for (int i = 0; i < end; i++)
            temp.addToTop(p.discardPile.group.get(i));

        addToBot(new SelectCardsAction(temp.group, end, "", true, (card) -> true, (cards) ->
        {
            for (AbstractCard c : cards)
            {
                AbstractDungeon.actionManager.addToTop(new MoveRandDrawAction(c, p.discardPile));

                if (doRecall && c instanceof AwakeningCard)
                    ((AwakeningCard) c).onRecall();
            }
        }));


        isDone = true;
    }
}
