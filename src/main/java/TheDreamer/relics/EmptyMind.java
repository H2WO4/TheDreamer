package TheDreamer.relics;

import TheDreamer.cards.temp.Dream;
import basemod.abstracts.CustomRelic;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import TheDreamer.TheDreamer;
import TheDreamer.util.TextureLoader;

import static TheDreamer.TheDreamer.makeRelicOutlinePath;
import static TheDreamer.TheDreamer.makeRelicPath;

public class EmptyMind extends CustomRelic {


    public static final String ID = TheDreamer.makeID("EmptyMind");
    private static final Texture IMG = TextureLoader.getTexture(makeRelicPath("OilLamp.png"));
    private static final Texture OUTLINE = TextureLoader.getTexture(makeRelicOutlinePath("OilLamp.png"));

    public EmptyMind() {
        super(ID, IMG, OUTLINE, RelicTier.COMMON, LandingSound.CLINK);
    }

    @Override
    public void onEquip() {
        AbstractDungeon.player.masterHandSize -= 1;
    }

    @Override
    public void onUnequip() {
        AbstractDungeon.player.masterHandSize += 1;
    }

    @Override
    public void atTurnStartPostDraw() {
        this.addToBot(new MakeTempCardInHandAction(new Dream()));
        this.flash();
    }

    // Standard description
    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0];
    }
}
