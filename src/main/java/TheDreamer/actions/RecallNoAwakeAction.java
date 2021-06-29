package TheDreamer.actions;

import TheDreamer.cards.AwakeningCard;
import com.evacipated.cardcrawl.mod.stslib.actions.common.SelectCardsAction;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

public class RecallNoAwakeAction extends AbstractGameAction{

    private final int potency;

    public RecallNoAwakeAction(int potency) {
        this.duration = 0.0F;
        this.actionType = ActionType.CARD_MANIPULATION;
        this.potency = potency;
    }

    public void update() {
        AbstractPlayer p = AbstractDungeon.player;
        CardGroup temp = new CardGroup(CardGroup.CardGroupType.UNSPECIFIED);
        int end = Math.min(this.potency, p.discardPile.size());
        for (int i = 0; i < end; i++) {
            temp.addToTop(p.discardPile.getNCardFromTop(p.discardPile.size() - i - 1));
        }
        this.addToBot(new SelectCardsAction(temp.group, end, "", true, (card) -> true, (cards) -> {
            for (AbstractCard c: cards) {
                AbstractDungeon.actionManager.addToTop(new MoveToDrawAction(c, p.discardPile));
            }
        }));

        this.isDone = true;
    }
}
