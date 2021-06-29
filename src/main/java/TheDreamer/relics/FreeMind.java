package TheDreamer.relics;

import TheDreamer.TheDreamer;
import TheDreamer.cards.temp.Dream;
import TheDreamer.util.TextureLoader;
import basemod.abstracts.CustomRelic;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

import static TheDreamer.TheDreamer.makeRelicOutlinePath;
import static TheDreamer.TheDreamer.makeRelicPath;

public class FreeMind extends CustomRelic {


    public static final String ID = TheDreamer.makeID("EmptyMind");
    private static final Texture IMG = TextureLoader.getTexture(makeRelicPath("OilLamp.png"));
    private static final Texture OUTLINE = TextureLoader.getTexture(makeRelicOutlinePath("OilLamp.png"));

    public FreeMind() {
        super(ID, IMG, OUTLINE, RelicTier.COMMON, LandingSound.CLINK);
    }

    @Override
    public void atTurnStartPostDraw() {
        AbstractCard dream = new Dream();
        dream.upgrade();
        this.addToBot(new MakeTempCardInHandAction(dream));
        this.flash();
    }

    @Override
    public boolean canSpawn() {
        return AbstractDungeon.player.hasRelic(EmptyMind.ID);
    }

    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0];
    }
}
