package thedreamer.relics;

import thedreamer.TheDreamer;
import thedreamer.cards.temp.Dream;
import thedreamer.util.TextureLoader;
import basemod.abstracts.CustomRelic;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;

import static thedreamer.TheDreamer.makeRelicOutlinePath;
import static thedreamer.TheDreamer.makeRelicPath;

public class EmptyMind extends CustomRelic
{


    public static final String ID = TheDreamer.makeID(EmptyMind.class.getSimpleName());
    private static final Texture IMG = TextureLoader.getTexture(makeRelicPath("OilLamp.png"));
    private static final Texture OUTLINE = TextureLoader.getTexture(makeRelicOutlinePath("OilLamp.png"));

    public EmptyMind()
    {
        super(ID, IMG, OUTLINE, RelicTier.STARTER, LandingSound.CLINK);
    }

    @Override
    public void atTurnStartPostDraw()
    {
        addToBot(new MakeTempCardInHandAction(new Dream()));
        flash();
    }

    // Standard description
    @Override
    public String getUpdatedDescription()
    {
        return DESCRIPTIONS[0];
    }
}
