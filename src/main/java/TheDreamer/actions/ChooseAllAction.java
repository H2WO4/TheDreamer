package TheDreamer.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;

import java.util.ArrayList;

public class ChooseAllAction extends AbstractGameAction{

    private final ArrayList<AbstractCard> cards;

    public ChooseAllAction(ArrayList<AbstractCard> cards) {
        this.duration = 0.0F;
        this.actionType = ActionType.SPECIAL;
        this.cards = cards;
    }

    public void update() {
        for (AbstractCard c: cards) {
            this.addToBot(new ChooseAction(c));
        }

        this.isDone = true;
    }
}
