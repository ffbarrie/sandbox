/**
 *
 */
package org.acm.barrie.sandbox.scorekeeper.model.game;

import java.util.ArrayList;
import java.util.List;

import org.acm.barrie.sandbox.scorekeeper.model.player.Player;

/**
 * @author Fred
 */
public class PlateAppearance {

    private int balls;
    private final List<Player> batters;
    private int fouls;
    private final List<Player> pitchers;
    private PlateAppearanceResult result;
    private int strikes;

    /**
     * Create a new Plate Appearance
     *
     * @param batter
     * @param pitcher
     */
    public PlateAppearance(final Player batter, final Player pitcher) {
        assert batter != null;
        assert pitcher != null;

        batters = new ArrayList<>();
        batters.add(batter);
        pitchers = new ArrayList<>();
        pitchers.add(pitcher);
        strikes = 0;
        balls = 0;
        fouls = 0;
        result = PlateAppearanceResult.UNKNOWN;
    }

    /**
     * Pitcher throws a ball
     */
    public void ball() {
        balls++;
        if (balls == 4) {
            result = PlateAppearanceResult.BASE_ON_BALLS;
        }
    }

    /**
     * The pitcher threw a strike, the batter did not swing.
     */
    public void calledStrike() {
        strikes++;
        if (strikes == 3) {
            result = PlateAppearanceResult.STRIKE_OUT_LOOKING;
        }
    }

    /**
     * Batter hits a foul ball.
     */
    public void foul() {
        fouls++;
        if (strikes < 2) {
            strikes++;
        }
    }

    public void foulBunt() {
        fouls++;
        strikes++;
        if (strikes == 3) {
            result = PlateAppearanceResult.STRIKE_OUT;
        }
    }

    /**
     * @return the balls
     */
    public int getBalls() {
        return balls;
    }

    /**
     * @return the batters
     */
    public List<Player> getBatters() {
        return batters;
    }

    /**
     * @return the fouls
     */
    public int getFouls() {
        return fouls;
    }

    /**
     * @return the pitchers
     */
    public List<Player> getPitchers() {
        return pitchers;
    }

    /**
     * @return the result of the plate appearance
     */
    public PlateAppearanceResult getResult() {
        return result;
    }

    /**
     * @return the strikes
     */
    public int getStrikes() {
        return strikes;
    }

    /**
     * The pitcher hit the batter
     */
    public void hitBatter() {
        result = PlateAppearanceResult.HIT_BY_PITCH;
    }

    /**
     * The pitcher throws an intentional ball.
     */
    public void intentionalBall() {
        balls++;
        if (balls == 4) {
            result = PlateAppearanceResult.BASE_ON_BALLS;
        }
    }

    /**
     * The batter is intentionally walked.
     */
    public void intentionalWalk() {
        balls = 4;
        result = PlateAppearanceResult.BASE_ON_BALLS;
    }

    public void pitchOut() {
        balls++;
        if (balls == 4) {
            result = PlateAppearanceResult.BASE_ON_BALLS;
        }
    }

    public void swingingStike() {
        strikes++;
        if (strikes == 3) {
            result = PlateAppearanceResult.STRIKE_OUT;
        }
    }

    @Override
    public String toString() {
        final String info = result == PlateAppearanceResult.UNKNOWN
                ? String.format("%s-%s", Integer.valueOf(balls), Integer.valueOf(strikes))
                : result.getSymbol();
        return String.format("%s vs %s (%s)", batters.get(batters.size() - 1), pitchers.get(pitchers.size() - 1), info);
    }

    /**
     * Result of a plate appearance.
     *
     * @author Fred
     */
    public enum PlateAppearanceResult {

        /**
         * Automatic double. For example, a fair ball that bounces into the stands.
         */
        AUTOMATIC_DOUBLE("G2B"),

        /**
         * Batter reaches first base on four balls.
         */
        BASE_ON_BALLS("BB"),

        /**
         * Catcher interferes with the play.
         */
        DEFENSIVE_INTERFERENCE("DI"),

        /**
         * Defense obstructs the play.
         */
        DEFENSIVE_OBSTRUCTION("DO"),

        /**
         * Double hit.
         */
        DOUBLE("2B"),

        /**
         * Batter reaches on an error.
         */
        ERROR("E"),

        /**
         * Batter reaches on a fielders choice.
         */
        FIELDERS_CHOICE("FC"),

        /**
         * Batter is out with a fly ball.
         */
        FLY_OUT("F"),

        /**
         * Batter is out with a ground out.
         */
        GROUND_OUT(""),

        /**
         * Ground rule double. When an actual ground rule states a double.
         */
        GROUND_RULE_DOUBLE("2B"),

        /**
         * Batter is hit by a pitch and is awarded first base.
         */
        HIT_BY_PITCH("HBP"),

        /**
         * Home run
         */
        HOME_RUN("HR"),

        /**
         * The offense interferes with the play.
         */
        OFFENSIVE_INTERFERENCE("OI"),

        /**
         * Batter hits a bunt ball to advance a base runner
         */
        SACRIFICE_BUNT("SB"),

        /**
         * Batter hits a sacrifice fly that scores a run from third.
         */
        SACRIFICE_FLY("SF"),

        /**
         * Single hit.
         */
        SINGLE("1B"),

        /**
         * Batter strikes out. Catcher catches pitch or runner on first with less than
         * two outs.
         */
        STRIKE_OUT("K"),

        /**
         * Batter strikes out. Catcher drops pitch and batter is tagged by catcher or
         * batter walks away.
         */
        STRIKE_OUT_CATCHER_PUT_OUT("K U2"),

        /**
         * Batter strikes out. Catcher drops pitch and catcher throws out the runner at
         * first.
         */
        STRIKE_OUT_CATCHER_TO_FIRST("K 2-3"),

        /**
         * Batter strikes out looking.
         */
        STRIKE_OUT_LOOKING("ꓘ"),

        /**
         * Batter strikes out but reaches first base on a passed ball not being caught
         * by the catcher.
         */
        STRIKE_OUT_PASSED_BALL("K E2"),

        /**
         * Batter strikes out but reaches first base on a wild pitch not being caught by
         * the catcher.
         */
        STRIKE_OUT_WILD_PITCH("K E1"),

        /**
         * Triple hit.
         */
        TRIPLE("3B"),

        /**
         * Unknown result. Still in progress? etc.
         */
        UNKNOWN("");

        private String symbol;

        private PlateAppearanceResult(final String symbol) {
            this.symbol = symbol;
        }

        public String getSymbol() {
            return symbol;
        }

    }
}
