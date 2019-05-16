package org.acm.barrie.sandbox.scorekeeper.model.game;

import org.acm.barrie.sandbox.scorekeeper.model.game.PlateAppearance.PlateAppearanceResult;
import org.acm.barrie.sandbox.scorekeeper.model.league.Division;
import org.acm.barrie.sandbox.scorekeeper.model.player.Player;
import org.acm.barrie.sandbox.scorekeeper.model.team.Team;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestPlateAppearance {

    private static Player batter;
    private static Player pitcher;
    private static Team team;

    @BeforeClass
    public static void setup() {
        TestPlateAppearance.team = new Team("tb", "test", Division.PCL_PN);

        TestPlateAppearance.batter = new Player(TestPlateAppearance.team, 5);
        TestPlateAppearance.batter.setLastName("batter");

        TestPlateAppearance.pitcher = new Player(TestPlateAppearance.team, 6);
        TestPlateAppearance.pitcher.setLastName("pitcher");
    }

    @Test
    public void testBaseOnBalls() {
        final PlateAppearance pa = new PlateAppearance(TestPlateAppearance.batter, TestPlateAppearance.pitcher);
        pa.ball();
        pa.calledStrike();
        pa.ball();
        pa.calledStrike();
        pa.foul();
        pa.ball();
        pa.ball();

        Assert.assertEquals(4, pa.getBalls());
        Assert.assertEquals(2, pa.getStrikes());
        Assert.assertEquals(1, pa.getFouls());
        Assert.assertEquals(PlateAppearanceResult.BASE_ON_BALLS, pa.getResult());
    }

    @Test
    public void testConstructor() {
        final PlateAppearance pa = new PlateAppearance(TestPlateAppearance.batter, TestPlateAppearance.pitcher);
        Assert.assertEquals(PlateAppearanceResult.UNKNOWN, pa.getResult());
    }

    @Test
    public void testConstructorWithNulls() {
        try {
            new PlateAppearance(null, null);
            Assert.fail("Null pointer exception should have been thrown");
        } catch (final AssertionError e) {
            // ignore
        }

        try {
            new PlateAppearance(TestPlateAppearance.batter, null);
            Assert.fail("Null pointer exception should have been thrown");
        } catch (final AssertionError e) {
            // ignore
        }
    }

    @Test
    public void testStrikeOut() {
        final PlateAppearance pa = new PlateAppearance(TestPlateAppearance.batter, TestPlateAppearance.pitcher);
        Assert.assertEquals("batter vs pitcher (0-0)", pa.toString());

        pa.ball();
        Assert.assertEquals("batter vs pitcher (1-0)", pa.toString());

        pa.calledStrike();
        Assert.assertEquals("batter vs pitcher (1-1)", pa.toString());

        pa.calledStrike();
        Assert.assertEquals("batter vs pitcher (1-2)", pa.toString());

        pa.calledStrike();
        Assert.assertEquals("batter vs pitcher (ꓘ)", pa.toString());

        Assert.assertEquals(1, pa.getBalls());
        Assert.assertEquals(3, pa.getStrikes());
        Assert.assertEquals(PlateAppearanceResult.STRIKE_OUT_LOOKING, pa.getResult());

    }

}
