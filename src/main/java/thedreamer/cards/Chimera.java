package thedreamer.cards;

import gameplayatoms.actions.common.GiveChoicesAction;
import thedreamer.TheDreamer;
import thedreamer.cards.choices.ChimeraFantasy;
import thedreamer.cards.choices.ChimeraReality;
import thedreamer.characters.Dreamer;
import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static thedreamer.TheDreamer.makeCardPath;

public class Chimera extends CustomCard
{

    public static final String ID = TheDreamer.makeID(Chimera.class.getSimpleName());
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);

    public static final String IMG = makeCardPath("Image.png");

    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;

    private static final CardRarity RARITY = CardRarity.COMMON;
    private static final CardTarget TARGET = CardTarget.ENEMY;
    private static final CardType TYPE = CardType.ATTACK;
    public static final CardColor COLOR = Dreamer.Enums.COLOR_YELLOW;

    private static final int COST = 2;

    public Chimera()
    {
        super(ID, NAME, IMG, COST, DESCRIPTION, TYPE, COLOR, RARITY, TARGET);
        baseDamage = 8;
        damage = baseDamage;
        baseMagicNumber = 2;
        magicNumber = baseMagicNumber;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m)
    {
        addToBot(new GiveChoicesAction(new ChimeraFantasy(m), new ChimeraReality(m), null, upgraded));
    }

    @Override
    public void upgrade()
    {
        if (!upgraded)
        {
            upgradeName();
            upgradeDamage(2);
            upgradeMagicNumber(1);
            initializeDescription();
        }
    }

    @Override
    public AbstractCard makeCopy()
    {
        return new Chimera();
    }
}
