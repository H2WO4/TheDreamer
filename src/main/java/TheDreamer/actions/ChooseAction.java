package TheDreamer.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;

public class ChooseAction extends AbstractGameAction{

    private final AbstractCard card;

    public ChooseAction(AbstractCard cardID) {
        this.duration = 0.0F;
        this.actionType = AbstractGameAction.ActionType.SPECIAL;
        this.card = cardID;
    }

    public void update() {
        card.applyPowers();
        card.onChoseThisOption();

        this.isDone = true;
    }
}
