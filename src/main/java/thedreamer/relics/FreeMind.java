package thedreamer.relics;

import thedreamer.TheDreamer;
import thedreamer.cards.temp.Dream;
import thedreamer.util.TextureLoader;
import basemod.abstracts.CustomRelic;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

import static thedreamer.TheDreamer.makeRelicOutlinePath;
import static thedreamer.TheDreamer.makeRelicPath;

public class FreeMind extends CustomRelic
{


    public static final String ID = TheDreamer.makeID(FreeMind.class.getSimpleName());
    private static final Texture IMG = TextureLoader.getTexture(makeRelicPath("OilLamp.png"));
    private static final Texture OUTLINE = TextureLoader.getTexture(makeRelicOutlinePath("OilLamp.png"));

    public FreeMind()
    {
        super(ID, IMG, OUTLINE, RelicTier.BOSS, LandingSound.CLINK);
    }

    @Override
    public void onEquip()
    {
        AbstractDungeon.player.masterHandSize += 1;
    }

    @Override
    public void onUnequip()
    {
        AbstractDungeon.player.masterHandSize -= 1;
    }

    @Override
    public void atTurnStartPostDraw()
    {
        AbstractCard dream = new Dream();
        dream.upgrade();
        addToBot(new MakeTempCardInHandAction(dream));
        flash();
    }

    @Override
    public boolean canSpawn()
    {
        return AbstractDungeon.player.hasRelic(EmptyMind.ID);
    }

    @Override
    public String getUpdatedDescription()
    {
        return DESCRIPTIONS[0];
    }
}
