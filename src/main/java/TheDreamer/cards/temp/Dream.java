package TheDreamer.cards.temp;

import TheDreamer.TheDreamer;
import TheDreamer.actions.ChooseAllAction;
import TheDreamer.cards.choices.DreamFantasy;
import TheDreamer.cards.choices.DreamReality;
import TheDreamer.powers.LucidityPower;
import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.common.ExhaustSpecificCardAction;
import com.megacrit.cardcrawl.actions.watcher.ChooseOneAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import java.util.ArrayList;

import static TheDreamer.TheDreamer.makeCardPath;

public class Dream extends CustomCard {

    public static final String ID = TheDreamer.makeID(Dream.class.getSimpleName());
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);

    public static final String IMG = makeCardPath("Skill.png");

    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;

    private static final CardRarity RARITY = CardRarity.SPECIAL;
    private static final CardTarget TARGET = CardTarget.NONE;
    private static final CardType TYPE = CardType.SKILL;
    public static final CardColor COLOR = CardColor.COLORLESS;

    private static final int COST = 0;

    public Dream() {
        super(ID, NAME, IMG, COST, DESCRIPTION, TYPE, COLOR, RARITY, TARGET);
        this.baseDamage = 4;
        this.damage = this.baseDamage;
        this.baseBlock = 4;
        this.block = this.baseBlock;
        this.isEthereal = true;
        this.exhaust = true;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        ArrayList<AbstractCard> choices = new ArrayList<>();
        choices.add(new DreamFantasy());
        choices.add(new DreamReality());
        if (this.upgraded) {
            for (AbstractCard c: choices) {
                c.upgrade();
            }
        }
        if (p.hasPower(LucidityPower.POWER_ID)) {
            this.addToBot(new ChooseAllAction(choices));
        }
        else {
            this.addToBot(new ChooseOneAction(choices));
        }
    }

    @Override
    public void triggerOnManualDiscard() {
        this.addToTop(new ExhaustSpecificCardAction(this, AbstractDungeon.player.discardPile));
    }

    @Override
    public void upgrade() {
        if (!upgraded) {
            this.upgradeName();
            this.upgradeDamage(2);
            this.upgradeBlock(2);
            this.initializeDescription();
        }
    }

    @Override
    public AbstractCard makeCopy() {
        return new Dream();
    }
}
