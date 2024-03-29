package thedreamer.cards;

import thedreamer.TheDreamer;
import thedreamer.actions.RecallAction;
import thedreamer.characters.Dreamer;
import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static thedreamer.TheDreamer.makeCardPath;

public class Memory extends CustomCard
{

    public static final String ID = TheDreamer.makeID(Memory.class.getSimpleName());
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);

    public static final String IMG = makeCardPath("Memory.png");

    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;

    private static final CardRarity RARITY = CardRarity.UNCOMMON;
    private static final CardTarget TARGET = CardTarget.NONE;
    private static final CardType TYPE = CardType.SKILL;
    public static final CardColor COLOR = Dreamer.Enums.COLOR_YELLOW;

    private static final int COST = 1;

    public Memory()
    {
        super(ID, NAME, IMG, COST, DESCRIPTION, TYPE, COLOR, RARITY, TARGET);
        baseMagicNumber = 3;
        magicNumber = baseMagicNumber;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m)
    {
        addToBot(new RecallAction(magicNumber));
    }

    @Override
    public void upgrade()
    {
        if (!upgraded)
        {
            upgradeName();
            upgradeMagicNumber(1);
            initializeDescription();
        }
    }

    @Override
    public AbstractCard makeCopy()
    {
        return new Memory();
    }
}
